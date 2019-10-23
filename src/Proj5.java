 /* This program
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
 import java.util.Scanner;

 public class Proj5 {
     public static void main(String[] args) throws IOException {
         FileInputStream in = null;
         FileOutputStream out = null;
         boolean loop;

         Scanner s = new Scanner(System.in);
         System.out.print("Enter name of input file: ");
         String inputFile = s.nextLine();
         in = new FileInputStream(inputFile);

         /*
         System.out.print("Enter name of output file: ");
         String outputFile = s.nextLine();
         out = new FileOutputStream(outputFile);
           */

         Scanner inFile = new Scanner(new File(inputFile));
         int firstLine = Integer.parseInt(inFile.nextLine());
         int[][] datePieces = new int[firstLine][3];

         for (int i = 0; i < firstLine; i++) { // Splits the import dates into an array
             String[] tokens = inFile.nextLine().split("/");
             datePieces[i][0] = Integer.parseInt(tokens[1]); // day
             datePieces[i][1] = Integer.parseInt(tokens[0]); // month
             datePieces[i][2] = Integer.parseInt(tokens[2]); // year
         }
        inFile.close();

         //do {
         System.out.print("Choose a date format type:");
         System.out.print("\n\t(1) DD/MM/YYYY (ex. 26/08/2019, with leading zeroes on months and days)");
         System.out.print("\n\t(2) DD Mon, YYYY (ex. 26 Aug, 2019, with leading zeroes on days)");
         System.out.print("\n\t(3) DOW, Month DDD, YYYY (ex. Monday, August 26, 2019, no leading zeroes)");
         System.out.print("\n\t(4) Julian format, YYYYddd (where dd is day from 001-365)\n" +
                 "Enter an option, 1-4:");
         int choice = Integer.parseInt(s.nextLine());
         if (choice == 1) {
             getDD_MM_YYYY(datePieces);
         } else if (choice == 2) {

         } else if (choice == 3) {

         } else if (choice == 4) {

         } else {
             System.out.println("Invalid Entry, Please enter a value from 1-4");
             choice = Integer.parseInt(s.nextLine());
         }
         //} while (loop);
     }// end main

     public enum DateValue {
         DAY(0),
         MONTH(1),
         YEAR(2);
         public final int label;

         private DateValue(int label) {
             this.label = label;
         }
     } // end of enum

     public static String[] getDD_MM_YYYY(int[][] datePieces) {
         String day = null, month = null, year = null;

         String[] dates = new String[datePieces.length];

         for (int i = 0; i < datePieces.length; i++) {

             day = String.format("%02d", datePieces[i][DateValue.DAY.label]);
             month = String.format("%02d", datePieces[i][DateValue.MONTH.label]);
             year = String.format("%04d", datePieces[i][DateValue.YEAR.label]);

             dates[i] = (day + "/" + month + "/" + year);
             //System.out.println(dates[i]);

         }
         return dates;
     } // end of getDD_MM_YYYY
     public static String[] getDD_Mon_YYYY(int[][] datePieces){
         String day = null, month = null, year = null;

         String[] dates = new String[datePieces.length];

         for (int i = 0; i < datePieces.length; i++) {

             day = String.format("%02d", datePieces[i][DateValue.DAY.label]);
             month = String.format("%02d", datePieces[i][DateValue.MONTH.label]);
             year = String.format("%04d", datePieces[i][DateValue.YEAR.label]);

             dates[i] = (day + month + ", " + year);
             //System.out.println(dates[i]);

         }
         return dates;
     } // end of getDD_Mon_YYYY
 }
