package asciimirror;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> inputList = new ArrayList<>();
            BufferedReader bfri = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Input the file path: ");
            String path = bfri.readLine();
            BufferedReader bfro = new BufferedReader(new FileReader(path));

            String line;
            int maxLength = 0;

            while ((line = bfro.readLine()) != null) {
                inputList.add(line);
                maxLength = Math.max(maxLength, line.length());
            }
            bfro.close();

            for (String inputLine : inputList) {
                String paddedLine = String.format("%-" + maxLength + "s", inputLine);
                String mirroredLine = new StringBuilder(paddedLine).toString();
                System.out.println(paddedLine + " | " + mirroredLine);
            }
        } catch (IOException e) {
            System.out.println("Error: File not found or cannot be read.");
        }
    }
}