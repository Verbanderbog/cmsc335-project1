
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
class Thing implements Comparable<Thing> {
    int index;
    String name;
    int parent;
    Thing(String n,int i,int p){
        name=n;
        index=i;
        parent=p;
    }
    Thing(Scanner sc) throws InvalidInputException{
        if (sc.hasNext()) name = sc.next();
        if (sc.hasNextInt()) index = sc.nextInt();
        if (sc.hasNextInt()) parent = sc.nextInt();
        else throw new InvalidInputException();
    }
    @Override
    public int compareTo(Thing o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        return name + " " + Integer.toString(index)+"\n";
    }
    
}
