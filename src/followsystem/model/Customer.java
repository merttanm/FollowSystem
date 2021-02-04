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
public class Customer {
    private Adress customerAdress;
    private String customerName;
    private String customerSurname;
    private Long identityNo;
    private Integer customerAge;
    private String phoneNumber;
    private boolean isValid ; // yaşı 18 den buyukmu  
    private int driverCarNumber;

    public Adress getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(Adress customerAdress) {
        this.customerAdress = customerAdress;
    }
  
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public Long getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(Long identityNo) {
        this.identityNo = identityNo;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public int getDriverCarNumber() {
        return driverCarNumber;
    }

    public void setDriverCarNumber(int driverCarNumber) {
        this.driverCarNumber = driverCarNumber;
    }
    
}
