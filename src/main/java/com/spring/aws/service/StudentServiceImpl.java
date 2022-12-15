package com.spring.aws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.aws.exception.UserHandledException;
import com.spring.aws.model.StudentInfo;
import com.spring.aws.model.StudentPayload;
import com.spring.aws.model.StudentResponse;
import com.spring.aws.repository.DataBaseConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl() {
    }

    @Override
    public Optional<StudentResponse> saveUpdatedStudentsRecordsInPostgresSqlDb(StudentPayload payload, Context context) throws UserHandledException {

        DataBaseConfig connection = new DataBaseConfig();
        context.getLogger().log("\n payload in student service class : " + new Gson().toJson(payload));
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            String inputRequestJson = objectMapper.writeValueAsString(payload);
            StudentResponse reqData = gson.fromJson(inputRequestJson, StudentResponse.class);
            boolean status = saveStudentInfoInDB(context, reqData,connection);
            reqData.setIsDataSavedIntoDB(status);
            context.getLogger().log("\n is data saved into Postgres-SQL DB : " + status);
            return Optional.of(reqData);

        } catch (Exception e) {
            context.getLogger().log("\n Exception in student service : " + e.getMessage());
        }
        return Optional.of(new StudentResponse());
    }

    private boolean saveStudentInfoInDB(Context context, StudentResponse reqData, DataBaseConfig connection) {

        context.getLogger().log("\n student data save method : ");
        StudentInfo studentInfo = new StudentInfo();
        BeanUtils.copyProperties(reqData, studentInfo);
        String query = "insert into student_info values('" + studentInfo.getStudentId() + "','"
                + studentInfo.getEmail() + "','" + studentInfo.getName() + "','"
                + studentInfo.getDegreePercentages() + "')";
        context.getLogger().log("\n before template query : " + query);
        try {
            PreparedStatement stmt = connection.connection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery(query);
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
