/*
 * Md Ashraful Alam
 * 7/5/20, 8:16 PM
 */

package com.ashraf.springaop.service.interfaces;

import com.ashraf.commons.springfwcommons.models.request.AddBookRequest;
import com.ashraf.commons.springfwcommons.models.response.AddBookResponse;

public interface BookService {
    AddBookResponse addNewBook(AddBookRequest request);
}
