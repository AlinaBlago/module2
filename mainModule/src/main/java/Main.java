import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("2020/01/01", "234567", "02/02/2020", "2020/03/03", "04--04--2020", "05-05-2020");
        LevelOneTask.stringFormat(input).forEach(System.out::println);
    }
}
