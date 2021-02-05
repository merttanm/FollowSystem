/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package followsystem.model;

import java.util.List;

/**
 *
 * @author Mert Tan
 */
public class Adress {
    private String city;
    private String district;
    private String stress;
    private String apartment;
    private Integer apartmentId;
    private Integer doorNo;

    public String getCity() {
        return city;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

 
    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Integer getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Integer doorNo) {
        this.doorNo = doorNo;
    }
    
}
