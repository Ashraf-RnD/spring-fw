/*
 * Md Ashraful Alam
 * 10/1/20, 2:03 PM
 */

package com.ashraf.awslocal.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class S3ServiceRequest implements Serializable {
    private String bucketName;
    private String objectPath;
    private String objectKey;
}
