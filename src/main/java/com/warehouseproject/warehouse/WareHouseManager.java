package com.warehouseproject.warehouse;

import com.warehouseproject.exception.MyException;
import com.warehouseproject.menu.ReadFromProperties;
import com.warehouseproject.product.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class WareHouseManager {
    private static final Logger LOGGER = Logger.getLogger(WareHouseManager.class);
    private static final String PROPERTY_FILE_PATH = "src/main/resources/addresses.properties";

    public void loadIntoWarehouse(int address, Truck truck) {
        int size;
        try{
            switch (address) {
                case 1:
                    String size1 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size1");
                    size = parseInt(size1);
                    compare(size, truck);

                    break;
                case 2:
                    String size2 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size2");
                    size = parseInt(size2);
                    compare(size, truck);
                    break;
                case 3:
                    String size3 = ReadFromProperties.getValueFromProperties(PROPERTY_FILE_PATH, "size3");
                    size = parseInt(size3);
                    compare(size, truck);
                    break;
                default:
                    throw new MyException("Wrong number");
            }
        } catch (MyException e){
            LOGGER.error("Wrong number: " + e.getMessage());
        }

    }

    private void compare(int size, Truck truck) {
        if (size >= truck.getProductListSize()) {
            loadFromTruckToWareHouse (size, truck, truck.getProductListSize());
        } else {
            loadFromTruckToWareHouse (size, truck, size);
        }
    }

    private void loadFromTruckToWareHouse (int size, Truck truck, int itemCountForUpload) {
        WareHouse wareHouse = new WareHouse(size);
        List<Product> productsForUpload = new ArrayList<>();

        for (int i = 0; i < itemCountForUpload; i++) {
            productsForUpload.add(truck.getProductList().get(i));
        }

        for (Product product: productsForUpload) {
            truck.getProductList().remove(product);
        }
        wareHouse.setProductList(productsForUpload);

        LOGGER.info("Truck contains: " + truck.getProductListSize() + " items after unloading.");
        LOGGER.info("There are : " + wareHouse.getProductListSize() + " occupied places and "
                + (size - wareHouse.getProductListSize()) + " free places in the WareHouse.");
    }

}
