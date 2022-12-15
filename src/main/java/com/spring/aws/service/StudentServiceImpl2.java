package com.spring.aws.service;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring.aws.exception.UserHandledException;
import com.spring.aws.model.StudentPayload;
import com.spring.aws.model.StudentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

/*

@Service
public class StudentServiceImpl2 implements StudentService {

    private static final String STUDENT_RECORD_SAVE_SERVICE_URL = "";

    private final static ObjectMapper JSON = new ObjectMapper();

    @Override
    public Optional<StudentResponse> getUpdatedStudentsRecords(StudentPayload payload, Context context) throws UserHandledException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String inputRequestJson = objectMapper.writeValueAsString(payload);
            context.getLogger().log("\n inputRequestJson: " + inputRequestJson);

            // call another service to save data into db
            URL url = new URL(STUDENT_RECORD_SAVE_SERVICE_URL);
            context.getLogger().log("\n url: " + url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(inputRequestJson.getBytes());
            outputStream.flush();
            outputStream.close();

            int responseCode = httpURLConnection.getResponseCode();
            context.getLogger().log(" responseCode: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder responseBuffer = new StringBuilder();
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String output = bufferReader.readLine();
                while (Objects.nonNull(output)) {
                    responseBuffer.append(output);
                }
                context.getLogger().log(" StringBufferResponse : " + responseBuffer);
                // sending success response
                if (!responseBuffer.isEmpty()) {
                    // converting stringBufferResponse to outputResponse
                    return Optional.of(JSON.readValue(responseBuffer.toString(), StudentResponse.class));
                } else {
                    context.getLogger().log(" ResponseCode is: " + responseCode);
                    throw new UserHandledException("OutputResponse is null ", HttpStatus.NO_CONTENT.value());
                }
            } else {
                context.getLogger().log(" ResponseCode is: " + responseCode);
                throw new UserHandledException("Updating from stream failed ", responseCode);
            }

        } catch (MalformedURLException exception) {
            context.getLogger().log(" Exception occurred while creating url ");
            exception.printStackTrace();
            throw new UserHandledException("Exception occurred while creating url ", HttpStatus.BAD_REQUEST.value());
        } catch (IOException exception) {
            context.getLogger().log(" Exception occurred while httpConnection ");
            exception.printStackTrace();
            throw new UserHandledException(" Exception occurred while httpConnection ", HttpStatus.BAD_REQUEST.value());
        }
    }
}
*/
