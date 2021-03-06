
import java.util.Scanner;

/*
Dylan Veraart
3/24/2019
CargoShip.java
CargoShip objects are child classes of Ship objects and are created when 
'cship' lines in the open file are processed by the World object.
*/
public class CargoShip extends Ship {
    double cargoValue, cargoVolume, cargoWeight;

    public CargoShip(Scanner sc) throws InvalidInputException{
        super(sc);
        if (sc.hasNextDouble()) cargoWeight = sc.nextDouble();
        if (sc.hasNextDouble()) cargoVolume = sc.nextDouble();
        if (sc.hasNextDouble()) cargoValue = sc.nextDouble();
        else throw new InvalidInputException();
    }//Builds CargoShip when line found in file
    
    @Override
    public String toString(){
        return "Cargo " + super.toString();
    }//returns CargoShip name and index as a string with proper label
}
