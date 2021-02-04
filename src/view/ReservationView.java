/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import followsystem.model.Car;
import followsystem.model.Reservation;

/**
 *
 * @author Mert Tan
 */
public class ReservationView {
    public void printReservationDetailView(Reservation reservation){
        System.out.println("REZEVASYON BİLGİLERİ *************");
        System.out.println("REZERVASYON YAPAN MÜŞTERİ BİLGİLERİ *****");
        System.out.println("       ADI : " + reservation.getCustomer().getCustomerName());
        System.out.println("    SOYADI : " + reservation.getCustomer().getCustomerSurname());
        System.out.println("    TEL NO : " + reservation.getCustomer().getPhoneNumber());
        
        System.out.println("REZERV EDİLEN ARAÇ BİLGİLERİ ********");
        for(Car car: reservation.getCarList())
        {
            System.out.println("    ARAÇ MARKA   :"  + car.getName());
            System.out.println("    ARAÇ MODEL   :"  + car.getModel());
            System.out.println("    ARAÇ RENK    :"  + car.getColor());
            System.out.println("    ARAÇ PLAKA   :"  +car.getPlate());
            System.out.println("    ARAÇ DETAY   :"  +car.getAutomotivFuel().name() +   " , "     + car.getCarType().name());
            System.out.println("    ARAÇ DURUM   :"  + (car.isCarReserved()==true ? "ARAÇ REZERVELİ. " : "ARAÇ REZERVİ BİTTİ"));
            System.out.println("    REZERV TUTAR :" + car.calcRentPrice());
        }
    }
}
