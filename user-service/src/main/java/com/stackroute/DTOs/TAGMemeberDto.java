package com.stackroute.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.Converters;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TAGMemeberDto {
    private String emailId;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String teamName;
    private String password;

}
