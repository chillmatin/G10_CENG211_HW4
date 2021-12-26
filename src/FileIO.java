import Exceptions.EmptyRentalDataException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class FileIO implements Serializable {

    public static void readFile(String file) {
        try {
            BufferedReader inputStream = openFile(file);
            String inputLine;
            while ((inputLine = inputStream.readLine()) != null) {
                try {
                    if (inputLine.equals("")) {
                        throw new EmptyRentalDataException();
                    } else {
                        System.out.println(inputLine); // Read Here
                    }
                } catch (EmptyRentalDataException e) {
                    System.out.println(e.getMessage());
                }
            }
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static BufferedReader openFile(String file) throws IOException {

        try {
            return new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Ending the program..");
            System.exit(0);
            return null;
        }
    }


}
