/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Resume {
    private String fileName;
    private String file;
    private Long fileSize;
}