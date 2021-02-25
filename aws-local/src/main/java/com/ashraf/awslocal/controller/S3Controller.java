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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    @PostMapping("/uploadFile")
    public void uploadFile(@RequestBody S3ServiceRequest request){
        s3Service.uploadFile(request.getObjectPath(),request.getBucketName(),request.getObjectKey());
    }

    @PostMapping("/getBucketSummery")
    public List<S3ObjectSummary> getS3ObjectSummaryList(@RequestBody S3ServiceRequest request){
        return s3Service.getS3ObjectSummeryList(request.getBucketName());
    }

    @PostMapping("/getS3ObjectContent")
    public String getS3ObjectContent(@RequestBody S3ServiceRequest request){
        return displayTextInputStream(s3Service.getS3Object(request.getBucketName(),request.getObjectKey()).getObjectContent());
    }
    public String displayTextInputStream(InputStream input) {
        // Read the text input stream one line at a time and display each line.
        var reader = new BufferedReader(new InputStreamReader(input));
        var sb = new StringBuilder();
        String line = null;
        try{

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }

}
