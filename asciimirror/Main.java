package asciimirror;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        String input = scanner.nextLine();
        String[] cowLines = {
                input+"\n"+
                        "            ^__^",
                "    _______/(oo)",
                "/\\/(       /(__)",
                "   | w----||    ",
                "   ||     ||    "
        };

        for (String line : cowLines) {
            System.out.println(line);
        }
    }
}