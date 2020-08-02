import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Level 1: ");
        List<String> input = Arrays.asList("2020/01/01", "234567", "02/02/2020", "2020/03/03", "04--04--2020", "05-05-2020");
        System.out.println("\nEntered strings: " + input + "\nFiltered and formatted strings: ");
        LevelOneTask.stringFormat(input).forEach(System.out::println);
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("Level 2: ");
        String [] s = {"Thread", "Stream", "Stream", "Thread", "Cat"};
        System.out.println("\nEntered strings: ");
        for (String s1 : s) {
            System.out.println(s1);
        }
        System.out.println("\nUnique name: " + LevelTwoTask.uniqueString(s));
        System.out.println("- - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("Level 3: ");
        File file = new File(
                Main.class.getClassLoader().getResource("input.txt").getFile());
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(file)))) {
            String str;
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parser.parse(list);

    }

}
