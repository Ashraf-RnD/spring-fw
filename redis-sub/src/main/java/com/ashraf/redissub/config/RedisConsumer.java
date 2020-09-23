/*
 * Md Ashraful Alam
 * 9/17/20, 5:38 PM
 */

/*
 * *
 *  @author Md. Ashraful Alam
 *  @bKash Ltd. 5/4/20, 1:31 AM
 * /
 */

package com.ashraf.redissub.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisConsumer implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("RedisConsumer | Received Message | " + message.toString());

    }
}
