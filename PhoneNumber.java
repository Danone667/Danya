import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static String formatPhoneNumber(String text) {
        Pattern pattern = Pattern.compile("(\\+\\d{1,3})?\\s*(\\d{3})\\s*(\\d{3})\\s*(\\d{4})");
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, "+1 ($2) $3-$4");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Call +87762768222";
        System.out.println(formatPhoneNumber(text));
    }
}
