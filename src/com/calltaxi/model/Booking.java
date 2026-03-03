package com.calltaxi.model;

public class Booking {
    private int bookingId;
    private int customerId;
    private Point pickupPoint;
    private Point dropPoint;
    private int pickupTime;
    private int dropTime;
    private double amount;
    private Taxi taxi;
    
    public Booking(int bookingId, int customerId, Point pickupPoint, Point dropPoint, 
                   int pickupTime, Taxi taxi) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.taxi = taxi;
        this.dropTime = calculateDropTime(pickupTime, dropPoint.getPosition() - pickupPoint.getPosition());
        this.amount = calculateFare(dropPoint.getPosition() - pickupPoint.getPosition());
    }
    
    private int calculateDropTime(int pickupTime, int distanceKm) {
        return pickupTime + (distanceKm * 60);  
    }
    
    private double calculateFare(int distanceKm) {
        if (distanceKm <= 5) return 100.0;
        return 100.0 + ((distanceKm - 5) * 10.0);
    }
    
    // Getters
    public int getBookingId() { 
    	return bookingId;
    	}
    public int getCustomerId() { 
    	return customerId;
    	}
    public Point getPickupPoint() {
    	return pickupPoint;
    	}
    public Point getDropPoint() {
    	return dropPoint; 
    	}
    public int getPickupTime() { 
    	return pickupTime; 
    	}
    public int getDropTime() {
    	return dropTime; 
    	}
    public double getAmount() {
    	return amount;
    	}
    public Taxi getTaxi() { 
    	return taxi;
    	}
    
    @Override
    public String toString() {
        return String.format("%d\t%d\t%s\t%s\t%d\t%d\t%.0f", 
            bookingId, customerId, pickupPoint, dropPoint, pickupTime, dropTime, amount);
    }
}
