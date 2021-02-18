package com.warehouseproject.warehouse;

import com.warehouseproject.product.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Truck {
    private static final Logger LOGGER = Logger.getLogger(Truck.class);

    private List<Product> productList;

    public Truck(){
        productList = new ArrayList<Product>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getProductListSize() {
        return productList.size();
    }

    public void addProductToTruck(Product product, int quantityOfProducts){
        for (int i = 0; i < quantityOfProducts; i++) {
            productList.add(product);
        }
        LOGGER.info(quantityOfProducts + " item(s) " + product.toString() + " added in truck.");
        LOGGER.info("Truck contains " + productList.size() + " items.");
    }

    public void printTruck(){
        for (Product product : productList) {
            LOGGER.info(product.toString());
        }
    }

}
