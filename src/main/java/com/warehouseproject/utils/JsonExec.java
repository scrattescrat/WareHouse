package com.warehouseproject.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;

public class JsonExec {
    private static final Logger LOGGER = Logger.getLogger(JsonExec.class);

    public String convertJavaToJsonStr(Object obj) {

        String jsonStr = "";

        try {
            jsonStr = new ObjectMapper().writeValueAsString(obj);
            LOGGER.info("convert to string, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonStr;
    }

    public void convertJavaToJsonFile(Object obj, String pathToFile) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(pathToFile).toFile(), obj);
            LOGGER.info("write to file, finished!");

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
