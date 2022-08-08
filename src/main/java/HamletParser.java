import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    public void parseHamlet() throws FileNotFoundException, UnsupportedEncodingException {
        changeHamletToLeon(findHamlet());
        changeHoratioToTariq(findHoratio());
        writeFile(getHamletData());
    }

    private void writeFile(String data) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("./src/main/resources/leon.txt", "UTF-8");
        String[] allLines = data.split("\n");
        for (String str : allLines) {
            writer.println(str);
        }
        writer.close();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("hamlet.txt")).getFile());
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public Matcher findHoratio() {
        Pattern p = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        return p.matcher(getHamletData());
    }

    public Matcher findHamlet() {
        Pattern p = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        return p.matcher(getHamletData());
    }

    public void changeHoratioToTariq(Matcher match) {
        String tariq = "Tariq";
        StringBuffer sb = new StringBuffer();
        while (match.find()) {
            if (match.group().equals(match.group().toUpperCase())) {
                match.appendReplacement(sb, tariq.toUpperCase());
            } else {
                match.appendReplacement(sb, tariq);
            }
        }
        match.appendTail(sb);
        hamletData = sb.toString();
    }

    public void changeHamletToLeon(Matcher match) {
        String leon = "Leon";
        StringBuffer sb = new StringBuffer();
        while (match.find()) {
            if (match.group().equals(match.group().toUpperCase())) {
                match.appendReplacement(sb, leon.toUpperCase());
            } else {
                match.appendReplacement(sb, leon);
            }
        }
        match.appendTail(sb);
        hamletData = sb.toString();
    }
}
