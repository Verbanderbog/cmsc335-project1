
import java.util.*;

/*
Dylan Veraart
3/23/2019
Person.java
Person objects are created when the file being opened has a 'person' line. Persons
can hold single skill string and have a parent port.
*/
class Person extends Thing {
    String skill;
    
    public Person(Scanner sc) throws InvalidInputException {
        super(sc);
        if (sc.hasNext()) skill = sc.next();
        else throw new InvalidInputException();
    }//Builds Ship when line found in file
    
    @Override
    public String toString(){
        return "Person: " + super.toString();
    } //returns Person name and index as a string with proper label
}
