package asciimirror;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creating BufferedReader for Input


        try {
            BufferedReader bfri = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.print("Input the file path:");


            String path = bfri.readLine();


            BufferedReader bfro = new BufferedReader(
                    new FileReader(path));


            String st;

            while ((st = bfro.readLine()) != null)

                System.out.println(st);

        } catch (IOException e) {
            System.out.println("File not found!");


        }
    }
}