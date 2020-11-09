/*
 * Md Ashraful Alam
 * 10/9/20, 2:37 AM
 */

package com.ashraf.awslocal.service;

import com.ashraf.awslocal.stack.sqs.SqsOperations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsServiceImpl implements SqsService{

    private final SqsOperations sqsOperations;
    private final ObjectMapper objectMapper;

    @Override
    public void createQueue(String queueName, boolean isFifo) {
        sqsOperations.createQueue(queueName,false);
    }

    @Override
    public <T> void enQueue(String queueUrl, T message) {
        try {
            sqsOperations.enQueue(queueUrl,objectMapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
