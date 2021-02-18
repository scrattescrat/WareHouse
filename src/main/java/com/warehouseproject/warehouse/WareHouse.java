package com.warehouseproject.warehouse;

import com.warehouseproject.product.Product;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {
    private static final Logger LOGGER = Logger.getLogger(Truck.class);

    private List<Product> productList;
    private int capacity;

    public WareHouse(){
        productList = new ArrayList<Product>();
    }

    public WareHouse(int capacity){
        productList = new ArrayList<Product>(capacity);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getProductListSize() {
        return productList.size();
    }
}
