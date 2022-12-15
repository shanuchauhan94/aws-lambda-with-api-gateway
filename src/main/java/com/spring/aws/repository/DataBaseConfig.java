package com.spring.aws.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DataBaseConfig {


    @Bean
    @Primary
    public Connection connection() {
        String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
        String username = "postgres";
        String password = "root";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Opened database successfully");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
