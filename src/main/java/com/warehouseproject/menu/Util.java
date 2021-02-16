package com.warehouseproject.menu;

import com.warehouseproject.warehouse.MyException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {
    private static final Logger LOGGER = Logger.getLogger(Menu.class);

//    public static int selection() throws MyException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        String quantity = bufferedReader.readLine();
////        int i = Integer.parseInt(quantity);
////        return i;
//        try {
//            return Integer.parseInt(bufferedReader.readLine());
//        } catch (IOException e) {
//            throw new MyException(e.getMessage());
//        }
//
//    }

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
