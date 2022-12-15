package com.spring.aws.model;

import lombok.*;

import java.util.Map;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentPayload {

    private String studentId;
    private String name;
    private String email;
    private Map<String, String> degreePercentages;
}
