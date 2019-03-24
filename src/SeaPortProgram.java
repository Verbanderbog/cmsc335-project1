
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/*
Dylan Veraart
3/23/2019
SeaPortProgram.java
Creates a GUI that allows the user to load a file describing a hierarchy of 
ports, docks, ships, and workers. The program also tracks various information 
about these objects. The program is able to list all these objects in a 
readable format. Finally the program allows a user to search the hierarchy by 
index, name, skill, parent index, or parent name.
*/


public class SeaPortProgram extends JFrame{

    private World world;
    
    public SeaPortProgram(){
        JTextArea text=new JTextArea();
        JTextField searchField = new JTextField();
        JComboBox searchType = new JComboBox(new String[]{"Index", "Name", "Skill", "Parent Index", "Parent Name"});
        JComponent[] enableable = new JComponent[5];
        ActionListener seaportListener;
        seaportListener = (ActionEvent e) -> {
            switch (e.getActionCommand()){
                case "open":
                    text.setText(chooseFile(enableable));
                    break;
                case "display":
                    text.setText(world.toString());
                    break;
                case "search":
                    text.setText(search(String.valueOf(searchType.getSelectedItem()),searchField.getText()));
            }
        };
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open...");
        JMenuItem display = new JMenuItem("Display File");
        open.setActionCommand("open");
        open.addActionListener(seaportListener);
        display.setActionCommand("display");
        display.addActionListener(seaportListener);
        enableable[0]=display;
        display.setEnabled(false);
        fileMenu.add(open);
        fileMenu.add(display);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        JPanel searchPanel = new JPanel();
        GridBagLayout gridbagLayout = new GridBagLayout();
        searchPanel.setLayout(gridbagLayout);
        GridBagConstraints c = new GridBagConstraints();
        JLabel searchLabel = new JLabel("Search by: ");
        searchLabel.setEnabled(false);
        enableable[1] = searchLabel;
        searchPanel.add(searchLabel,c);
        searchType.setEnabled(false);
        enableable[2] = searchType;
        searchPanel.add(searchType,c);
        
        searchField.setActionCommand("search");
        searchField.addActionListener(seaportListener);
        searchField.setEnabled(false);
        enableable[3] = searchField;
        c.weightx=1;
        c.fill=GridBagConstraints.HORIZONTAL;
        searchPanel.add(searchField,c);
        c.weightx=0;
        JButton searchButton = new JButton("Search");
        searchButton.setEnabled(false);
        searchButton.setActionCommand("search");
        searchButton.addActionListener(seaportListener);
        enableable[4] = searchButton;
        searchPanel.add(searchButton,c);
        this.add(searchPanel, BorderLayout.NORTH);
        
        text.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(text);
        this.add(scrollPane,BorderLayout.CENTER);
        this.setTitle("Sea Port Program");
    }//Builds GUI elements
    private void enableComponents(JComponent[] enableable, boolean y){
        for (JComponent component : enableable){
            component.setEnabled(y);
        }
    }//helper method to enable or disable GUI elements based on if a file is loaded
    private String chooseFile(JComponent[] enableable){
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
                enableComponents(enableable,true);
                return world.toString();
            } catch (InvalidInputException e) {
                enableComponents(enableable,false);
                return "An error in the file \"" + file.toString() + "\" on line " + e.getMessage() + " prevented the file from being read.";
            } finally {
                this.setTitle(file.getName() + " - Sea Port Program");
            }
        } catch (FileNotFoundException ex) {
             return "File not found.";
        }
    }//helper method tochoose and load a file and create a world object
    private String search(String type, String value){
        if (world==null) return "No file is loaded to search";
        switch (type){
            case "Parent Name":
                return world.searchByParentName(value);
            case "Skill":
                return world.searchBySkill(value);
            case "Parent Index":
                return world.searchByParentIndex(value);
            case "Index":
                return world.searchByIndex(value);
            case "Name":
                return world.searchByName(value);
            default:
                return "Not a valid search type.";
        }
    }//helper method performs a search of given type on given value

    public static void main(String[] args) {
        SeaPortProgram spp = new SeaPortProgram();
        spp.setMinimumSize(new Dimension(400,300));
        spp.setLocationRelativeTo(null);
        spp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spp.pack();
        spp.setVisible(true);
        
    }//Builds and displays GUI
}
