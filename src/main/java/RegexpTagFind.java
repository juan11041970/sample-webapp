import javax.xml.parsers.DocumentBuilderFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTagFind {

    public static void main (String ... args) {

        String inputRegexp = "<tag>(.+?)</tag>";
        String inputText = "<tag>String I want to extract</tag>";

        final Pattern pattern = Pattern.compile(inputRegexp, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(inputText);

        matcher.find();
        System.out.println(matcher.group(1)); // Prints String I want to extract
        String strReplaced = matcher.replaceAll("HELLO");

        System.out.println(strReplaced);

        int jobId = 21808480%10;

        System.out.println(jobId);
    }
}
