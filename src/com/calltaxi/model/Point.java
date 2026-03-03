package com.calltaxi.model;

public class Point {
    private String name;
    private int position;
    
    private static final Point[] points = {
        new Point("A", 0),
        new Point("B", 1), 
        new Point("C", 2),
        new Point("D", 3),
        new Point("E", 4),
        new Point("F", 5)
    };
    
    private Point(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public static Point getPoint(String pointName) {
        for (Point point : points) {
            if (point.name.equalsIgnoreCase(pointName)) {
                return point;
            }
        }
        throw new IllegalArgumentException("Invalid point: " + pointName);
    }
    
    public static Point getPointByChar(char pointChar) {
        return getPoint(String.valueOf(pointChar));
    }
    
    public int getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return position == point.position;
    }
    
    @Override
    public int hashCode() {
        return position;
    }
}
