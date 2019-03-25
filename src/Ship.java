
import java.util.*;

/*
Dylan Veraart
3/23/2019
Ship.java
Ship objects are created in 3 primary ways. The file being opened has a 'ship' 
line, the PassengerShip or CargoShip objects call the ship constructor as a 
super, or a default Ship object is constructed for a new Dock object.
Ships can have either docks or ports as parents.
*/
class Ship extends Thing{
    PortTime arrivalTime, dockTime;
    double draft, length, weight, width;
    ArrayList<Job> jobs;

    public Ship(Scanner sc) throws InvalidInputException{
        super(sc);
        jobs= new ArrayList<>();
        if (sc.hasNextDouble()) weight = sc.nextDouble();
        if (sc.hasNextDouble()) length = sc.nextDouble();
        if (sc.hasNextDouble()) width = sc.nextDouble();
        if (sc.hasNextDouble()) draft = sc.nextDouble();
        else throw new InvalidInputException();
    }//Builds Ship when line found in file
    
    public Ship(String n, int i, int p){
        super(n,i,p);
    }//Used for building blank Ships for Dock objects
            
    @Override
    public String toString(){
        return "Ship: " + super.toString();
    } //returns Ship name and index as a string with proper label
}
