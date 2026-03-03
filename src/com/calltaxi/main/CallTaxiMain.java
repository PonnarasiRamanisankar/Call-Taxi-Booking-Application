package com.calltaxi.main;

import com.calltaxi.service.TaxiBookingService;

public class CallTaxiMain {
    public static void main(String[] args) {
        TaxiBookingService service = new TaxiBookingService();
        
        System.out.println("=== MODULE 1: TAXI BOOKING ===");
        System.out.println(service.bookTaxi(1, "A", "B", 9));
        System.out.println(service.bookTaxi(2, "B", "D", 9));
        System.out.println(service.bookTaxi(3, "B", "C", 12));
        
        System.out.println("\n=== MODULE 2: TAXI DETAILS ===");
        service.displayTaxiDetails();
    }
} 
/*
package com.calltaxi.main;

import com.calltaxi.service.TaxiBookingService;
import java.util.Scanner;

public class CallTaxiMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxiBookingService service = new TaxiBookingService();
        
        System.out.println("=== CALL TAXI BOOKING SYSTEM ===");
        System.out.println("Points available: A, B, C, D, E, F");
        
        while (true) {
            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter 1, 2 or 3.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    bookTaxi(scanner, service);
                    break;
                case 2:
                    System.out.println("\n=== TAXI DETAILS ===");
                    service.displayTaxiDetails();
                    break;
                case 3:
                    System.out.println("Thank you for using Call Taxi!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose 1, 2 or 3.");
            }
        }
    }
    
    private static void bookTaxi(Scanner scanner, TaxiBookingService service) {
        System.out.print("Enter Customer ID: ");
        int customerId;
        try {
            customerId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Customer ID!");
            return;
        }
        
        System.out.print("Enter Pickup Point (A/B/C/D/E/F): ");
        String pickup = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Enter Drop Point (A/B/C/D/E/F): ");
        String drop = scanner.nextLine().trim().toUpperCase();
        
        System.out.print("Enter Pickup Time: ");
        int pickupTime;
        try {
            pickupTime = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Pickup Time!");
            return;
        }
        
        String result = service.bookTaxi(customerId, pickup, drop, pickupTime);
        System.out.println(result);
    }
}
*/