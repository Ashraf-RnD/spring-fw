/*
 * Md Ashraful Alam
 * 9/17/20, 3:28 PM
 */

package com.ashraf.redispub.controller;

import com.ashraf.redispub.service.MessagePublicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MessagePublicationController {

    private final MessagePublicationService messagePublicationService;

    @PostMapping("/publishMessage")
    public String publishMessage(){
        messagePublicationService.publishMessage("messageTime:: "+System.currentTimeMillis());
        return "done";
    }

}
