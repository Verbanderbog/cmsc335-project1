
import java.io.*;
import java.util.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author djver
 */
public class SeaPortProgram extends JFrame {

    World world;
    
    public SeaPortProgram(){
        System.out.println(chooseFile());
        System.out.println(search("index","30003"));
    }
    public String chooseFile(){
        try{
            JFileChooser jfc = new JFileChooser (".");
            jfc.showOpenDialog(this);
            File file;
            Scanner sc;
            try{
            file = jfc.getSelectedFile();
            sc = new Scanner(file);
            } catch(NullPointerException exx){
                return "Please pick a file.";
            }
            try {
                world = new World(sc);
                return world.toString();
            } catch (InvalidInputException e) {
                return "An error in the file \"" + file.toString() + "\" on line " + e.getMessage() + " prevented the file from being read.";
            }
        } catch (FileNotFoundException ex) {
             return "File not found.";
        }
    }
    public String search(String type, String value){
        if (world==null) return "No file is loaded to search";
        switch (type){
            case "parentname":
                return world.searchByParentName(value);
            case "skill":
                return world.searchBySkill(value);
            case "parentindex":
                return world.searchByParentIndex(value);
            case "index":
                return world.searchByIndex(value);
            case "name":
                return world.searchByName(value);
            default:
                return "Not a valid search type.";
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SeaPortProgram spp = new SeaPortProgram();
    }
    
    
}
