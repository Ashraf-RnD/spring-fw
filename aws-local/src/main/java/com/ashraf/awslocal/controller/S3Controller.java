/*
 * Md Ashraful Alam
 * 10/1/20, 1:24 PM
 */

package com.ashraf.awslocal.controller;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.ashraf.awslocal.request.S3ServiceRequest;
import com.ashraf.awslocal.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    @PostMapping("/createBucket")
    public void createBucket(@RequestBody S3ServiceRequest request){
        s3Service.createBucket(request.getBucketName());
    }

    @PostMapping("/uplocadFile")
    public void uploadFile(@RequestBody S3ServiceRequest request){
        s3Service.uploadFile(request.getObjectPath(),request.getBucketName(),request.getObjectKey());
    }

    @PostMapping("/getbucketSummery")
    public List<S3ObjectSummary> getS3ObjectSummaryList(@RequestBody S3ServiceRequest request){
        return s3Service.getS3ObjectSummeryList(request.getBucketName());
    }

}
