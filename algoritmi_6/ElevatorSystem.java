package com.algoritmi.algoritmi_6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Elevator {
    private String name;
    private int currentFloor;

    public Elevator(String name, int currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getName() {
        return name;
    }

    public void moveToFloor(int floor) {
        System.out.println("Elevator " + name + " is moving to floor " + floor);
        this.currentFloor = floor;
    }
}

public class ElevatorSystem {
    public static Elevator closestElevator(int callFloor, List<Elevator> elevators) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - callFloor);
            if (distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }

        return closestElevator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Elevator> elevators = new ArrayList<>();
        elevators.add(new Elevator("A", 0));
        elevators.add(new Elevator("B", 8));

        System.out.print("Enter the floor for elevator call: ");
        int callFloor = scanner.nextInt();

        Elevator closest = closestElevator(callFloor, elevators);
        System.out.println("Sending elevator " + closest.getName() + " to floor " + callFloor);
        closest.moveToFloor(callFloor);

        scanner.close();
    }
}