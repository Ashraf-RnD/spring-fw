/*
 * Md Ashraful Alam
 * 10/9/20, 2:35 AM
 */

package com.ashraf.awslocal.controller;

import com.ashraf.awslocal.service.SqsService;
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

    @PostMapping("/createStandardQueue")
    public ResponseEntity<?> createStandardQueue(@RequestBody Map<String,String> request){
        sqsService.createQueue(request.get("queueName"),false);
        return ResponseEntity.ok("tested");
    }

    @PostMapping("/enqueue")
    public ResponseEntity<?> enQueue(@RequestBody Map<String,String> request){
        sqsService.enQueue(request.get("queueUrl"),request);
        return ResponseEntity.ok("tested");
    }

}
