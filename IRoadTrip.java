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
    Country firstNeighbor;
    Country lastNeighbor;
    Country nextNeghbor; 

    Country(String n, String c, int num){
        Name = n;
        Code = c;
        Number = num;
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

            System.out.println(borderScanner.nextLine());
        }catch (FileNotFoundException FNFE){
            System.out.println("ERROR: Files Not Found");
            System.exit(0);
        }



        System.out.println(borderScanner.nextLine());
    }

    //CREATE GRAPH OF COUNTRIES//
    public void createMap (File borders, File distance, File names){
        System.out.println(borderScanner.nextLine());

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

