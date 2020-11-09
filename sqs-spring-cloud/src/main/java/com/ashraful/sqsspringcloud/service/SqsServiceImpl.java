/*
 * Md Ashraful Alam
 * 10/9/20, 2:17 AM
 */

package com.ashraful.sqsspringcloud.service;

import com.ashraful.sqsspringcloud.config.SqsPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsServiceImpl implements SqsService{

    private final SqsPublisher sqsPublisher;

    @Override
    public <T> void publishMessage(String queueName,T tClazz) {
        sqsPublisher.send(queueName,tClazz);
    }
}
