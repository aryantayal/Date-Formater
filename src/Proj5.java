 /* This program scrambles a word from the list and then makes a unscramble game for a person to play
  *
  *
  * Aryan Tayal
  * Project 4
  * Thurs 2:30
  */


 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileOutputStream;
 import java.io.IOException;
 import java.util.Arrays;
 import java.util.Scanner;

 public class Proj5 {
     public static void main(String[] args) throws IOException {
         FileInputStream in = null;
         FileOutputStream out = null;

         Scanner s = new Scanner(System.in);
         System.out.print("Enter name of input file: ");
         String inputFile = s.nextLine();
         in = new FileInputStream(inputFile);

         System.out.print("Enter name of output file: ");
         String outputFile = s.nextLine();
         out = new FileOutputStream(outputFile);

         Scanner inFile = new Scanner(new File(inputFile));

         String [] tokens = inputFile.split("/");

         while (inFile.hasNext()) {
             for(int i = 0; i< tokens.length; i++){
                System.out.print(tokens[i]);
             }

         }

         boolean loop;

         //do {
             System.out.print("Choose a date format type:");
             System.out.print("\n\t(1) DD/MM/YYYY (ex. 26/08/2019, with leading zeroes on months and days)");
             System.out.print("\n\t(2) DD Mon, YYYY (ex. 26 Aug, 2019, with leading zeroes on days)");
             System.out.print("\n\t(3) DOW, Month DDD, YYYY (ex. Monday, August 26, 2019, no leading zeroes)");
             System.out.print("\n\t(4) Julian format, YYYYddd (where dd is day from 001-365)\n" +
                     "Enter an option, 1-4:");
             int choice = Integer.parseInt(s.nextLine());
             if (choice == 1) {

             }
             else if (choice == 2) {

             }
             else if (choice == 3) {

             }
             else if (choice == 4) {

             } else {
                System.out.println("Invalid Entry, Please enter a value from 1-4");
                choice = Integer.parseInt(s.nextLine());
             }
         //} while (loop);

         //public static int
     }
 }
