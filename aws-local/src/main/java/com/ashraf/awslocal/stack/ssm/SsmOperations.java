package com.ashraf.awslocal.stack.ssm;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.ssm.SsmClient;
import software.amazon.awssdk.services.ssm.model.GetParameterRequest;
import software.amazon.awssdk.services.ssm.model.PutParameterRequest;

@Slf4j
@Service
@AllArgsConstructor
public class SsmOperations {

    private final SsmClient ssmClient;

    public void saveParam(String paramName, String paramValue, boolean overWrite) {

        try {
            var putParamRequest = PutParameterRequest.builder()
                    .name(paramName)
                    .overwrite(overWrite)
                    .value(paramValue)
                    .type("String")
                    .build();
            var result = ssmClient.putParameter(putParamRequest);
            log.info("result = " + result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getParamValue(String paramKey) {

        try {
            var request = GetParameterRequest.builder()
                    .name(paramKey)
                    .build();
            var result = ssmClient.getParameter(request);
            return result.parameter().value();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
