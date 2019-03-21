
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
class Job extends Thing{
    double duration;
    ArrayList<String> requirements;

    public Job(Scanner sc) throws InvalidInputException {
        super(sc);
    }
    
}
