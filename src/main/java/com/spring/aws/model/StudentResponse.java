package com.spring.aws.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponse {

    private String studentId;
    private String name;
    private String email;
    private Map<String, String> degreePercentages;
    private Boolean isDataSavedIntoDB;
}
