
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
public class Dock extends Thing {
    Ship ship;

    public Dock(Scanner sc) throws InvalidInputException {
        super(sc);
        int i;
        if (sc.hasNextInt()) i = sc.nextInt();
        else throw new InvalidInputException();
        ship = new Ship("ERROR: Unknown Ship", i, index);
    }
    public String toString(){
        return "Dock: " + super.toString();
    }
}
