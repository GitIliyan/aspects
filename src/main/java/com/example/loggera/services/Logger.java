package com.example.loggera.services;

import java.sql.SQLException;

public interface Logger {
    public void makeObjects(String name) throws SQLException;
}
