package com.spring.aws.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class StudentInfo implements Serializable {

    @Id
    private String studentId;
    private String name;
    private String email;
    private Map<String, String> degreePercentages;

}
