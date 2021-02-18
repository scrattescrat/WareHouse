package com.warehouseproject.menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadFromProperties {

    public static String getValueFromProperties (String path, String key) {
        Properties properties = new Properties();
        try{
            FileInputStream fileStream = new FileInputStream(path);
            properties.load(fileStream);
            fileStream.close();
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
