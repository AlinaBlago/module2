import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LevelOneTask {

    public static List<String> stringFormat (List<String> input) {

        List<DateTimeFormatter> patterns = Arrays.asList( DateTimeFormatter.ofPattern("dd/MM/yyyy") ,
                DateTimeFormatter.ofPattern("yyyy/MM/dd") ,
                DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        ArrayList<String> results = new ArrayList<String>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (DateTimeFormatter datePattern : patterns){
            for (String currentDate : input) {
                LocalDate currentParsedDate = null;

                try {
                    currentParsedDate = LocalDate.parse(currentDate , datePattern);
                } catch (Exception e) {
                    continue;
                }

                results.add(currentParsedDate.format(formatter));

            }
        }

        return results;
    }
}
