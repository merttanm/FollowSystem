/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import followsystem.model.Adress;
import followsystem.model.Customer;

/**
 *
 * @author Mert Tan
 */
public class CustomerView {
    public void printCustomerDetail(Customer customer){
        System.out.println("MÜŞTERİ BİLGİLERİ****************");
        System.out.println("MÜŞTERİ ADI ***********" + customer.getCustomerName());
        System.out.println("MÜŞTERİ SOYADI ********" +customer.getCustomerSurname());
        System.out.println("MÜŞTERİ KİMLİK NUMARASI ****" + customer.getIdentityNo());
        System.out.println("MÜŞTERİ YAŞI *******" + customer.getCustomerAge());
        System.out.println("MÜŞTERİ CEP NUMARASI********" + customer.getPhoneNumber());
        System.out.println("MÜŞTERİ EHLİYET NUMARASI ***" + customer.getDriverCarNumber());
        Adress adress = customer.getCustomerAdress();
        System.out.println("ADRESİ " + adress.getCity() + " / " + adress.getDistrict() + "  " + adress.getStress() + "  " + adress.getApartment() + "  " + adress.getDoorNo());
    }
}
