/*
 * Md Ashraful Alam
 * 10/1/20, 1:33 PM
 */

package com.ashraf.awslocal.stack.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Operations {
    private final AmazonS3 amazonS3;
    private final ObjectMapper objectMapper;

    public void createBucket(String bucketName) {
        try {
            if (!amazonS3.doesBucketExistV2(bucketName))
                amazonS3.createBucket(new CreateBucketRequest(bucketName));

            String bucketLocation = amazonS3.getBucketLocation(new GetBucketLocationRequest(bucketName));
            log.info("S3Operations:: createBucket:: Bucket-location: {}", bucketLocation);

        } catch (Exception e) {
            log.error("S3Operations:: createBucket:: ERROR: {}",e.toString());
            e.printStackTrace();
        }
    }
    public List<Bucket> getBucketList() {
       return amazonS3.listBuckets()
                .stream()
                .peek(bucket -> log.info("S3Operations:: getBucketList:: bucket: {}:{}",bucket.getName(),bucket.getCreationDate()))
                .collect(Collectors.toList());
    }

    public void uploadToBucket(String object, String bucket, String objectKey) {
        var putObjectResult = amazonS3.putObject(bucket, objectKey, new File(object));
        log.info("S3Operations:: uploadToBucket:: putObjectResult: {}",putObjectResult.toString());

        getS3ObjectSummeryList(bucket);
    }

    public List<S3ObjectSummary> getS3ObjectSummeryList(String bucket) {
        return amazonS3.listObjectsV2(bucket)
                .getObjectSummaries()
                .stream()
                .map(s3ObjectSummary -> {
                    log.info("S3Operations:: uploadToBucket:: s3ObjectSummary: key:{}, lastModified:{}, size:{}"
                            , s3ObjectSummary.getKey(), s3ObjectSummary.getLastModified(), s3ObjectSummary.getSize());
                    return s3ObjectSummary;
                })
                .collect(Collectors.toList());
    }

    public List<String> getKeyList(String bucket) {
        return amazonS3.listObjectsV2(bucket).getObjectSummaries()
                .stream()
                .map(S3ObjectSummary::getKey)
                .collect(Collectors.toList());
    }


    public <T> Class getObject(Class<T> tClass, String bucket, String key) {
        var s3Object = amazonS3.getObject(bucket, key);
        var s3Content = s3Object.getObjectContent();
        StringBuilder stringBuilder = new StringBuilder();

        byte[] read_buf = new byte[1024];
        int read_len = 0;
        while (true) {
            try {
                if (!((read_len = s3Content.read(read_buf)) > 0)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(read_buf);
        }

        try {
            var json = objectMapper.readValue(stringBuilder.toString(),tClass);
            log.info("json = " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tClass;

    }

    public S3Object getS3Object(String bucketName, String key){
        return amazonS3.getObject(new GetObjectRequest(bucketName,key));
    }
}
