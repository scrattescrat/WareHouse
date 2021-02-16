package com.warehouseproject.product;

import org.apache.log4j.Logger;

public class Radiator extends Product{
    private  static final Logger LOGGER = Logger.getLogger(Radiator.class);
    private int weight;

    public Radiator(int price, String manufacturer, int weight) {
        super(price, manufacturer);
        this.weight = weight;

    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public void onBoard() {
        LOGGER.info("new radiator");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        LOGGER.info("Weight: " + weight + " kg");
    }

    @Override
    public String toString() {
        return ("Radiator: " + super.toString() + ", weight=" + weight);

    }
}
