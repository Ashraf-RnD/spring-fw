/*
 * Md Ashraful Alam
 * 10/9/20, 2:16 AM
 */

package com.ashraful.sqsspringcloud.controller;

import com.ashraful.sqsspringcloud.service.SqsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SqsController {
    private final SqsService sqsService;

    @PostMapping("/publishMessage")
    public ResponseEntity<?> publishMessage(@RequestBody Map<String,String> request){
        sqsService.publishMessage(request.get("queueName"),request);
        return ResponseEntity.ok("tested");
    }
}
