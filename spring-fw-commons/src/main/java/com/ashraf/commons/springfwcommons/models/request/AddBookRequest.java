/*
 * Md Ashraful Alam
 * 7/5/20, 8:33 PM
 */

package com.ashraf.commons.springfwcommons.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBookRequest {
    private String bookName;
    private String bookGenre;
    private String bookPrice;
    private String bookWriter;
    private String bookLocation;
    private String bookPublisher;
    private String bookPublishingYear;
}
