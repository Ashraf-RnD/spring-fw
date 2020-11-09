/*
 * Md Ashraful Alam
 * 10/9/20, 1:41 AM
 */

package com.ashraful.sqsspringcloud.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
