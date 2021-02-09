package com.warehouseproject.warehouse;

import com.warehouseproject.product.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private static final Logger LOGGER = Logger.getLogger(Truck.class);

    private List<Product> capacity;
    private int size = 10;

    public Truck(){
        capacity = new ArrayList<Product>();
    }

    public Truck(Product product){
        capacity = new ArrayList<Product>();

    }

    public List<Product> getCapacity() {
        return capacity;
    }

    public void addProductToTruck(Product product){
        capacity.add(product);
        LOGGER.info("New product in the truck");
    }

    public void printTruck(){
        for (Product product : capacity) {
            LOGGER.info(product.toString());

        }
    }


}
