/*
author: chetan.koranga,
date of creation: 18/05/22
*/

package com.stackroute.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume {
    private String fileName;
    private String file;
    private Long fileSize;
}