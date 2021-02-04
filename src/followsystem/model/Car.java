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
public class Car extends Vehicle {
    
    private Integer numDay;
    private Integer numWeek;
    private Integer numMonth;
    private CarType carType;
    private AutomotivFuel automotivFuel;
    private String plate;
    private Integer saseNo;
  

    public Integer getNumDay() {
        return numDay;
    }

    public void setNumDay(Integer numDay) {
        this.numDay = numDay;
    }

    public Integer getNumMonth() {
        return numMonth;
    }

    public void setNumMonth(Integer numMonth) {
        this.numMonth = numMonth;
    }
  
    public Integer getNumWeek() {
        return numWeek;
    }

    public void setNumWeek(Integer numWeek) {
        this.numWeek = numWeek;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public AutomotivFuel getAutomotivFuel() {
        return automotivFuel;
    }

    public void setAutomotivFuel(AutomotivFuel automotivFuel) {
        this.automotivFuel = automotivFuel;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getSaseNo() {
        return saseNo;
    }

    public void setSaseNo(Integer saseNo) {
        this.saseNo = saseNo;
    }
    
    
    
    
    @Override
    public double calcRentPrice() {
        return (super.dailyCost*numDay) + (super.weeklyCost*numWeek) +(super.monthlyCost*numMonth);
    }

    @Override
    public boolean isCarReserved() {
        if(super.isIsReseved()){
            return true;
        }else{
            return false;
        }
    }    
    
}
