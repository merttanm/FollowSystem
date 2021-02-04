/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package followsystem.model;

import java.math.BigDecimal;

/**
 *
 * @author Mert Tan
 */
public abstract class Vehicle {
        
    private String name;
    private String color;
    private Integer age;
    private String model;
    private boolean isReseved;
    
    
    double dailyCost, weeklyCost, monthlyCost;

    public  abstract double calcRentPrice();
    
    public abstract boolean isCarReserved();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(double dailyCost) {
        this.dailyCost = dailyCost;
    }

    public double getWeeklyCost() {
        return weeklyCost;
    }

    public void setWeeklyCost(double weeklyCost) {
        this.weeklyCost = weeklyCost;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public boolean isIsReseved() {
        return isReseved;
    }

    public void setIsReseved(boolean isReseved) {
        this.isReseved = isReseved;
    }

  

   
}
