
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
class Person extends Thing {
    String skill;
    
    public Person(Scanner sc) throws InvalidInputException {
        super(sc);
        if (sc.hasNext()) skill = sc.next();
        else throw new InvalidInputException();
    }
}