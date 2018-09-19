import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebScrapper {
    public static void main(String[] unused) {
        String toSearch = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(toSearch);
//        System.out.println(countUniqueWord(toSearch));
//        System.out.println(countWord(toSearch));
        System.out.println(countOneWord("http://erdani.com/tdpl/hamlet.txt", "the"));
    }

//    public static int count(String s, String regex) {
//        Pattern word = Pattern.compile(regex);
//        Matcher matcher = word.matcher(s);
//        int count = 0;
//        while (matcher.find()) {
//            count++;
//        }
//        return count;
//    }
    //unique word counting
    public static int countUniqueWord(String webPage) {
        ArrayList<String> words = new ArrayList<>();

        //match words and add it to the list
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(webPage);
        while (m.find()) {
            String curWord = m.group();
            if (!words.contains(curWord)) {
                words.add(curWord);
            }
        }

        return words.size();

    }

    public static int countWord(String webPage) {
        Pattern word = Pattern.compile("\\w+");
        Matcher matcher = word.matcher(webPage);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countOneWord(String webPage, String word) {
        Pattern p = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(webPage);
        int count = 0;
        while (m.find()) {
            System.out.println("hi");
            count++;
        }
        return count;
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            //if error just return empty string
            return "";
        }
        //next
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}