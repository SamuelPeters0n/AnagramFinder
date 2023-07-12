import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.nio.file.Files;

public class AnagramFinderJava {

    public static void main(String[] args) {
        String filePath = "src/ordbok-utf8.txt";

        try {
            Map<String, List<String>> groupedLines = Files.lines(Paths.get(filePath))
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.groupingBy(AnagramFinderJava::sortCharsInString));

            groupedLines.values().stream()
                    .filter(group -> group.size() > 1)
                    .forEach(group -> System.out.println(String.join(" ", group)));
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath + " Error message: " + e.getMessage());
        }
    }

    private static String sortCharsInString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}