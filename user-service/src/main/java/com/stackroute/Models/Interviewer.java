package com.stackroute.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "interviewer")
public class Interviewer {
    @Id
    private String emailId;
    private String firstName;
    private String  lastName;
    private Long mobileNumber;
    private String techTrack;


}
