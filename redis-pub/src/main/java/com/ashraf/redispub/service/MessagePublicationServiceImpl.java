/*
 * Md Ashraful Alam
 * 9/17/20, 3:49 PM
 */

package com.ashraf.redispub.service;

import com.ashraf.redispub.configuration.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessagePublicationServiceImpl implements MessagePublicationService {
    private final RedisPublisher redisPublisher;
    private final ChannelTopic channelTopic;

    @Override
    public void publishMessage(String message) {
        redisPublisher.publish(channelTopic,message);
    }
}
