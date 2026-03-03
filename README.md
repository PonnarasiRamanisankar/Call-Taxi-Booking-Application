# Call Taxi Booking System
 <img width="1360" height="637" alt="image" src="https://github.com/user-attachments/assets/7b13c087-46ec-4239-9b0c-4a7eb2ac5193" />

## 🚖 **Project Overview**

A **complete Call Taxi Booking Application** built in Java following **OOP principles** with **user input interface**. Customers can book taxis on a linear route (A→B→C→D→E→F) with intelligent taxi allocation based on 4 business rules.

## ✨ **Features**

- ✅ **4 Taxis** (Taxi-1, Taxi-2, Taxi-3, Taxi-4) starting at Point A
- ✅ **6 Points** on linear route: A, B, C, D, E, F (15km apart, 60min travel time)
- ✅ **Smart Allocation Rules**:
  1. Free taxi at pickup point first
  2. Nearest free taxi if none at pickup
  3. Lower earnings taxi if multiple available at same point
  4. Reject if no taxi available
- ✅ **Dynamic Pricing**: ₹100 for first 5km + ₹10/km thereafter
- ✅ **Interactive Menu**: Book taxi / View details / Exit
- ✅ **Real-time Earnings Tracking**
- ✅ **Input Validation**

## 📁 **Package Structure**

 
      com.calltaxi/
      ├── model/           # Data classes
      │   ├── Point.java
      │   ├── Taxi.java
      │   └── Booking.java
      ├── dao/             # Data Access
      │   └── TaxiDAO.java
      ├── service/         # Business Logic
      │   └── TaxiBookingService.java
      └── main/            # Entry Point
          └── CallTaxiMain.java
 

## 🎮 **Sample Usage**

```
=== CALL TAXI BOOKING SYSTEM ===
Points available: A, B, C, D, E, F

1. Book Taxi
2. Display Taxi Details
3. Exit
Choose option: 1

Enter Customer ID: 1
Enter Pickup Point (A/B/C/D/E/F): A
Enter Drop Point (A/B/C/D/E/F): B
Enter Pickup Time: 9
Taxi can be allotted. Taxi-1 is allotted.

1. Book Taxi
2. Display Taxi Details
3. Exit
Choose option: 2

=== TAXI DETAILS ===
Taxi-1 Total Earnings: Rs. 200
BookingID  CustomerID  From  To  PickupTime  DropTime  Amount
1          1          A     B   9           10        200

Taxi-2 Total Earnings: Rs. 0
...
```

## 💰 **Pricing Examples**

| Pickup | Drop | Distance | Fare |
|--------|------|----------|------|
| A→B | 15km | ₹200 |
| B→D | 30km | ₹350 |
| A→D | 45km | ₹500 |
| C→F | 45km | ₹500 |

**Formula**: `₹100 (first 5km) + ₹10 × (distance - 5km)`

## 🧠 **Business Rules Implemented**

```
1. Customer ID: 1, Pickup: A, Drop: B, Time: 9
   → Taxi-1 allotted (available at A)

2. Customer ID: 2, Pickup: B, Drop: D, Time: 9  
   → Taxi-2 allotted (nearest available)

3. Customer ID: 3, Pickup: B, Drop: C, Time: 12
   → Taxi-1 allotted (returns to B by time 10, available)
```

## 🔧 **Technical Highlights**

- **No Enums** - Normal Point class with static factory
- **No Interfaces** - Single DAO class  
- **No Streams/Lambdas** - Basic for loops only
- **No Math.abs** - Manual absolute distance calculation
- **Pure OOP** - Model-Service-DAO pattern
- **Input Validation** - Error handling for invalid inputs

## 📊 **Sample Output**

```
Taxi-1 Total Earnings: Rs. 400
BookingID  CustomerID  From  To  PickupTime  DropTime  Amount
1          1          A     B   9           10        200
3          3          B     C   12          13        200

Taxi-2 Total Earnings: Rs. 350
BookingID  CustomerID  From  To  PickupTime  DropTime  Amount
2          2          B     D   9           11        350
```

## 🚀 **Scalability**

- **Add Taxis**: Change `for (int i = 1; i <= 4; i++)` to desired count
- **Add Points**: Extend `Point[] points` array
- **Modify Pricing**: Update `calculateFare()` method

## 📚 **Learning Objectives**

- OOP Design Patterns
- Package Structure
- User Input Handling
- Business Rule Implementation
- Data Modeling
- Console Application Development

## 📄 **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

***

**Built with ❤️ for learning Java OOP & System Design**  
 
