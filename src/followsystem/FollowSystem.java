/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package followsystem;

import controller.RentAcarController;
import followsystem.model.Adress;
import followsystem.model.AutomotivFuel;
import followsystem.model.Car;
import followsystem.model.CarType;
import followsystem.model.Customer;
import followsystem.model.Reservation;
import followsystem.model.Vehicle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import view.CarView;
import view.CarView;
import view.CustomerView;
import view.ReservationView;

/**
 *
 * @author Mert Tan
 */
public class FollowSystem {
    private List<Car> carList = new ArrayList<Car>();
    private List<Customer> customerList = new ArrayList<Customer>();
    private List<Reservation> reservationList = new ArrayList<Reservation>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        FollowSystem  followSystem  = new FollowSystem();
        
        System.out.println("******* ARAÇ KİRALAMA SİSTEMİ *******");
         while(true){
            System.out.println("    1 - ARAÇ LİSTESİ ");
            System.out.println("    2 - MÜŞTERİ LİSTESİ");
            System.out.println("    3 - REZERVASYONLU ARAÇLAR");
            System.out.println("    4 - ARAÇ EKLE");
            System.out.println("    5 - MÜŞTERİ EKLE");
            System.out.println("    6 - REZERVASYON EKLE");
            System.out.println("    7 - ARAÇ SİL");
            System.out.println("    8 - MÜŞTERİ SİL");
            System.out.println("    9 - REZERVASYON SONLANDIR/İPTAL ET");
            
            System.out.println("    0 - ÇIKIŞ İÇİN ");
            System.out.println(" YAPMAK İSTEDİĞİNİZ İŞLEM NUMARASINI GİRİNİZ... ");
            
            RentAcarController controller=new RentAcarController();
            CarView carView = new CarView();
            CustomerView customerView = new CustomerView();
            ReservationView reservationView = new ReservationView();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            try{
                int i = Integer.parseInt(s);
                switch(i){
                    case 0: System.out.println("ÇIKIŞ YAPTINIZ...");  System.exit(0); 
                    case 1: 
                        if(followSystem.carList.isEmpty()){
                            System.out.println("SİSTEME KAYITLI ARAÇ BULUNMAMAKTADIR...");   
                        }else{
                            for(Car car: followSystem.carList){
                                controller.setCar(car);
                                controller.setCarView(carView);
                                controller.updateCarView();
                            }
                        }
                        break;
                    
                    case 4: followSystem.insertNewCarModel(); break;
                    case 7: followSystem.deleteCarFromList(); break;
                    
                    
                    case 2:
                         if(followSystem.customerList.isEmpty()){
                            System.out.println("SİSTEME KAYITLI MÜŞTERİ BULUNMAMAKTADIR...");
                        }else{
                            for(Customer customer: followSystem.customerList){
                                controller.setCustomer(customer);
                                controller.setCustomerView(customerView);
                                controller.updateCustomerView();
                           }
                        }
                        break;
                        
                    case 8: followSystem.deleteCustomerFromList(); break;
                    case 5: followSystem.insertNewCustomerModel(); break;
                    case 9: followSystem.deleteOrCancelReservation(); break;

                    case 3:
                        if(followSystem.reservationList.isEmpty()){
                            System.out.println("SİSTEMDE REZERVASYONLU ARAÇ BULUNMAMAKTADIR...");
                        }else{
                            for(Reservation reservation:followSystem.reservationList){
                                controller.setReservation(reservation);
                                controller.setReservationView(reservationView);
                                controller.updateRezervaionView();
                            }
                        }
                    break;
                    case 6: followSystem.insertNewReservationModel(); break;
                }
               String answer = followSystem.checkToContinue();
               if(!answer.equalsIgnoreCase("*")){
                   System.err.println("Uygulama Sonlandırılıyor ... ");
                   System.exit(0);
               }
            }catch(NumberFormatException e){
                System.err.println("Hatalı Seçim Yapıldı!!!! Uygulama Sonlandırılıyor ... ");
                System.exit(0);
            }
        }
    }
    
    public  Car insertNewCarModel() throws IOException{
        Car car = new Car();
        System.out.println("ARAÇ MARKASINI : ");
        String name=readConsoleData();
        car.setName(name);
        System.out.println("ARAÇ ŞASE NO : ");
        int sase=Integer.parseInt(readConsoleData());
        car.setSaseNo(sase);
        
        System.out.println("ARAÇ MODELİ : ");
        String model=readConsoleData();
        car.setModel(model);
        System.out.println("ARAÇ PLAKA : ");
        String plate=readConsoleData();
        car.setPlate(plate);
        System.out.println("ARAÇ RENGİ :");
        String color=readConsoleData();
        car.setColor(color);
        System.out.println("ARAÇ YAŞI :");
        int age=Integer.parseInt(readConsoleData());
        car.setAge(age);
                
        System.out.println("OTOMATİK VİTES Mİ? [EVET/HAYIR]:");
        String cartype=readConsoleData();
        if("EVET".equalsIgnoreCase(cartype)){
            car.setCarType(CarType.AUTOMATIC);
        }else{
            car.setCarType(CarType.MANUEL);
        }
        
        System.out.println("BENZİNLİ Mİ? [EVET/HAYIR]:");
        String fuelOil=readConsoleData();
        if("EVET".equalsIgnoreCase(fuelOil)){
            car.setAutomotivFuel(AutomotivFuel.GASOLINE);
        }else{
            car.setAutomotivFuel(AutomotivFuel.DIESEL);
        }
        car.setIsReseved(false);
        carList.add(car);
        return car;
    }

    public void deleteOrCancelReservation()throws IOException{
        
        System.out.println("ARAÇ PLAKASINI GİRİN:    ");
        String plate=readConsoleData();
        
        
        Car  car = findReservedCar(plate);
        if(car == null){
            System.out.println( plate+ " PLAKALI ARAÇ SİSTEMDE BULUNAMADI...");
        }else{
            car.setIsReseved(false);
            car.setNumMonth(0);
            car.setNumWeek(0);
            car.setNumDay(0);

            for(Reservation reservation : reservationList){
                for(Car reservCar :reservation.getCarList()){
                    if(car.getPlate().equals(reservCar.getPlate())){
                        reservationList.remove(reservation);
                        System.out.println("REZERVASYON SİLİNDİ...");
                    }
                }
            }
        }
    }
    
    public void deleteCarFromList() throws IOException{
        
        System.out.println("SİLİNMESİNİ İSTEDİĞİNİZ ARACIN ŞASE NUMARASINI GİRİN ");
        String saseNo=readConsoleData();
        int count=0;
        for(Car car: carList){
            if(car.getSaseNo().equals(saseNo)){
                carList.remove(count);
                System.out.println( count + " adet araç sistemden silindi...");
            }
            count++;
        }

    }
    
    public void deleteCustomerFromList() throws IOException{
         System.out.println("SİLİNMESİNİ İSTEDİĞİNİZ MÜŞTERİNİN KİMLİK NUMARASINI GİRİN ");
        String identityCarNo=readConsoleData();
        int count=0;
        for(Customer customer: customerList){
            if(customer.getIdentityNo().equals(identityCarNo)){
                customerList.remove(count);
                System.out.println( count + " adet müşteri sistemden silindi...");
            }
            count++;
        }
    }
    
    public void insertNewCustomerModel() throws IOException {
        Customer customer = new Customer();
        
        System.out.println("KİMLİK NUMARASI : ");
        Long identityNo=Long.parseLong(readConsoleData());
        customer.setIdentityNo(identityNo);
       
        System.out.println("ADI : ");
        String name=readConsoleData();
        customer.setCustomerName(name);
        
        System.out.println("SOYADI : ");
        String surName=readConsoleData();
        customer.setCustomerSurname(surName);
        
        System.out.println("YAŞI : ");
        Integer age=Integer.parseInt(readConsoleData());
        customer.setCustomerAge(age);
        if(age<18){
            customer.setIsValid(false);
        }else{
            customer.setIsValid(true);
        }
        customer.setCustomerAdress(createAdress());
        
        System.out.println("SÜRÜCÜ KART NO : ");
        Integer  driverCardNo=Integer.parseInt(readConsoleData());
        customer.setDriverCarNumber(driverCardNo);
    
        System.out.println("CEP NUMARASI : "); 
        String cebNo=readConsoleData();
        customer.setPhoneNumber(cebNo);
        customerList.add(customer);
        
    
    }
    
    public String readConsoleData() throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s = br.readLine();
         return s;
    }
    
    public Adress createAdress()throws IOException{
        Adress adress = new Adress();
        
        System.out.println("İL : ");
        String city=readConsoleData();
        adress.setCity(city);
  
        System.out.println("İLÇE : ");
        String district=readConsoleData();
        adress.setDistrict(district);
        
        System.out.println("SOKAK : ");
        String street=readConsoleData();
        adress.setStress(street);
        
        System.out.println("APARTMAN : ");
        String apartment=readConsoleData();
        adress.setApartment(apartment);
        
        System.out.println("KAPI NO : ");
        Integer doorNo=Integer.parseInt(readConsoleData());
        adress.setDoorNo(doorNo);
        return adress;
    }

    public String checkToContinue()throws IOException {
        System.out.println("DEVAM ETMEK İÇİN * ÇIKIŞ İÇİN 0 GİRİN  ");
        String key=readConsoleData();
        return key;
    }

    public Reservation insertNewReservationModel() throws IOException {
        Reservation reservation=null;
        System.out.println("REZERVASYONU YAPACAK MÜŞTERİ KİMLİK NUMARASINI GİRİN :  ");
        Long reservationCustomerIdentityNumber=Long.parseLong(readConsoleData());
        Customer customer = findCustomer(reservationCustomerIdentityNumber);
        if(customer==null){
            System.out.println("GİRİLEN BİLGİYE AİT MÜŞTERİ BULUNMAMAKTADIR...");
        }else {
            reservation = new Reservation();
            if(!customer.isIsValid()){
                System.out.println("ŞAHSIN ARAÇ KULLANMA YETKİSİ BULUNMAMAKTADIR...");
            }else {
                reservation.setCustomer(customer);
                System.out.println(customer.getCustomerName() + " "+ customer.getCustomerSurname() + "KAÇ ADET ARAÇ KİRALAYACAK ? :  ");
                Integer countOfRentCar=Integer.parseInt(readConsoleData());

                System.out.println("REZERVASYON BAŞLANGIÇ TARİHİNİ GİRİNİZ  [DD/MM/YYYY]  : ");
                Date reservationBeginDate = Date.valueOf(readConsoleData());
                reservation.setRezervBeginDate(reservationBeginDate);

                System.out.println("REZERVASYON BAŞLANGIÇ TARİHİNİ GİRİNİZ  [DD/MM/YYYY]  : ");
                Date reservationEndDate = Date.valueOf(readConsoleData());
                reservation.setRezervEndDate(reservationEndDate);

                Long[] dayWeekMonth = seperateReservationDateAndSetToCar(reservationBeginDate,reservationEndDate);


                List<Car> rezervCarList = new ArrayList<>();
                for(int i=0;i<countOfRentCar;i++){
                    System.out.println(i+  ".  ARACIN PLAKASI :  " );
                    String plate = readConsoleData();
                    Car car = findNotReservedCar(plate);
                    if(car!=null){
                        car.setIsReseved(true);
                        car.setNumDay(dayWeekMonth[0].intValue());
                        car.setNumWeek(dayWeekMonth[1].intValue());
                        car.setNumMonth(dayWeekMonth[2].intValue());
                        car.setDailyCost(10);
                        car.setWeeklyCost(7);
                        car.setMonthlyCost(5);
                        rezervCarList.add(car);
                    }else{
                        System.out.println(plate + " PLAKALI ARAÇ BULUNAMADI. LÜTFEN REZERV EDİLMEDİĞİNDEN EMİN OLUN...");
                    }
                }
            }
        }
        reservationList.add(reservation);
        return reservation;
    }
    public Long[] seperateReservationDateAndSetToCar(Date reservationBeginDate, Date reservationEndDate){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(reservationBeginDate);
        cal2.setTime(reservationEndDate);
        Long milSecondReservationBegin = cal1.getTimeInMillis();
        Long milSecondReservationEnd = cal2.getTimeInMillis();
        Long diff = milSecondReservationEnd-milSecondReservationBegin;
        Long diffDays = diff/(24*60*60*1000);
        Long diffWeek = diff/(7*24*60*60*1000);
        Long diffMont = diff/(30*7*24*60*1000);
        return new Long[]{diffDays,diffWeek,diffMont};

    }
    public Customer findCustomer(Long reservationCustomerIdentityNumber) {
        int i = 0;
        for(Customer customer : customerList){
            if(customer.getIdentityNo().equals(reservationCustomerIdentityNumber)){
                return customerList.get(i);
            }
            i++;
        }
        return null;
    }
    public Car findNotReservedCar(String plate){
        for(Car car:carList){
            if(car.isIsReseved()==false && car.getPlate().equals(plate)){

                return car;
            }
        }
        return null;
    }

    public Car findReservedCar(String plate){
        for(Car car:carList){
            if(car.isIsReseved()==true && car.getPlate().equals(plate)){

                return car;
            }
        }
        return null;
    }
}
