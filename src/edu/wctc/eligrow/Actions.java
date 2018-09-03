package edu.wctc.eligrow;

import java.io.*;

/**
 * Class to hold each action that can be run by this program
 * @author eplig
 * @version 1.0
 */
public class Actions {

    /**
     *Encrypts contents of file to another file
     * @param f String: Name of file method draws FROM
     * @param t String: Name of file method writes TO
     * @throws IOException
     */
    public static void encrypt(String f, String t) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(f));
        String str = "";
        String fullStr = "";
        try {
            while ((str = reader.readLine()) != null) {
                fullStr += str;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        reader.close();
        char[] text = new char[1024];
        try {
            text = fullStr.toCharArray();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        for (int counter = 0; counter < text.length; counter++) {
            char character = text[counter];
            int ascii = (int) character;
            int encryptedAscii = 0;
            char encryptedChar = 0;
            encryptedAscii = (158 - ascii);
            encryptedChar = (char) encryptedAscii;
            text[counter] = encryptedChar;

            PrintWriter outFile = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(t)));
            outFile.write(text);
            outFile.close();
        }
    }

    /**
     * Decrypts contents from one file and places decrypted content in another file
     * @param f String: Name of file method draws FROM
     * @param t String: Name of file method writes TO
     * @throws IOException
     */
    public static void decrypt(String f, String t) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader(f));
        char[] text = new char[1024];
        int counter=0;
        while((counter=reader.read(text)) != -1){
            String readData = String.valueOf(text, 0, counter);
        }
        reader.close();
        counter = 0;
        while (text[counter] > (int) 32) {
            char character = text[counter];
            int ascii = (int) character;
            int unencryptedAscii = 0;
            char unencryptedChar = 0;

            unencryptedAscii = Math.abs(ascii - 158);
            unencryptedChar = (char) unencryptedAscii;
            text[counter] = unencryptedChar;
            counter++;
        }
        System.out.println(text);
            PrintWriter outFile = new PrintWriter(
                    new BufferedWriter (
                            new FileWriter (t) ) );
            outFile.write(text);
            outFile.close();
        }

    }