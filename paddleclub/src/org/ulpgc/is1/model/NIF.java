package org.ulpgc.is1.model;

public class NIF {
    private String number;


    public NIF(String number) {
        this.setNumber(number);
    }

    @Override
    public String toString(){
        return number;
    }
    public boolean isValid() {
        String dni = this.number;
        // Check if the DNI has the correct length (9 characters)
        if (dni.length() != 9) {
            return false;
        }

        // Extract the first 8 digits
        String digitsPart = dni.substring(0, 8);

        // Extract the letter
        char letter = dni.charAt(8);

        try {
            // Parse the first 8 digits as an integer
            int dniDigits = Integer.parseInt(digitsPart);

            // Calculate the expected letter based on the 8 digits
            char expectedLetter = calculateDNILetter(dniDigits);

            // Check if the calculated letter matches the provided letter
            return expectedLetter == letter;
        } catch (NumberFormatException e) {
            // If parsing the first 8 digits as an integer fails, the DNI is invalid
            return false;
        }
    }

    private static char calculateDNILetter(int dniDigits) {
        // Array of letters used for DNI validation
        char[] dniLetters = "TRWAGMYFPDXBNJZSQVHLCKE".toCharArray();

        // Calculate the index for the letter using the modulo operation
        int index = dniDigits % 23;

        // Return the corresponding letter from the array
        return dniLetters[index];
    }

    public void setNumber(String newNumber) {
        this.number = newNumber;

        if (!isValid()){
            this.number = "XXXX";
        }
    }

    public String getNumber() {
        return this.number;
    }
}
