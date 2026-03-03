package com.calltaxi.dao;

import com.calltaxi.model.*;
import java.util.*;

public class TaxiDAO {
    private List<Taxi> taxis;
    private int nextBookingId = 1;
    
    public TaxiDAO() {
        taxis = new ArrayList<>();
        initializeTaxis();
    }
    
    private void initializeTaxis() {
        for (int i = 1; i <= 4; i++) {
            taxis.add(new Taxi(i));
        }
    }
    
    public List<Taxi> getAllTaxis() {
        return new ArrayList<>(taxis);
    }
    
    public Taxi allocateTaxi(int customerId, String pickupStr, String dropStr, int pickupTime) {
        Point pickupPoint = Point.getPointByChar(pickupStr.charAt(0));
        Point dropPoint = Point.getPointByChar(dropStr.charAt(0));
        
        // Rule 1: Check free taxi at pickup point
        Taxi taxiAtPickup = findFreeTaxiAtPoint(pickupStr);
        if (taxiAtPickup != null) {
            assignBooking(taxiAtPickup, customerId, pickupPoint, dropPoint, pickupTime);
            return taxiAtPickup;
        }
        
        // Rule 2: Find nearest free taxi
        Taxi nearestTaxi = findNearestFreeTaxiBasic(pickupPoint);
        if (nearestTaxi != null) {
            assignBooking(nearestTaxi, customerId, pickupPoint, dropPoint, pickupTime);
            return nearestTaxi;
        }
        
        return null;
    }
    
    private void assignBooking(Taxi taxi, int customerId, Point pickupPoint, Point dropPoint, int pickupTime) {
        Booking booking = new Booking(nextBookingId++, customerId, pickupPoint, dropPoint, pickupTime, taxi);
        taxi.addBooking(booking);
        taxi.setFree(false);
        taxi.setCurrentTime(pickupTime);
    }
    
    
    private Taxi findFreeTaxiAtPoint(String pointStr) {
        Point point = Point.getPointByChar(pointStr.charAt(0));
        Taxi selectedTaxi = null;
        double minEarnings = Double.MAX_VALUE;
        
        for (Taxi taxi : taxis) {
            if (taxi.isFree() && taxi.getCurrentPosition().equals(point)) {
                if (taxi.getTotalEarnings() < minEarnings) {
                    minEarnings = taxi.getTotalEarnings();
                    selectedTaxi = taxi;
                }
            }
        }
        return selectedTaxi;
    }
    
     
    private Taxi findNearestFreeTaxiBasic(Point pickupPoint) {
        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        
        for (Taxi taxi : taxis) {
            if (taxi.isFree()) {
                int distance = Math.abs(taxi.getCurrentPosition().getPosition() - pickupPoint.getPosition());
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedTaxi = taxi;
                }
            }
        }
        return selectedTaxi;
    }
}
