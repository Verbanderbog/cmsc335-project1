
import java.util.*;
import java.lang.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djver
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
    }
    

    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder("SeaPort: ").append(super.toString()).append("\n\n");
        
        return retString.toString();
    }

}
