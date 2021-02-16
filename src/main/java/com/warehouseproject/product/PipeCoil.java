package com.warehouseproject.product;

import org.apache.log4j.Logger;

public final class PipeCoil extends Product  {
    private  static  final Logger LOGGER = Logger.getLogger(PipeCoil.class);
    private int length;


    public PipeCoil(int price, String manufacturer, int length) {
        super(price, manufacturer);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }



    @Override
    public void onBoard() {
        LOGGER.info("new pipe coil");
    }

    @Override
    public void printInfo() {
        super.printInfo();
        LOGGER.info("Length: " + length + " metres");
    }

    @Override
    public String toString() {
        return ("Pipe Coil: " + super.toString() + ", length=" + length);
    }
}
