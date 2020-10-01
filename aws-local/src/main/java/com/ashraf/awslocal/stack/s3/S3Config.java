/*
 * Md Ashraful Alam
 * 10/1/20, 1:25 PM
 */

package com.ashraf.awslocal.stack.s3;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.ashraf.awslocal.util.Common.REGION;
import static com.ashraf.awslocal.util.Common.LOCALSTACK_ENDPOINT;

@Configuration
public class S3Config {

    @Bean
    public AmazonS3 amazonS3(){
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(LOCALSTACK_ENDPOINT, REGION))
                .withPathStyleAccessEnabled(true)
                .build();
    }
}
