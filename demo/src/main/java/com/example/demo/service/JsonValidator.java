package com.example.demo.service;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import com.example.demo.controller.AppController;

@Service
public class JsonValidator {
    public void validateJSON(JSONObject jsonObject) throws ValidationException {

        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(AppController.class.getResourceAsStream("/planSchema.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonObject);

    }
}