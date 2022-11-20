/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * Store a list of the completed orders, each order is assigned a unique id which will be added to the profile of the user placing the order.
 * @author ambd1
 */
public class CarryoutOrderList {
    private ArrayList<Integer> orderList;

    /**
     * default constructor for the carryout order list
     */
    public CarryoutOrderList(){
        this.orderList = orderList;
    }

    /**
     * Adds an order ID to the list of carryout orders
     *
     * @param orderID Integer containing the carryout order ID
     * @return carryout order ID that has been successfully added to the list for confirmation purposes
     */
    public ArrayList<Integer> addToCarryoutOrderList(Integer orderID){
        this.orderList.add(orderID);
        return orderList;
    }

    /**
     * Removes an order ID from the list of carryout orders
     * @param orderID Integer containing the carryout order ID
     * @return carryout order ID that has been successfully removed from the list for confirmation purposes
     */
    public Integer removeFromCarryoutOrderList(Integer orderID){
        this.orderList.remove(orderID);
        return orderID;
    }

    @Override
    public String toString() {
        return "CarryoutOrderList{" +
                "orderList=" + orderList +
                '}';
    }

    public String loadData() {
        this.orderList = new ArrayList<>();
        this.orderList.add(99999);
        return orderList.toString();
    }
}
