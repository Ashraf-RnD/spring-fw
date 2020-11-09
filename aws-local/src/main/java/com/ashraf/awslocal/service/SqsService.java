/*
 * Md Ashraful Alam
 * 10/9/20, 2:36 AM
 */

package com.ashraf.awslocal.service;

public interface SqsService {
    void createQueue(String queueName, boolean isFifo);
    <T> void enQueue(String queueUrl, T message);
}
