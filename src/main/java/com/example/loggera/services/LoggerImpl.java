package com.example.loggera.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Insert;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class LoggerImpl implements Logger{

    @Autowired
    DataSource dataSource;

    @Override
    public void makeObjects(String name) throws SQLException {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT into test_objects(name) values (?)")){
            statement.setString(1, name);
        }
    }
}
