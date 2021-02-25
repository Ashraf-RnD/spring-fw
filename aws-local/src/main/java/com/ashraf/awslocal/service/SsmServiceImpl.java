/*
 * Md Ashraful Alam
 * 2/4/21, 5:33 PM
 */

package com.ashraf.awslocal.service;

import com.ashraf.awslocal.stack.ssm.SsmOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SsmServiceImpl implements SsmService{
    private final SsmOperations ssmOperations;
    @Override
    public String getparamValue(String paramName) {

        return ssmOperations.getParamValue(paramName);
    }
}
