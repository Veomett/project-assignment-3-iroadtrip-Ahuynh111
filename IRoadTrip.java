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

    //DEFAULT COUNTRY CONSTRUCTOR//
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

            findNeighborsList(bordersFile, createCountryList(stateScanner));

        }catch (FileNotFoundException FNFE){
            System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
            System.exit(0);
        }


    }

    //CREATE LIST OF COUNTRIES//
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
                    if(splitLine[1].equals("USA")){
                        Country c = new Country(splitLine[0], splitLine[1], "United States");
                        headCountry = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else{
                        Country c = new Country(splitLine[0], splitLine[1], splitLine[2]);
                        headCountry = c;
                        pointerCountry = c;
                        totalCountries++;                        
                    }
                }
            }else{
                String line = states.nextLine();
                String[] splitLine = line.split("\t");
                if (splitLine[4].equals("2020-12-31")){
                    if(splitLine[1].equals("USA")){
                        Country c = new Country(splitLine[0], splitLine[1], "United States");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("TAZ")){
                        Country c = new Country(splitLine[0], splitLine[1], "Tanzania");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("DRV")){
                        Country c = new Country(splitLine[0], splitLine[1], "Vietnam");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("PRK")){
                        Country c = new Country(splitLine[0], splitLine[1], "Korea, North");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("ROK")){
                        Country c = new Country(splitLine[0], splitLine[1], "Korea, South");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("MYA")){
                        Country c = new Country(splitLine[0], splitLine[1], "Burma");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("GFR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Germany");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("CZR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Czechia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("ITA")){
                        Country c = new Country(splitLine[0], splitLine[1], "Italy");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("MAC")){
                        Country c = new Country(splitLine[0], splitLine[1], "North Macedonia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("BOS")){
                        Country c = new Country(splitLine[0], splitLine[1], "Bosnia and Herzegovina");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("RUS")){
                        Country c = new Country(splitLine[0], splitLine[1], "Russia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("BLR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Belarus");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("CAP")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cabo Verde");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("EQG")){
                        Country c = new Country(splitLine[0], splitLine[1], "Equatorial Guinea");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("CDI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cote d'Ivoire");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("GAM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Gambia, The");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("GUI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Guinea");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("BFO")){
                        Country c = new Country(splitLine[0], splitLine[1], "Burkina Faso");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("DRC")){
                        Country c = new Country(splitLine[0], splitLine[1], "Democratic Republic of the Congo");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equals("ZIM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Zimbabwe");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("IRN")){
                        Country c = new Country(splitLine[0], splitLine[1], "Iran");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("TUR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Turkey");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("YEM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Yemen");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("KYR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Kyrgyzstan");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("SRI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Sri Lanka");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("CAM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cambodia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equals("ETM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Timor-Leste");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else{
                        Country c = new Country(splitLine[0], splitLine[1], splitLine[2]);
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }
                }
            }
        }

        /*print list of countries
        pointerCountry = headCountry;
        while(pointerCountry.next != null){
            System.out.println(pointerCountry.Name);
            pointerCountry = pointerCountry.next;
        }*/

        return headCountry;

    }

    //FIND ALL NEIGHBORS AND DISTANCES//
    public void findNeighborsList(File borders, Country headCountry){
        Country pointerCountry = headCountry;

        while(pointerCountry.next != null){
            try{
                Scanner borderingNeighbors = new Scanner(borders);
                while(borderingNeighbors.hasNextLine()){
                    String neighbors = borderingNeighbors.nextLine();
                    String[] splitNeighbors = neighbors.split("= ");
                    //retrive all neighbors
                    if(splitNeighbors[0].trim().equals(pointerCountry.Name)){
                            System.out.println(setNeighborsList(splitNeighbors, headCountry)); //separate method to add neighbors 
                    }
                }
                pointerCountry = pointerCountry.next;
            }catch (FileNotFoundException FNFE){
                System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
                System.exit(0);
            }
        }
    }

    public Country findCountry(Country head, String target){
        Country pointerCountry = head;
        while(pointerCountry!= null){
            if(pointerCountry.Name.equals(target.trim())){
                break;
            }
            pointerCountry = pointerCountry.next;
        }
        return pointerCountry;
    }

    public boolean isNum(String num){
        if(num == null){
            return false;
        }
        try{
            int number = Integer.parseInt(num);
        }catch (NumberFormatException exception){
            return false;
        }
        return true;
    }



    public HashMap setNeighborsList(String[] neighbors, Country headCountry){
        HashMap<Country, String> listOfNeighbors = new HashMap<Country, String>();
        Country Neighbor;
        boolean foundLetters = true;
        boolean foundNumbers = false;
        System.out.println("----------Country Name: " + neighbors[0]+ "-----------");

        //Set individual hashmaps
        if(neighbors.length >= 2){
            String[] split1 = neighbors[1].split(";");
            for(int i = 0; i < split1.length; i++){
                int index1 = 0;
                String[] split2 = split1[i].split("");
                //Parsing out neighbor name
                while(isNum(split2[index1]) == false){
                    index1++;
                }
                String country = split1[i].substring(0,index1).trim();

                //Parsing out neighbor distance
                int index2 = index1;
                while(isNum(split2[index1]) == true || split2[index1].equals(",")){
                    index1++;
                }
                String distance = split1[i].substring(index2, index1+1).trim();
                System.out.println(country);
                System.out.println(distance);

            }
            
        }
        return listOfNeighbors;

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

