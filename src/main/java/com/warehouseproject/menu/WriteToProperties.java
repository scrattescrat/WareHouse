package com.warehouseproject.menu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToProperties {

    public static void setValueToProperties (String path, String key, String value) {
        Properties properties = new Properties();
        try{
            FileOutputStream fileStream = new FileOutputStream(path, true);
            properties.setProperty(key, value);
            properties.store(fileStream, "");
            fileStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
