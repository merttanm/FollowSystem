/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import followsystem.model.Car;
import followsystem.model.Customer;
import followsystem.model.Reservation;
import view.CarView;
import view.CustomerView;
import view.ReservationView;

/**
 *
 * @author Mert Tan
 */
public class RentAcarController {
    
   private Car car;
   private Customer customer;
   private Reservation reservation;
   
    
   private CarView carView;
   private CustomerView customerView;
   private ReservationView reservationView;

    public RentAcarController(Car car, CarView carView) {
        this.car = car;
        this.carView = carView;
    }

    public RentAcarController(CustomerView customerView) {
        this.customerView = customerView;
    }

    public RentAcarController(Reservation reservation, ReservationView reservationView) {
        this.reservation = reservation;
        this.reservationView = reservationView;
    }

    public RentAcarController() {
    }

   
   
   
   
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public CarView getCarView() {
        return carView;
    }

    public void setCarView(CarView carView) {
        this.carView = carView;
    }

    public CustomerView getCustomerView() {
        return customerView;
    }

    public void setCustomerView(CustomerView customerView) {
        this.customerView = customerView;
    }

    public ReservationView getReservationView() {
        return reservationView;
    }

    public void setReservationView(ReservationView reservationView) {
        this.reservationView = reservationView;
    }
  
    public void updateCarView(){
        carView.printCarDetail(car);
    }       
   public void updateCustomerView(){
       customerView.printCustomerDetail(customer);
   }
   public void updateRezervaionView(){
       reservationView.printReservationDetailView(reservation);
   }
   
   
}
