package interfaces;

import java.util.ArrayList;

public interface IRentalChecker {
    boolean isNumeric(String stringNumber);
    boolean checkIdValidity(String id, ArrayList<String> memberships);

}