/*
 * Md Ashraful Alam
 * 10/8/20, 12:56 AM
 */

package com.ashraf.awslocal.stack.sqs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class SqsOperations {

    private final SqsClient sqsClient;

    public void createQueue(String queueName, boolean isFifo) {
        try {
            var createQueueRequest = getCreateQueueRequest(queueName, isFifo);
            var result = sqsClient.createQueue(createQueueRequest);

            log.info("SqsOperations:: createQueue:: queueUrl: {}", result.queueUrl());
        } catch (Exception e) {
            log.info("SqsOperations:: createQueue:: ERROR: {}", e.toString());
        }
    }

    public void enQueue(String queueUrl, String message) {
        var msgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();
        sendMessageToQueue(msgRequest);
    }

    private void sendMessageToQueue(SendMessageRequest msgRequest) {
        try {
            var enQueueResult = sqsClient.sendMessage(msgRequest);

            log.info("SqsOperations:: enQueue:: enQueueResult: {}", enQueueResult.toString());
        } catch (Exception e) {
            log.info("SqsOperations:: enQueue:: ERROR: {}", e.toString());
        }
    }

    public void enQueue(String queueUrl, String message, String messageGroupId, String deDuplicationId) {
        var msgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .messageGroupId(messageGroupId)
                .messageDeduplicationId(deDuplicationId)
                .build();
        sendMessageToQueue(msgRequest);
    }

    public void enQueueBatch(String queueUrl, String id, String messageDeduplicationId, List<String> messages) {

        var sendMessageBatchRequestEntries = messages.stream()
                .map(message ->
                        SendMessageBatchRequestEntry.builder()
                                .id(id +"_"+ System.currentTimeMillis())
                                .messageDeduplicationId(messageDeduplicationId)
                                .messageBody(message)
                                .build()
                ).collect(Collectors.toList());

        var sendMessageBatchRequest = SendMessageBatchRequest.builder()
                .queueUrl(queueUrl)
                .entries(sendMessageBatchRequestEntries)
                .build();
        sqsClient.sendMessageBatch(sendMessageBatchRequest);
    }

    public Optional<String> deQueue(String queueUrl) {
        var receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .build();
        return sqsClient.receiveMessage(receiveMessageRequest)
                .messages()
                .stream()
                .map(message -> {
                    log.info("SqsOperations:: deQueue:: message: {}", message.toString());
                    deleteQueueMesssage(queueUrl, message.receiptHandle());
                    return message.body();
                }).findFirst();

    }

    private void deleteQueueMesssage(String queueUrl, String receiptHandle) {
        var deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(queueUrl)
                .receiptHandle(receiptHandle)
                .build();
        sqsClient.deleteMessage(deleteMessageRequest);
    }

    public List<String> getQueueList(String prefix) {

        try {
            var listQueuesRequest = ListQueuesRequest.builder()
                    .queueNamePrefix(prefix)
                    .build();

            return sqsClient.listQueues(listQueuesRequest)
                    .queueUrls()
                    .stream()
                    .peek(url -> log.info("SqsOperations:: getQueueList:: queueUrl: {}", url))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.info("SqsOperations:: getQueueList:: ERROR: {}", e.toString());
        }
        return List.of();
    }

    private CreateQueueRequest getCreateQueueRequest(String queueName, boolean isFifo) {

        return isFifo ? CreateQueueRequest.builder()
                .queueName(queueName)
                .attributesWithStrings(getfifoQueueAttributes())
                .build() : CreateQueueRequest.builder()
                .queueName(queueName)
                .build();
    }

    private Map<String, String> getfifoQueueAttributes() {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("FifoQueue", "true");
        attributes.put("ContentBasedDeduplication", "true");
        return attributes;
    }
}
