package folder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Scanner;

public class FinalIO {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("text.txt");
            Scanner sc = new Scanner(file){
                while (sc.hasNextLine()) {
                    String data = sc.nextLine();
                    System.out.println(data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Error !");
        }

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String key = word1.toLowerCase();
        if (key.length() > 0) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                int value = map.get(key);
                value++;
                map.put(key, value);
            }
        }

        System.out.println(key + "\t" + value);
    }
}
