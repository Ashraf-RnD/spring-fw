package com.ashraful.sqsspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.messaging.config.annotation.EnableSqs;

@EnableSqs
@SpringBootApplication(exclude = ContextRegionProviderAutoConfiguration.class)
public class SqsSpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsSpringCloudApplication.class, args);
	}

}
