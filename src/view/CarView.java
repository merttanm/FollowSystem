/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import followsystem.model.Car;

/**
 *
 * @author Mert Tan
 */
public class CarView {
    public void printCarDetail(Car car){
        System.out.println("*********ARAÇ BİLGİLERİ**********");
        System.out.println("ARACIN YAŞI  *********** " + car.getAge());
        System.out.println("ARACIN MODELI **********" + car.getModel());
        System.out.println("ARCIN MARKASI **************" + car.getName());
        System.out.println("ARACIN RENGI ***********" + car.getColor());
        System.out.println("ARACIN DETAY BILGILERI*********");
        System.out.println("ARACIN VİTES TÜRÜ *********" + car.getAutomotivFuel().name());
        System.out.println("ARACIN YAKIT TÜRÜ ***********" + car.getCarType().name());
        System.out.println("ARAÇ REZERVLİ Mİ *********** " + (car.isCarReserved()==false  ? "HAYIR" : "EVET"));
        System.out.println("ARACIN ŞASE NUMARASI ***********" + car.getSaseNo());
        
    }
}
