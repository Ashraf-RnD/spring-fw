/*
 * Md Ashraful Alam
 * 10/1/20, 1:24 PM
 */

package com.ashraf.awslocal.service;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.ashraf.awslocal.stack.s3.S3Operations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3ServiceImpl implements S3Service{
    private final S3Operations s3Operations;

    @Override
    public void createBucket(String bucketName) {
        s3Operations.createBucket(bucketName);
    }

    @Override
    public void uploadFile(String objectPath, String bucketName, String objectKey) {
        s3Operations.uploadToBucket(objectPath,bucketName,objectKey);
    }

    @Override
    public List<String> getBucketKeyList(String bucketName) {
        return s3Operations.getKeyList(bucketName);
    }

    @Override
    public S3Object getS3Object(String bucketName, String objectKey) {
        return s3Operations.getS3Object(bucketName,objectKey);
    }

    @Override
    public List<S3ObjectSummary> getS3ObjectSummeryList(String bucketName) {
        return s3Operations.getS3ObjectSummeryList(bucketName);
    }
}
