
import java.util.*;

/*
Dylan Veraart
3/23/2019
World.java
World objects are created by the SeaPortProgram class when a file is opened.
The World constructor is passed a scanner of the opened file and processes it 
into objects of various Thing subclasses. Also contains search functions that
search the file by name, index, skill, parent index, or parent name.
*/
class World extends Thing {
    private ArrayList<SeaPort> ports;
    PortTime time;

    public World(Scanner sc) throws InvalidInputException {
        super("None",-1,-1);
        int x = 1;
        ports=new ArrayList<>();
        while (sc.hasNextLine()){
            try{
                process(sc.nextLine());
                x++;
            } catch (InvalidInputException e) {
                throw new InvalidInputException(Integer.toString(x));
            }
        }
    }//begins processing the input file by calling process() on each line
    
    private void process(String st) throws InvalidInputException{
        Scanner sc = new Scanner(st);
        if (!sc.hasNext())
            return;
        switch (sc.next()){
            case "port":
                ports.add(new SeaPort(sc));
                break;
            case "ship":
                Ship ship = new Ship(sc);
                shipBuilder(ship);
                break;
            case "pship":
                PassengerShip pship = new PassengerShip(sc);
                shipBuilder(pship);
                break;
            case "cship":
                CargoShip cship = new CargoShip(sc);
                shipBuilder(cship);
                break;
            case "person":
                Person person = new Person(sc);
                findSeaPortByIndex(person.parent).persons.add(person);
                break;
            case "dock":
                Dock dock = new Dock(sc);
                findSeaPortByIndex(dock.parent).docks.add(dock);
                Ship tempShip = findShipByIndex(dock.ship.index);
                if (tempShip != null) dock.ship=tempShip;
                break;
            case "//":
                break;
            default:
                throw new InvalidInputException();
        }
    }//Helper method used to process each line of the file and creates an 
    //object as dictated by the file.
    
    public String searchByIndex(String s){
        int i;
        StringBuilder retString= new StringBuilder();
        try{
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return "No results found.";
        }
        for (SeaPort port: ports){
            if (port.index==i) retString.append(port.toString());
            for (Ship ship: port.ships){
                if (ship.index==i) retString.append(ship.toString());
            }
            for (Dock dock: port.docks){
                if (dock.index==i) retString.append(dock.toString());
            }
            for (Person person: port.persons){
                if (person.index==i) retString.append(person.toString());
            }
        }
        if (retString.length()<=0) retString.append("No results found.");
        return retString.toString();
    }//public fuction used to search the file by index
    
    public String searchByParentIndex(String s){
        int i;
        StringBuilder retString= new StringBuilder();
        try{
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return "No results found.";
        }
        for (SeaPort port: ports){
            if (port.parent==i) retString.append(port.toString());
            for (Ship ship: port.ships){
                if (ship.parent==i) retString.append(ship.toString());
            }
            for (Dock dock: port.docks){
                if (dock.parent==i) retString.append(dock.toString());
            }
            for (Person person: port.persons){
                if (person.parent==i) retString.append(person.toString());
            }
        }
        if (retString.length()<=0) retString.append("No results found.");
        return retString.toString();
    }//public fuction used to search the file by parent index
    
    public String searchByParentName(String s){
        ArrayList<Thing> search = new ArrayList<>();
        for (SeaPort port: ports){
            if (port.name.equalsIgnoreCase(s)) search.add(port);
            for (Ship ship: port.ships){
                if (ship.name.equalsIgnoreCase(s)) search.add(ship);
            }
            for (Dock dock: port.docks){
                if (dock.name.equalsIgnoreCase(s)) search.add(dock);
            }
            for (Person person: port.persons){
                if (person.name.equalsIgnoreCase(s)) search.add(person);
            }
        }
        StringBuilder retString = new StringBuilder();
        for (Thing term: search){
            for (SeaPort port: ports){
            if (port.parent==term.index) retString.append(port.toString());
            for (Ship ship: port.ships){
                if (ship.parent==term.index) retString.append(ship.toString());
            }
            for (Dock dock: port.docks){
                if (dock.parent==term.index) retString.append(dock.toString());
            }
            for (Person person: port.persons){
                if (person.parent==term.index) retString.append(person.toString());
            }
        }
        }
        if (retString.length()<=0) retString.append("No results found.");
        return retString.toString();
    }//public fuction used to search the file by parent name
    
