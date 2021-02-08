/*
 * Md Ashraful Alam
 * 2/4/21, 5:35 PM
 */

package com.ashraf.awslocal.stack.ssm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ssm.SsmClient;

import java.net.URI;

@Configuration
public class SsmConfig {
    private final URI uri = URI.create("http://localhost:7583");

    @Bean
    public SsmClient ssmClient() {
        return SsmClient.builder()
                .endpointOverride(uri)
                .region(Region.AP_SOUTHEAST_1)
                .build();
    }
}
