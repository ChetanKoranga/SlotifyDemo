package com.stackroute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tagmember_data")
public class TAGMemeber {
    @Id
    private String emailId;
    private String firstName;
    private String  lastName;
    private Long mobileNumber;
    private String teamName;

}
