
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djver
 */
public class CargoShip extends Ship {
    double cargoValue, cargoVolume, cargoWeight;

    public CargoShip(Scanner sc) throws InvalidInputException{
        super(sc);
        if (sc.hasNextDouble()) cargoWeight = sc.nextDouble();
        if (sc.hasNextDouble()) cargoVolume = sc.nextDouble();
        if (sc.hasNextDouble()) cargoValue = sc.nextDouble();
        else throw new InvalidInputException();
    }
    public String toString(){
        return "Cargo " + super.toString();
    }
}
