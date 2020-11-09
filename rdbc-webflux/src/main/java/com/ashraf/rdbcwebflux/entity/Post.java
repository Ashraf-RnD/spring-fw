package com.ashraf.rdbcwebflux.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("posts")
public class Post {

    @Id
    @Column("id")
    private Integer id;
    @Column("title")
    private String title;
    @Column("content")
    private String content;

}
