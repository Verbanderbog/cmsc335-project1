
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djver
 */
public class PassengerShip extends Ship{
    int numberOfOccupiedRooms, numberOfPassenger, numberOfRooms;

    public PassengerShip(Scanner sc) throws InvalidInputException{
        super(sc);
        if (sc.hasNextInt()) numberOfPassenger = sc.nextInt();
        if (sc.hasNextInt()) numberOfRooms = sc.nextInt();
        if (sc.hasNextInt()) numberOfOccupiedRooms = sc.nextInt();
        else throw new InvalidInputException();
    }
    public String toString(){
        return "Passenger " + super.toString();
    }
}
