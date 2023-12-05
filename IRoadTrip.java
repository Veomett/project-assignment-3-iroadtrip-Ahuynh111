import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;


class Country{
    //Country Identifiers
    String Name;
    String Code; 
    int Number;

    //Linked list of Neighbors (add into hashmap later)
    Country headNeighbor;
    Country tailNeighbor;
    Country nextNeghbor;
    Country next; // general next country in mass list of countries

    //COUNTRY CONSTRUCTOR//
    Country(String num, String c, String n){
        Name = n;
        Code = c;
        Number = Integer.parseInt(num);
    }

    //DEFAULS COUNTRY CONSTRUCTOR//
    Country(){
    }
}

public class IRoadTrip {


    //CONSTRUCTOR//
    public IRoadTrip (String [] args) { 
    ////READ IN FILES////
        if (args.length < 3){
            System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
            System.exit(0);
        }
        
        try{
            File bordersFile = new File(args[0]);
            Scanner borderScanner = new Scanner(bordersFile);
            File capDistFile = new File(args[1]);
            Scanner capDistScanner = new Scanner(capDistFile);
            File stateFile = new File(args[2]);
            Scanner stateScanner = new Scanner(stateFile);

            createMap(borderScanner, capDistScanner, stateScanner);

        }catch (FileNotFoundException FNFE){
            System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
            System.exit(0);
        }
    }

    //CREATE GRAPH OF COUNTRIES//
    public Country createCountryList (Scanner states){
        Country headCountry = new Country();
        Country pointerCountry  = new Country();
        int totalCountries = 0;

        //filter out codes with incorrect dates, add country to major linked list
        while(states.hasNextLine()){
            if(totalCountries == 0){
                String line = states.nextLine();
                String[] splitLine = line.split("\t");
                if (splitLine[4].equals("2020-12-31")){
                    Country c = new Country(splitLine[0], splitLine[1], splitLine[2]);
                    headCountry = c;
                    pointerCountry = c;
                    totalCountries++;
                }
            }else{
                String line = states.nextLine();
                String[] splitLine = line.split("\t");
                if (splitLine[4].equals("2020-12-31")){
                    Country c = new Country(splitLine[0], splitLine[1], splitLine[2]);
                    pointerCountry.next = c;
                    pointerCountry = c;
                    totalCountries++;
                }
            }
        }

        /* print list of countries
        pointerCountry = headCountry;
        while(pointerCountry.next != null){
            System.out.println(pointerCountry.Name);
            pointerCountry = pointerCountry.next;
        }*/

        return headCountry;
    }

    public void findNeighbors(Scanner borders, Country headCountry){
        String neighbors = borders.nextLine();
        String[] splitNeighbors = neighbors.split("[=;]");
        
        


    }

    public int getDistance (String country1, String country2) {
        // Replace with your code
        return -1;
    }


    public List<String> findPath (String country1, String country2) {
        // Replace with your code
        return null;
    }


    public void acceptUserInput() {
        // Replace with your code
        System.out.println("IRoadTrip - skeleton");
    }


    public static void main(String[] args) {
        IRoadTrip a3 = new IRoadTrip(args);
    









        a3.acceptUserInput();
    }

}

