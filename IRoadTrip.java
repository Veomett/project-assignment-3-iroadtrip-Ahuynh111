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
    Country headCountry;


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

            findNeighborsList(bordersFile, capDistFile, createCountryList(stateScanner));

        }catch (FileNotFoundException FNFE){
            System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
            System.exit(0);
        }


    }

    //CREATE LIST OF COUNTRIES//
    public Country createCountryList (Scanner states){
        headCountry = new Country();
        Country pointerCountry  = new Country();
        int totalCountries = 0;

        //filter out codes with incorrect dates, add country to major linked list
        while(states.hasNextLine()){
            if(totalCountries == 0){
                String line = states.nextLine();
                String[] splitLine = line.split("\t");
                if (splitLine[4].equalsIgnoreCase("2020-12-31")){
                    if(splitLine[1].equalsIgnoreCase("USA")){
                        Country c = new Country(splitLine[0], splitLine[1], "United States");
                        headCountry = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else{
                        Country c = new Country(splitLine[0], splitLine[1], splitLine[2].trim());
                        headCountry = c;
                        pointerCountry = c;
                        totalCountries++;                        
                    }
                }
            }else{
                String line = states.nextLine();
                String[] splitLine = line.split("\t");
                if (splitLine[4].equalsIgnoreCase("2020-12-31")){
                    if(splitLine[1].equalsIgnoreCase("USA")){
                        Country c = new Country(splitLine[0], splitLine[1], "United States");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("TAZ")){
                        Country c = new Country(splitLine[0], splitLine[1], "Tanzania");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("DRV")){
                        Country c = new Country(splitLine[0], splitLine[1], "Vietnam");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("PRK")){
                        Country c = new Country(splitLine[0], splitLine[1], "Korea, North");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("ROK")){
                        Country c = new Country(splitLine[0], splitLine[1], "Korea, South");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("MYA")){
                        Country c = new Country(splitLine[0], splitLine[1], "Burma");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("GFR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Germany");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("CZR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Czechia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("ITA")){
                        Country c = new Country(splitLine[0], splitLine[1], "Italy");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("MAC")){
                        Country c = new Country(splitLine[0], splitLine[1], "North Macedonia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("BOS")){
                        Country c = new Country(splitLine[0], splitLine[1], "Bosnia and Herzegovina");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("RUS")){
                        Country c = new Country(splitLine[0], splitLine[1], "Russia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("BLR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Belarus");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("CAP")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cabo Verde");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("EQG")){
                        Country c = new Country(splitLine[0], splitLine[1], "Equatorial Guinea");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("CDI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cote d'Ivoire");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("GAM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Gambia, The");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("GUI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Guinea");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("BFO")){
                        Country c = new Country(splitLine[0], splitLine[1], "Burkina Faso");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("DRC")){
                        Country c = new Country(splitLine[0], splitLine[1], "Democratic Republic of the Congo");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++; 
                    }else if(splitLine[1].equalsIgnoreCase("ZIM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Zimbabwe");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("IRN")){
                        Country c = new Country(splitLine[0], splitLine[1], "Iran");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("TUR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Turkey");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("YEM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Yemen");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("KYR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Kyrgyzstan");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("SRI")){
                        Country c = new Country(splitLine[0], splitLine[1], "Sri Lanka");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("CAM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Cambodia");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("ETM")){
                        Country c = new Country(splitLine[0], splitLine[1], "Timor-Leste");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else if(splitLine[1].equalsIgnoreCase("SUR")){
                        Country c = new Country(splitLine[0], splitLine[1], "Suriname");
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }else{
                        Country c = new Country(splitLine[0], splitLine[1], splitLine[2].trim());
                        pointerCountry.next = c;
                        pointerCountry = c;
                        totalCountries++;
                    }
                }
            }
        }

        //print list of countries
        pointerCountry = headCountry;
        while(pointerCountry.next != null){
            System.out.println(pointerCountry.Name);
            pointerCountry = pointerCountry.next;
        }

        return headCountry;

    }

    //FIND ALL NEIGHBORS AND DISTANCES//
    public void findNeighborsList(File borders, File distances, Country headCountry){
        Country pointerCountry = headCountry;
        HashMap<Country, HashMap> mapOfNeighbors = new HashMap<Country, HashMap>();

        while(pointerCountry.next != null){
            try{
                Scanner borderingNeighbors = new Scanner(borders);
                while(borderingNeighbors.hasNextLine()){
                    String neighbors = borderingNeighbors.nextLine();
                    String[] splitNeighbors = neighbors.split("= ");
                    //retrive all neighbors
                    if(splitNeighbors[0].trim().equalsIgnoreCase(pointerCountry.Name)){
                            mapOfNeighbors.put(pointerCountry, setNeighborsList(splitNeighbors, distances, headCountry)); //separate method to add neighbors                     
                    }
                }
                pointerCountry = pointerCountry.next;
            }catch (FileNotFoundException FNFE){
                System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
                System.exit(0);
            }
        }
    }

    //FIND COUNTRY IN FULL COUNTRY LINKED LIST//
    public Country findCountry(Country head, String target){
        Country pointerCountry = head;
        String targetName = target;
        //Different name cases
        if(targetName.equals("US") || targetName.equalsIgnoreCase("USA") || targetName.equalsIgnoreCase("United States of America")){
            targetName = "United States";
        }else if(targetName.equalsIgnoreCase("Denmark (Greenland)") || targetName.equalsIgnoreCase("Greenland")){
            targetName = "Denmark";
        }else if(targetName.equalsIgnoreCase("UK")){
            targetName = "United Kingdom";
        }else if(targetName.equalsIgnoreCase("North Korea")){
            targetName = "Korea, North";
        }else if(targetName.equalsIgnoreCase("South Korea")){
            targetName = "Korea, South";
        }else if(targetName.equalsIgnoreCase("Surinam")){
            targetName = "Suriname";
        }

        //find country
        while(pointerCountry!= null){
            if(pointerCountry.Name.equalsIgnoreCase(targetName.trim())){
                break;
            }
            pointerCountry = pointerCountry.next;
        }
        return pointerCountry;
    }

    //CHECK IF STRING IS NUMERICAL//
    public boolean isNum(String num){
        if(num == null){
            return false;
        }
        try{
            double number = Double.parseDouble(num);
        }catch (NumberFormatException exception){
            return false;
        }
        return true;
    }

    //CREATE INDIVIDUAL HASHMAPS OF NEIGHBORS FOR EACH COUNTRY//
    public HashMap setNeighborsList(String[] neighbors, File distances, Country headCountry){
        HashMap<String, Integer> listOfNeighbors = new HashMap<String, Integer>();
        Country country = findCountry(headCountry, neighbors[0]);
        boolean foundLetters = true;
        boolean foundNumbers = false;

        //Set individual hashmaps
        System.out.println("----- Country Name: "+ country.Name );
        if(neighbors.length >= 2){
            String[] split1 = neighbors[1].split(";");
            for(int i = 0; i < split1.length; i++){
                int index1 = 0;
                String[] split2 = split1[i].split("");
                //Parsing out neighbor name
                while(isNum(split2[index1]) == false){
                    index1++;
                }

                String c = split1[i].substring(0,index1).trim();
                Country neighborCountry = findCountry(headCountry, c);
                if(validateInput(headCountry, c)){
                    try{
                        Scanner scan = new Scanner(distances);
                        String distanceText = "";
                        int distance = 0;
                        System.out.println(neighborCountry.Name);
                        System.out.println(c);
                        while(scan.hasNextLine()){
                            distanceText = scan.nextLine();
                            String[] splitDistanceText = distanceText.split(",");
                            if(country.Code.equalsIgnoreCase(splitDistanceText[1]) && neighborCountry.Code.equalsIgnoreCase(splitDistanceText[3])){
                                distance = Integer.parseInt(splitDistanceText[4]);
                                break;
                            }
                        }
                        //hashmap
                        listOfNeighbors.put(neighborCountry.Name, distance);
                    }catch (FileNotFoundException FNFE){
                        System.out.println("ERROR: Please enter the following required files - 'borders.txt' 'capdist.csv' 'state_name.tsv'");
                        System.exit(0);
                    }
                }

            }
        //System.out.println(listOfNeighbors);
            
        }
        return listOfNeighbors;

    }

    //GET DISTANCE BETWEEN TWO COUNTRIES//
    public int getDistance (String country1, String country2) {
        // Replace with your code
        return -1;
    }

    //FIND SHORTEST PATH BETWEEN TWO COUNTRIES//
    public List<String> findPath (String country1, String country2) {
        
        return null;
    }


    public void acceptUserInput() {
        Scanner scan = new Scanner(System.in);
        boolean valid1 = false;
        boolean valid2 = false;
        String firstCountry = " ";
        String secondCountry = " ";
        //prompt user for first country
        while(valid1 == false){
            System.out.println("Enter the name of the first country (type EXIT to quit): ");
            firstCountry = scan.nextLine();
            if(validateInput(headCountry, firstCountry)== true){
                valid1 = true;
            }else if(firstCountry.equalsIgnoreCase("EXIT")== true){
                System.exit(0);
            }else{
                System.out.println("Invalid country name, Please enter a valid country name.");
            }
        }
        //prompt user for second country
        while(valid2 == false){
            System.out.println("Enter the name of the second country (type EXIT to quit): ");
            secondCountry = scan.nextLine();
            if(validateInput(headCountry, secondCountry) == true){
                valid2 = true;
            }else if(secondCountry.equalsIgnoreCase("EXIT")){
                System.exit(0);
            }else{
                System.out.println("Invalid country name, Please enter a valid country name.");
            }
        }

        //begin finding shortest path between countries
        if(valid1 == true && valid2 == true){
            findPath(firstCountry, secondCountry);
        }

    }

    public boolean validateInput(Country headCountry, String targetCountry){
        Country pointerCountry = headCountry;
        String targetName = targetCountry;

        boolean valid = false;
        //Different name cases
        if(targetName.equalsIgnoreCase("US") || targetName.equalsIgnoreCase("USA") || targetName.equalsIgnoreCase("United States of America")){
            targetName = "United States";
        }else if(targetName.equalsIgnoreCase("Denmark (Greenland)") || targetName.equalsIgnoreCase("Greenland")){
            targetName = "Denmark";
        }else if(targetName.equalsIgnoreCase("UK")){
            targetName = "United Kingdom";
        }else if(targetName.equalsIgnoreCase("North Korea")){
            targetName = "Korea, North";
        }else if(targetName.equalsIgnoreCase("South Korea")){
            targetName = "Korea, South";
        }else if(targetName.equalsIgnoreCase("Surinam")){
            targetName = "Suriname";
        }

        //find country
        while(pointerCountry!= null){
            if(pointerCountry.Name.equalsIgnoreCase(targetName.trim())){
                valid = true;
                break;
            }
            pointerCountry = pointerCountry.next;
        }
        return valid;

    }
    


    public static void main(String[] args) {
        IRoadTrip a3 = new IRoadTrip(args);
    









        a3.acceptUserInput();
    }

}

