/*
 * Md Ashraful Alam
 * 7/5/20, 8:16 PM
 */

package com.ashraf.springaop.service.impl;

import com.ashraf.commons.springfwcommons.models.request.AddBookRequest;
import com.ashraf.commons.springfwcommons.models.response.AddBookResponse;
import com.ashraf.springaop.aop.aspects.BeforeLoggable;
import com.ashraf.springaop.service.interfaces.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Override
    @BeforeLoggable
    public AddBookResponse addNewBook(AddBookRequest request) {
        return null;
    }
}
