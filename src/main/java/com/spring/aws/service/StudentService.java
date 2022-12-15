package com.spring.aws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.spring.aws.exception.UserHandledException;
import com.spring.aws.model.StudentPayload;
import com.spring.aws.model.StudentResponse;

import java.sql.Connection;
import java.util.Optional;

public interface StudentService {

    Optional<StudentResponse> saveUpdatedStudentsRecordsInPostgresSqlDb(StudentPayload payload, Context context) throws UserHandledException;

}
