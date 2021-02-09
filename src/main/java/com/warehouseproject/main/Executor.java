package com.warehouseproject.main;


import com.warehouseproject.product.*;
import com.warehouseproject.warehouse.Truck;



public class Executor {
    public static void main(String[] args) {
        Radiator radiator = new Radiator(76, "Kermi", 2);
        Fitting fitting = new Fitting(174, "Kermi");


        Truck truck = new Truck();
        truck.addProductToTruck(radiator);
        truck.addProductToTruck(fitting);
        truck.printTruck();


}
