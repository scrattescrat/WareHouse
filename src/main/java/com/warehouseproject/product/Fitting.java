package com.warehouseproject.product;

import org.apache.log4j.Logger;

public final class Fitting extends Product{

    private static final Logger LOGGER = Logger.getLogger(Fitting.class);

    public Fitting(int price, String manufacturer) {
        super(price, manufacturer);
    }

    @Override
    public void onBoard() {
        LOGGER.info("new fitting");

    }

    @Override
    public String toString() {
        return ("Fitting: " + super.toString());
    }
}
