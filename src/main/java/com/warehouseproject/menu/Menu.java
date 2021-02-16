package com.warehouseproject.menu;

import com.warehouseproject.product.Fitting;
import com.warehouseproject.product.PipeCoil;
import com.warehouseproject.product.Radiator;
import com.warehouseproject.warehouse.MyException;
import com.warehouseproject.warehouse.Truck;
import org.apache.log4j.Logger;

public class Menu {

    private static final Logger LOGGER = Logger.getLogger(Menu.class);
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

        System.out.println(truck.getProductList());

        createDelivery(productType, quantityOfProducts);
        if(askAgain()) {
            menuSelection();
        };

//        String name = ReadFromProperty.getProperty("addresses.properties", "name");
//        String address = ReadFromProperty.getProperty("addresses.properties", "address");
//        String size = ReadFromProperty.getProperty("addresses.properties", "size");
//        System.out.println(name + " " + address + " " + "available: " + size);

    }

    private boolean askAgain() {
        System.out.println("Do you want to continue? Choose '1' if yes and '2' if no");
        int decision = Util.scanValue();
        if (decision == 1) {
            return true;
        } else if (decision == 2) {
            return false;
        }
        return false;
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
