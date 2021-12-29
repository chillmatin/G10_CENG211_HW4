package Managements;

import Exceptions.InvalidCustomerIdException;
import Interfaces.IRentalChecker;

class RentalChecker implements IRentalChecker {



    public boolean isNumeric(String stringNumber) { //package access
        if (stringNumber == null) {
            return false;
        }
        try {
            long d = Long.parseLong(stringNumber);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

      public boolean checkIdValidity(String id) { //package access
        try {
            if (id.length() == 8) {
                if (!isNumeric(id)) {
                    return true;
                }
                throw new InvalidCustomerIdException();
            } else if (id.length() == 11) {
                if (isNumeric(id)) {
                    return true;
                }
                throw new InvalidCustomerIdException();
            } else if (id.length() == 12) {
                if (!isNumeric(id)) {
                    return true;
                }
                throw new InvalidCustomerIdException();
            } else {
                throw new InvalidCustomerIdException();
            }
        } catch (InvalidCustomerIdException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}
