package com.warehouseproject.menu;

import com.warehouseproject.product.Fitting;
import com.warehouseproject.product.PipeCoil;
import com.warehouseproject.product.Radiator;
import com.warehouseproject.exception.MyException;
import com.warehouseproject.utils.JsonExec;
import com.warehouseproject.utils.Util;
import com.warehouseproject.warehouse.Truck;
import com.warehouseproject.warehouse.WareHouseManager;
import org.apache.log4j.Logger;

public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class);

    private static final String PROPERTY_FILE_PATH = "src/main/resources/addresses.properties";

    private Truck truck = new Truck();

    public void menuSelection(){

        System.out.println("----- Welcome to the WareHouse program -----" +
                "\nPlease, create a list of products you want to deliver to WareHouse:");
        System.out.println("Press 1 - To add the RADIATOR to the list." +
                "\nPress 2 - To add the PIPE COIL to the list." +
                "\nPress 3 - To add the FITTING to the list.");
        System.out.println("Please, make your choice");
        int productType = Util.scanValue();

        System.out.println("Enter the quantity of products: ");
        int quantityOfProducts = Util.scanValue();

        createDelivery(productType, quantityOfProducts);

        LOGGER.info("-----------------------");

        JsonExec jsonAction = new JsonExec();
        jsonAction.convertJavaToJsonFile(truck, "truck.json");

        if(askOtherAction()) {
            menuSelection();
        };
//


////        String name = ReadFromProperty.getProperty("addresses.properties", "name");
////        String address = ReadFromProperty.getProperty("addresses.properties", "address");
////        String size = ReadFromProperty.getProperty("addresses.properties", "size");
////        System.out.println(name + " " + address + " " + "available: " + size);
//
//        String name1 = ReadFromProperties.getValueFromProperties("src/main/resources/addresses.properties", "name1");
//        LOGGER.info(name1);
//
//        WriteToProperties.setValueToProperties("src/main/resources/addresses.properties", "size1", "80");

    }

    private boolean askOtherAction() {
        System.out.println("Do you want to continue? " +
                "Choose: '1' - Add more products; '2' - Select delivery point; '3' - Exit");
        int decision = Util.scanValue();
        if (decision == 1) {
            return true;
        } else if (decision == 2) {
            String name1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "name1");
            String address1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "address1");
            String size1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size1");

            String name2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "name2");
            String address2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "address2");
            String size2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size2");

            String name3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "name3");
            String address3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "address3");
            String size3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size3");

            System.out.println("1. - " + name1 + " " + address1 + " " + "available: " + size1);
            System.out.println("2. - " + name2 + " " + address2 + " " + "available: " + size2);
            System.out.println("3. - " + name3 + " " + address3 + " " + "available: " + size3);

            System.out.println("=============================================");
            System.out.println("Please, choose a delivery point.");
            int address = Util.scanValue();

            WareHouseManager wareHouseManager = new WareHouseManager();
            wareHouseManager.loadIntoWarehouse(address, truck);

            return false;
        } else {
            return false;
        }
    }

    private void createDelivery(int productType, int quantityOfProducts) {
        Radiator radiator = new Radiator(76, "Kermi", 2);
        Fitting fitting = new Fitting(174, "Kermi");
        PipeCoil pipeCoil = new PipeCoil(450, "Uponor", 400);

        try{
            switch (productType) {
                case 1:
                    truck.addProductToTruck(radiator, quantityOfProducts);
                    break;
                case 2:
                    truck.addProductToTruck(pipeCoil, quantityOfProducts);
                    break;
                case 3:
                    truck.addProductToTruck(fitting, quantityOfProducts);
                    break;
                default:
                    throw new MyException("Wrong number");
            }
        }catch (MyException e){
            LOGGER.error("Wrong number: " + e.getMessage());
        }
    }



}
