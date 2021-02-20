package Ecryption;

import com.sun.org.apache.xpath.internal.FoundIndex;

import java.util.ArrayList;
import java.util.List;

public class EncryptionClass {


    public String decryptionInfo(String stringOne, String stringTwo, String stringThree, String stringFour) {
        int charOne = 0;
        StringBuilder resultOne = new StringBuilder();
        //--------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 4; i++) {
            int a = stringOne.charAt(i);
            int b = stringTwo.charAt(i);
            charOne = (a + b) / 2;
            if (charOne == 58 || charOne == 59 || charOne == 60 || charOne == 61 || charOne == 62 || charOne == 63 || charOne == 64) {
                charOne = 50;
                resultOne.append(((char) charOne));
            } else {
                resultOne.append((char) charOne);
            }
        }
        //--------------------------------------------------------------------------------------------------------------
        int charTwo = 0;
        StringBuilder resultTwo = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int a = stringFour.charAt(i);
            int b = stringThree.charAt(i);
            charTwo = (a + b) / 2;
            if (charTwo == 58 || charTwo == 59 || charTwo == 60 || charTwo == 61 || charTwo == 62 || charTwo == 63 || charTwo == 64) {
                charTwo = 48;
                resultTwo.append((char) charTwo);
            } else {
                resultTwo.append((char) charTwo);
            }
        }
        StringBuilder finalResult = new StringBuilder();
        finalResult.append(resultOne);
        finalResult.append(resultTwo);
        String finalCode = finalResult.toString();
        return finalCode;
    }

    public String decryptionInfoPro(String stringOne, String stringTwo, String stringThree, String stringFour) {
        int charOne = 0;
        StringBuilder resultOne = new StringBuilder();
        //--------------------------------------------------------------------------------------------------------------
        for (int i = 0; i < 4; i++) {
            int a = stringThree.charAt(i);
            int b = stringTwo.charAt(i);
            charOne = (a + b) / 2;
            if (charOne == 58 || charOne == 59 || charOne == 60 || charOne == 61 || charOne == 62 || charOne == 63 || charOne == 64) {
                charOne = 86;
                resultOne.append(((char) charOne));
            } else {
                resultOne.append((char) charOne);
            }
        }
        //--------------------------------------------------------------------------------------------------------------
        int charTwo = 0;
        StringBuilder resultTwo = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int a = stringFour.charAt(i);
            int b = stringOne.charAt(i);
            charTwo = (a + b) / 2;
            if (charTwo == 58 || charTwo == 59 || charTwo == 60 || charTwo == 61 || charTwo == 62 || charTwo == 63 || charTwo == 64) {
                charTwo = 67;
                resultTwo.append((char) charTwo);
            } else {
                resultTwo.append((char) charTwo);
            }
        }
        StringBuilder finalResult = new StringBuilder();
        finalResult.append(resultOne);
        finalResult.append(resultTwo);
        String finalCode = finalResult.toString();
        return finalCode;
    }
}