    public String searchBySkill(String s){
        StringBuilder retString= new StringBuilder();
        for (SeaPort port: ports){
            for (Ship ship: port.ships){
                for (Job job: ship.jobs){
                    for (String requirement: job.requirements){
                        if (requirement.equalsIgnoreCase(s)) retString.append(job.toString());
                    }
                }
            }
            for (Person person: port.persons){
                if (person.skill.equalsIgnoreCase(s)) retString.append(person.toString());
            }
        }
        if (retString.length()<=0) retString.append("No results found.");
        return retString.toString();
    }//public fuction used to search the file by skill
    
    public String searchByName(String s){
        StringBuilder retString= new StringBuilder();
        for (SeaPort port: ports){
            if (port.name.equalsIgnoreCase(s)) retString.append(port.toString());
            for (Ship ship: port.ships){
                if (ship.name.equalsIgnoreCase(s)) retString.append(ship.toString());
            }
            for (Dock dock: port.docks){
                if (dock.name.equalsIgnoreCase(s)) retString.append(dock.toString());
            }
            for (Person person: port.persons){
                if (person.name.equalsIgnoreCase(s)) retString.append(person.toString());
            }
        }
        if (retString.length()<=0) retString.append("No results found.");
        return retString.toString();
    }//public fuction used to search the file by name
    
    private Ship findShipByIndex(int i){
        for (SeaPort msp: ports){
            for (Ship ms: msp.ships){
                if (ms.index==i) return ms;
            }
        }
        return null;
    }//helper method to find ship by index and return the Ship object
    
    private SeaPort findSeaPortByIndex(int i){
        for (SeaPort msp: ports){
            if (msp.index==i) return msp;
        }
        return null;
    }//Helper method that returns the SeaPort at a given index
    
    private Thing[] findDockByIndex(int i){
        Thing[] dockAndPort = new Thing[2];
        for (SeaPort msp: ports){
            for (Dock ms: msp.docks){
                if (ms.index==i) {
                    dockAndPort[0]=ms;
                    dockAndPort[1]=msp;
                    return dockAndPort;
                }
            }
        }
        return null;
    }//Helper method that returns a 2 sized array of Things 
    //First the Dock at a given index and then the parent SeaPort
    
    
    @Override
     public String toString(){
         StringBuilder retString=new StringBuilder();
         retString.append(">>>>> The world:\n\n\n");
         for (SeaPort port: ports){
             retString.append(port.toString());
             for (Dock dock : port.docks) {
                retString.append(" ");
                retString.append(dock.toString());
                retString.append("  Ship: ");
                retString.append(dock.ship.toString());
                retString.append("\n");
            }
            retString.append(" --List of all ships in queue:\n");
            for (Ship ship : port.que){
                retString.append("  >");
                retString.append(ship.toString());
            }
            retString.append("\n --List of all ships\n");
            for (Ship ship : port.ships){
                retString.append("  >");
                retString.append(ship.toString());
            }
            retString.append("\n --List of all persons\n");
            for (Person person : port.persons){
                retString.append("  >");
                retString.append(person.toString());
            }
         }
         return retString.toString();
    }//Builds the display string for the whole file based on the object structure
     
    private void shipBuilder(Ship s){
        try {
            SeaPort port = findSeaPortByIndex(s.parent);
            port.que.add(s);
            port.ships.add(s);
        } catch (NullPointerException e){
            Thing[] dockAndPort = findDockByIndex(s.parent);
            ((Dock) dockAndPort[0]).ship=s;
            ((SeaPort) dockAndPort[1]).ships.add(s);
        }
    }//Helper method when processing ship lines in process()
    
}
