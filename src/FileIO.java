
import Exceptions.EmptyRentalDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class FileIO implements Serializable {

    private static final ArrayList<String> dataArray = new ArrayList<>();
    private static BufferedReader inputStream;

    public static void readFile(String file) {
        try {
            inputStream = openFile(file); // It can throw a FileNotFoundException. Has been caught in openFile method.
            readLines(); // It can throw a IOException, will catch here.
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedReader openFile(String file) {

        try {
            return new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Ending the program..");
            System.exit(0);
            return null;
        }
    }

    private static void readLines() throws IOException {
        String inputLine;
        while ((inputLine = inputStream.readLine()) != null) {
            try {
                if (inputLine.equals("")) {
                    throw new EmptyRentalDataException(); // If its rental data is empty in file.
                } else {
                    // System.out.println(inputLine); // Read Here
                    dataArray.add(inputLine);
                }
            } catch (EmptyRentalDataException e) {
                // If it's empty don't print anything.
            }
        }
    }

    public static ArrayList<String> getDataArray(){
        ArrayList<String> temp = new ArrayList<>();
        Collections.copy(temp,dataArray);
        return temp;
    }



}
