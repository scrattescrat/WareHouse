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

import static java.lang.Integer.parseInt;

public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class);

    private static final String PROPERTY_FILE_PATH_ADDRESSES = "src/main/resources/addresses.properties";
    private static final String PROPERTY_FILE_PATH_PRODUCTS = "src/main/resources/products.properties";

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

        LOGGER.info("------------------------------------------------------------------");

        JsonExec jsonAction = new JsonExec();
        jsonAction.convertJavaToJsonFile(truck, "truck.json");

        if(isOtherAction()) {
            menuSelection();
        };



    }

    private boolean isOtherAction() {
        System.out.println("Do you want to continue? " +
                "Choose: '1' - Add more products; '2' - Select delivery point; '3' - Exit");
        int decision = Util.scanValue();
        if (decision == 1) {
            return true;
        } else if (decision == 2) {
            String name1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "name1");
            String address1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "address1");
            String size1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "size1");

            String name2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "name2");
            String address2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "address2");
            String size2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "size2");

            String name3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "name3");
            String address3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "address3");
            String size3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_ADDRESSES, "size3");

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

        String price1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "price1");
        int radiatorPrice = parseInt(price1);
        String manufacturer1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "manufacturer1");
        String weight1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "weight1");
        int radiatorWeight = parseInt(weight1);

        String price2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "price2");
        int pipecoilPrice = parseInt(price2);
        String manufacturer2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "manufacturer2");
        String length2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "length2");
        int pipecoilLength = parseInt(length2);

        String price3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "price3");
        int fittingPrice = parseInt(price3);
        String manufacturer3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH_PRODUCTS, "manufacturer3");

        Radiator radiator = new Radiator(radiatorPrice, manufacturer1, radiatorWeight);
        PipeCoil pipeCoil = new PipeCoil(pipecoilPrice, manufacturer2, pipecoilLength);
        Fitting fitting = new Fitting(fittingPrice, manufacturer3);

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
                    throw new MyException("Wrong product number");
            }
        }catch (MyException e){
            LOGGER.error("Wrong number: " + e.getMessage());
        }
    }



}
