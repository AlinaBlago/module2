import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LevelTwoTask {
    public static String uniqueString(String[] s) {
        StringBuilder result = new StringBuilder();
        Stream.of(s)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> result.append(entry.getKey()));
        return result.toString();
    }
}
