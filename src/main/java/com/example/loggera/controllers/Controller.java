package com.example.loggera.controllers;

import com.example.loggera.services.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    Logger logger;
    @PostMapping("/hui")
    ResponseEntity<String> makeTestObject(@RequestParam String name) throws SQLException {
        logger.makeObjects(name);
        return new ResponseEntity<String>(name, HttpStatus.OK);
    }


}
