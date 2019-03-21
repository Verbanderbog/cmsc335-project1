
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
class Ship extends Thing{
    PortTime arrivalTime, dockTime;
    double draft, length, weight, width;
    ArrayList<Job> jobs;

    public Ship(Scanner sc) throws InvalidInputException{
        super(sc);
        if (sc.hasNextDouble()) weight = sc.nextDouble();
        if (sc.hasNextDouble()) length = sc.nextDouble();
        if (sc.hasNextDouble()) width = sc.nextDouble();
        if (sc.hasNextDouble()) draft = sc.nextDouble();
        else throw new InvalidInputException();
    }
    public Ship(String n, int i, int p){
        super(n,i,p);
    }
            
    @Override
    public String toString(){
        return "Ship: " + super.toString();
    }
}
