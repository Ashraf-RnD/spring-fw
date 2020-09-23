/*
 * Md Ashraful Alam
 * 9/17/20, 5:36 PM
 */

/*
 * Md Ashraful Alam
 * 9/17/20, 3:57 PM
 */

package com.ashraf.redispub.configuration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class RedisPublisher {

    private final RedisTemplate<String, String> redisTemplate;

    public RedisPublisher(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publish(ChannelTopic channelTopic, String result) {
        redisTemplate.convertAndSend(channelTopic.getTopic(), result);
    }
}
