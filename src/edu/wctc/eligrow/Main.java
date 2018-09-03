package edu.wctc.eligrow;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputFilename = "";
        String outputFileName = "";
        System.out.print("Enter 1 to encrypt NotEncrypted.txt.\nEnter 2 to decrypt Encrypted.txt.\nEnter 3 to exit: ");
        Scanner input = new Scanner(System.in);
        int ans = input.nextInt();
        if(ans == 1) {
            inputFilename = "NotEncrypted.txt";
            outputFileName = "Encrypted.txt";

            try {
                Actions.encrypt(inputFilename, outputFileName);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("Process complete.\nGoodbye");
            input.nextLine();
        }else if(ans == 2) {
            inputFilename = "Encrypted.txt";
            outputFileName = "Unencrypted.txt";
            try {
                Actions.decrypt(inputFilename, outputFileName);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Process complete.\nGoodbye");
            input.nextLine();
        }else if(ans == 3) {
            System.out.print("Goodbye");
            input.nextLine();
        }else {
                System.out.print("Please enter a valid input: ");
            }
        }
    }
