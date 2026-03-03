package com.calltaxi.model;

import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private Point currentPosition;
    private double totalEarnings;
    private boolean isFree;
    private int currentTime;
    private List<Booking> bookings;
    
    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentPosition = Point.getPoint("A");
        this.totalEarnings = 0.0;
        this.isFree = true;
        this.currentTime = 0;
        this.bookings = new ArrayList<>();
    }
    
    // Getters and Setters
    public int getTaxiId() {
    	return taxiId;
    	}
    public Point getCurrentPosition() {
    	return currentPosition; 
    	}
    public void setCurrentPosition(Point currentPosition) { 
    	this.currentPosition = currentPosition;
    	}
    public double getTotalEarnings() { 
    	return totalEarnings; 
    	}
    public void setTotalEarnings(double totalEarnings) { 
    	this.totalEarnings = totalEarnings; 
    	}
    public boolean isFree() { 
    	return isFree; 
    	}
    public void setFree(boolean free) { 
    	isFree = free; 
    	}
    public int getCurrentTime() {
    	return currentTime; 
    	}
    public void setCurrentTime(int currentTime) {
    	this.currentTime = currentTime;
    	}
    public List<Booking> getBookings() { 
    	return bookings;
    	}
    
    public void addBooking(Booking booking) {
        bookings.add(booking);
        totalEarnings += booking.getAmount();
    }
    
    public void updatePositionAndTime(Point dropPoint, int dropTime) {
        this.currentPosition = dropPoint;
        this.currentTime = dropTime;
        this.isFree = true;
    }
}
