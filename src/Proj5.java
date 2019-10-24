 /* This program
  *
  *
  * Aryan Tayal
  * Project 5
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
             getDD_Mon_YYYY(datePieces);
         } else if (choice == 3) {

         } else if (choice == 4) {
             getJulianFormat(datePieces);
         } else {
             System.out.println("Invalid Entry, Please enter a value from 1-4");
             choice = Integer.parseInt(s.nextLine());
         }
         //} while (loop);
     }// end main

     public static String[] getDD_MM_YYYY(int[][] datePieces) { //OPTION 1
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
     } // end of getDD_MM_YYYY - option 1

     public static String[] getDD_Mon_YYYY(int[][] datePieces) { // OPTION 2
         String day = null, month = null, year = null;

         String[] dates = new String[datePieces.length];

         for (int i = 0; i < datePieces.length; i++) {

             day = String.format("%02d", datePieces[i][DateValue.DAY.label]);
             //month = String.format("%02d", datePieces[i][DateValue.MONTH.label]);
             year = String.format("%04d", datePieces[i][DateValue.YEAR.label]);
             switch (datePieces[i][DateValue.MONTH.label]) {
                 case 1:
                     month = "Jan";
                     break;
                 case 2:
                     month = "Feb";
                     break;
                 case 3:
                     month = "Mar";
                     break;
                 case 4:
                     month = "Apr";
                     break;
                 case 5:
                     month = "May";
                     break;
                 case 6:
                     month = "Jun";
                     break;
                 case 7:
                     month = "Jul";
                     break;
                 case 8:
                     month = "Aug";
                     break;
                 case 9:
                     month = "Sep";
                     break;
                 case 10:
                     month = "Oct";
                     break;
                 case 11:
                     month = "Nov";
                     break;
                 case 12:
                     month = "Dec";
                     break;
             }
             dates[i] = (day + " " + month + ", " + year);
             // System.out.println(dates[i]);

         }
         return dates;
     } // end of getDD_Mon_YYYY - option 2

     public static String[] getJulianFormat(int[][] datePieces) {

         int day = 0;
         int month = 0;
         int year = 0;
         int julianDate;
         String[] dates = new String[datePieces.length];

         for (int i = 0; i < datePieces.length; i++) {
             day = datePieces[i][DateValue.DAY.label];
             month = datePieces[i][DateValue.MONTH.label];
             year = datePieces[i][DateValue.YEAR.label];
             dates[i] = (day + "/" + month + "/" + year);

             julianDate = (getJulianDay(month, day, year));
             System.out.format("%04d", year);
             System.out.print(julianDate + "\n");
         }
         return dates;
     }// end of getJulianFormat - option 3
     public static int getJulianDay(int m, int d, int y){
         int daysByMonths = 0;

         int[] daysMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
         if (y % 4 == 0) {
             daysMonth[2] = 29;
         }
         for (int i = 1; i < m; i++){
             daysByMonths += daysMonth[i];
         }
         int julianDay;
         julianDay = daysByMonths + d;


         return julianDay;

     }
     public enum DateValue {
         DAY(0),
         MONTH(1),
         YEAR(2);
         public final int label;

         private DateValue(int label) {
             this.label = label;
         }
     } // end of enum
 }
