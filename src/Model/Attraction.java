/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.AttractionsList;

import java.util.ArrayList;

/**
 * This is the attraction class.Creates an attraction object to be stored an
 * attractionsList or Schedule.
 *
 * @author aic5588
 */
public class Attraction {

    private String name;
    private String description;
    private String date;
    private int maxCapacity;
    private int currentCapacity;
    private int attractionID;
    private int waitTime;
    private int waitTimeIncrease;

    /**
     * This is the default constructor for Attraction
     */
    public Attraction() {
        this.name = name;
        this.description = description;
        this.date = date;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.attractionID = attractionID;
        this.waitTime = waitTime;
        this.waitTimeIncrease = waitTimeIncrease;

    }

    /**
     * This is the all parameter constructor for Attraction to be initiated in
     * other classes.
     *
     * @param name        accepts a string input
     * @param description accepts a string input
     * @param date        accepts a string input
     */
    public Attraction(String name, String description, String date, int maxCapacity, int currentCapacity, int attractionID, int waitTime, int waitTimeIncrease) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.attractionID = attractionID;
        this.waitTime = waitTime;
        this.waitTimeIncrease = waitTimeIncrease;
    }

    public void increaseCapacity(int partySize){
        this.currentCapacity = this.currentCapacity + partySize;
        if (this.currentCapacity >= this.maxCapacity){
            this.waitTime = this.waitTime + this.waitTimeIncrease;
            this.currentCapacity = this.currentCapacity - this.maxCapacity;
        }
    }


    /**
     * Returns a viewable string instead of the default string set.
     *
     * @return A string that represents an Attraction.
     */
    @Override
    public String toString() {
        return "Attraction{" + "name=" + name + ", description=" + description + ", date=" + date + ", maxCapacity=" + maxCapacity + ", currentCapacity=" + currentCapacity + ", attractionID=" + attractionID + "current wait time" + waitTime + '}';
    }

    /**
     * Returns the attraction name
     *
     * @return A string representing the attraction name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the attraction.
     *
     * @param name sets the name for the attraction.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the attraction description
     *
     * @return A string representing the attraction description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the attraction.
     *
     * @param description sets the description for the attraction.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the attraction date string.
     *
     * @return A string representing the attraction date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date for the attraction.
     *
     * @param date sets the date for the attraction.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the attraction MaxCapacity
     *
     * @return A int representing the attraction maxCapacity.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets the maxCapacity for the attraction.
     *
     * @param maxCapacity sets the max capacity for the attraction.
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * Returns the attraction currentCapacity
     *
     * @return A int representing the attraction currentCapacity.
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Sets the currentCapacity for the attraction.
     *
     * @param currentCapacity sets the current capacity for the attraction.
     */
    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    /**
     * Gets the attractionID for the attraction.
     *
     * @return A int that represents the attractionID.
     */
    public int getAttractionID() {
        return attractionID;
    }

    /**
     * Sets the attractionID for the attraction.
     *
     * @param attractionID sets the attraction ID for the attraction.
     */
    public void setAttractionID(int attractionID) {
        this.attractionID = attractionID;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public int getWaitTimeIncrease() {
        return waitTimeIncrease;
    }

    public void setWaitTimeIncrease(int waitTimeIncrease) {
        this.waitTimeIncrease = waitTimeIncrease;
    }

}
