package TUBES;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Scanner;
import java.lang.String;

public class FinalIO {

    public static void main(String[] args) throws FileNotFoundException {

        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int total=0;
        try (Scanner txtfile = new Scanner(new File("D:\\Indonesia Negaraku, Polban Kampusku\\Java\\TUBES\\src\\text.txt"))) { 
            while (txtfile.hasNext()) {  
                String word = txtfile.next();
                String[] splitkata = word.toLowerCase().split("\\t|,|;|\\.|\\?|!|-|:|@|\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/\""); 
                int i;
                for (i = 0; i < splitkata.length; i++) {
                    if(splitkata[i].equals("")){
                            
                    }else{                        
                        Integer count = map.get(splitkata[i]); 
                        if (map.containsKey(splitkata[i])) {
                                map.put(splitkata[i], ++count);
                        } else { 
                            map.put(splitkata[i], 1);
                        }
                        total++;
                    }
                }
            }
        } catch (FileNotFoundException e) {  
            System.out.println(e + " \n " + " FILE NOT FOUND !");
        }

        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
        System.out.println("Total : "+total);
    }
}
