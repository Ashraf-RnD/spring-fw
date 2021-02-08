/*
 * Md Ashraful Alam
 * 2/4/21, 5:32 PM
 */

package com.ashraf.awslocal.controller;

import com.ashraf.awslocal.service.SsmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SsmController {
    private final SsmService ssmService;

    @GetMapping("/getParamValue")
    public String getParamValue(String paramName){
        return ssmService.getparamValue(paramName);
    }
}
