package asciimirror;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String input = scanner.nextLine();

        File file = new File(input);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found!");
        } else {
            try {
                List<String> lines = Files.readAllLines(file.toPath());
                List<String> modifiedLines = new ArrayList<>();
                int maxLength = 0;

                // Find the longest line
                for (String line : lines) {
                    if (line.length() > maxLength) {
                        maxLength = line.length();
                    }
                }

                // Format lines with whitespaces
                for (String line : lines) {
                    StringBuilder sb = new StringBuilder(line);
                    while (sb.length() < maxLength) {
                        sb.append(" ");
                    }
                    modifiedLines.add(sb.toString());
                }

                // Print the modified lines in the specified pattern
                for (String line : modifiedLines) {
                    char[] reversedArray = new StringBuilder(line).reverse().toString().toCharArray();
                    StringBuilder mirror = new StringBuilder();
                    for(char ch : reversedArray){
                        switch (ch){
                            case '\\' -> mirror.append("/");
                            case '/' -> mirror.append("\\");
                            case ')' -> mirror.append("(");
                            case '(' -> mirror.append(")");
                            case '[' -> mirror.append("]");
                            case ']' -> mirror.append('[');
                            case '<' -> mirror.append(">");
                            case '>' -> mirror.append("<");
                            default -> mirror.append(ch);
                        }
                    }
                    System.out.println(line + " | " + mirror);
                }
            } catch (IOException e) {
                System.out.println("File not found!");
            }
        }
    }
}