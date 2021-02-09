package com.warehouseproject.product;


import org.apache.log4j.Logger;

public abstract class Product implements Printable {
    private static final Logger LOGGER = Logger.getLogger(Product.class);
    private int price;
    private String manufacturer;

    Product(){
    }

    Product(int price, String manufacturer){
        this.price = price;
        this.manufacturer = manufacturer;
    }


    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public abstract void onBoard();


    @Override
    public void printInfo(){
        LOGGER.info("Price: " + price + " $");
        LOGGER.info("Manufacturer: " + manufacturer);
    }



}
