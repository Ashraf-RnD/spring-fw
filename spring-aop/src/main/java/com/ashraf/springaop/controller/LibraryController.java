/*
 * Md Ashraful Alam
 * 7/3/20, 12:15 PM
 */

package com.ashraf.springaop.controller;

import com.ashraf.commons.springfwcommons.models.request.AddBookRequest;
import com.ashraf.commons.springfwcommons.models.response.AddBookResponse;
import com.ashraf.springaop.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class LibraryController {
    private final BookService bookService;

    @PostMapping(value = "/addBook")
    public AddBookResponse addNewBook(@RequestBody AddBookRequest request){
        return bookService.addNewBook(request);
    }
}
