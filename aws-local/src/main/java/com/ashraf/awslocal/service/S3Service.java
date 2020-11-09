/*
 * Md Ashraful Alam
 * 10/1/20, 1:24 PM
 */

package com.ashraf.awslocal.service;

import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import java.util.List;

public interface S3Service {
    void createBucket(String bucketName);
    void uploadFile(String objectPath, String bucketName, String objectKey);
    List<String> getBucketKeyList(String bucketName);
    S3Object getS3Object(String bucketName, String objectKey);
    List<S3ObjectSummary> getS3ObjectSummeryList(String bucketName);
}
