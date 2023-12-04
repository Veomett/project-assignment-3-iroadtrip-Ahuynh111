import java.util.List;
import java.io.*;
import java.util.Scanner;

public class IRoadTrip {


    //CONSTRUCTOR//
    public IRoadTrip (String [] args) { 
        // Replace with your code
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

        //READ IN FILES//
        try{
            File bordersFile = new File("borders.txt");
            Scanner borderScanner = new Scanner(bordersFile);

            System.out.println(borderScanner.nextLine());
            System.out.println(borderScanner.nextLine());
        }catch (FileNotFoundException FNFE){
            System.out.println("ERROR: 'borders.txt' File Not Found");
        }




        a3.acceptUserInput();
    }

}

