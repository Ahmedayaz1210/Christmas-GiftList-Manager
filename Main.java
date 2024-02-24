package ListPackage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import utils.Name;

public class Main {
    public static void main(String[] args) {
    	SantaClaus santa = new SantaClaus();
    	String filename = "C:\\Users\\Ahmed Ayaz\\eclipse-workspace\\Data Structures\\src\\ListPackage\\people.txt";
        readNames(filename,santa);

        System.out.println("Nice List: ");
        santa.printNiceList();
        System.out.println("Naughty List: ");
        santa.printNaughtyList();

    }
    
    private static void readNames(String filename, SantaClaus santa) {
    	try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	       String[] nameBelongs = line.split(" ");
    	       if(nameBelongs.length == 2) {
    	    	   String firstName = nameBelongs[0];
    	    	   String lastName = nameBelongs[1];
    	    	   Name name = new Name(firstName,lastName);
    	    	   santa.addToNaughtyList(name);
    	       }else if(nameBelongs.length > 2) {
    	    	   String firstName = nameBelongs[0];
    	    	   String lastName = nameBelongs[1];
    	    	   Name name = new Name(firstName,lastName);
    	    	   String gifts = line.substring(line.indexOf(nameBelongs[2]));
    	    	   santa.addToNiceList(name, gifts);
    	       }
    	    }
    	}catch (IOException e){
    		e.printStackTrace();
    	}
    }
}
