/*
 * Md Ashraful Alam
 * 7/5/20, 8:38 PM
 */

package com.ashraf.commons.springfwcommons.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookResponse {
    private String bookNumber;
    private String bookName;
    private String bookGenre;
    private String bookPrice;
    private String bookWriter;
    private String bookLocation;
    private String bookPublisher;
    private String bookPublishingYear;
}
