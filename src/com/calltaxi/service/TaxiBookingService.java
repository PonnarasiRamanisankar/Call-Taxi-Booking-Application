package com.calltaxi.service;

import com.calltaxi.dao.TaxiDAO;
import com.calltaxi.model.Taxi;

public class TaxiBookingService {
    private TaxiDAO taxiDAO;
    
    public TaxiBookingService() {
        this.taxiDAO = new TaxiDAO();
    }
    
    public String bookTaxi(int customerId, String pickup, String drop, int pickupTime) {
        Taxi allocatedTaxi = taxiDAO.allocateTaxi(customerId, pickup, drop, pickupTime);
        if (allocatedTaxi != null) {
            return String.format("Taxi can be allotted. Taxi-%d is allotted.", allocatedTaxi.getTaxiId());
        }
        return "Booking rejected. No taxi available.";
    }
    
    public void displayTaxiDetails() {
        taxiDAO.getAllTaxis().forEach(this::displaySingleTaxiDetails);
    }
    
    private void displaySingleTaxiDetails(Taxi taxi) {
        System.out.printf("Taxi-%d Total Earnings: Rs. %.0f%n", 
            taxi.getTaxiId(), taxi.getTotalEarnings());
        System.out.println("BookingID\tCustomerID\tFrom\tTo\tPickupTime\tDropTime\tAmount");
        taxi.getBookings().forEach(booking -> 
            System.out.println(booking.toString()));
        System.out.println();
    }
}
