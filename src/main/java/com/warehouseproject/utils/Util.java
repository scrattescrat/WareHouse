package com.warehouseproject.utils;

import com.warehouseproject.menu.Menu;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Util {
    private static final Logger LOGGER = Logger.getLogger(Menu.class);


    public static int scanValue(){
        int value = 0;
        try {
            Scanner scan = new Scanner(System.in);
            value = scan.nextInt();
        } catch (Exception e) {
            LOGGER.error("Wrong value");
        }
        return value;
    }

}
