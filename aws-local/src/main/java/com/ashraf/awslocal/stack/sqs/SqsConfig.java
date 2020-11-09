/*
 * Md Ashraful Alam
 * 10/8/20, 12:32 AM
 */

package com.ashraf.awslocal.stack.sqs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

import static com.ashraf.awslocal.util.Common.LOCALSTACK_ENDPOINT;

@Configuration
public class SqsConfig {

    @Bean
    public SqsClient sqsClient(){
        return SqsClient.builder()
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT))
                .region(Region.AP_SOUTHEAST_1)
                .build();
    }

}
