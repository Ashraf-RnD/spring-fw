/*
 * Md Ashraful Alam
 * 10/9/20, 2:16 AM
 */

package com.ashraful.sqsspringcloud.service;

public interface SqsService {

    <T> void publishMessage(String queueName, T tClazz);
}
