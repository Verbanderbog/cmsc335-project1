
import java.util.*;

/*
Dylan Veraart
3/23/2019
SeaPort.java
Seaports are created when 'port' lines in the open file are processed by the 
World object. These objects store various child docks, ships and persons.
*/
public class SeaPort extends Thing {
    ArrayList<Dock> docks;
    ArrayList<Ship> que;
    ArrayList<Ship> ships;
    ArrayList<Person> persons;

    public SeaPort(Scanner sc) throws InvalidInputException {
        super(sc);
        docks = new ArrayList<>();
        que = new ArrayList<>();
        ships = new ArrayList<>();
        persons = new ArrayList<>();
    }//Builds SeaPort when line found in file
    

    @Override
    public String toString(){        
        return "SeaPort: " + super.toString() + "\n\n";
    }//returns SeaPort name and index as a string with proper label

}
