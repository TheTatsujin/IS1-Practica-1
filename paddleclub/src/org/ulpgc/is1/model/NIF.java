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
        String nif = this.number;
        // Verifica que el NIF tenga la longitud adecuada
        if (nif.length() != 9) {
            return false;
        }

        // Extrae la primera letra (tipo de NIF) y los números
        char firstLetter = nif.charAt(0);
        String numbersPart = nif.substring(0, 8);

        // Verifica que la primera letra sea válida
        if (!isValidNIFType(firstLetter)) {
            return false;
        }

        // Verifica que la última letra sea la letra de control correcta
        char controlLetter = calculateNIFControlLetter(numbersPart);
        return controlLetter == nif.charAt(8);
    }

    private static boolean isValidNIFType(char firstLetter) {
        // Verifica que la primera letra sea una letra válida (X, Y, Z o letra del alfabeto)
        return Character.isLetter(firstLetter) && (firstLetter == 'X' || firstLetter == 'Y' || firstLetter == 'Z' || Character.isAlphabetic(firstLetter));
    }

    private static char calculateNIFControlLetter(String numbersPart) {
        // Convierte los números a una secuencia de dígitos
        int numericPart = Integer.parseInt(numbersPart);

        // Calcula el índice de la letra de control
        int controlIndex = numericPart % 23;

        // Lista de letras de control válidas
        String validControlLetters = "TRWAGMYFPDXBNJZSQVHLCKE";

        // Obtiene la letra de control correspondiente al índice
        return validControlLetters.charAt(controlIndex);
    }

    public void setNumber(String newNumber) {
        String old = this.number;
        this.number = newNumber;

        if (!isValid()){
            this.number = old;
        }
    }

    public String getNumber() {
        return this.number;
    }
}
