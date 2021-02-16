package com.warehouseproject.menu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ReadFromProperty {

    static Class clazz = ReadFromProperty.class;

    public static String getProperty(String path, String key) {
        Properties properties = new Properties();
        try{
//            FileInputStream fileStream = new FileInputStream("/"+path);
            InputStream fileStream = clazz.getResourceAsStream("/"+path);
            properties.load(fileStream);
            fileStream.close();

            return properties.getProperty(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }







}
