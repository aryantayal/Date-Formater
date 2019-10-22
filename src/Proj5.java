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
 import java.util.Random;
 import java.util.Scanner;

 public class Proj5 {
    public static void main(String[] args ) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter name of input file: ");
        String inputFile = s.nextLine();
        in = new FileInputStream(inputFile);

        System.out.print("Enter name of output file: ");
        String outputFile = s.nextLine();
        out = new FileOutputStream(outputFile);



        //Scanner inFile = new Scanner();
    }
}
