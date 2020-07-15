/*
 JUDUL TUGAS : MEMBUAT STATISTIK KATA DARI SEBUAH FILE TEKS YANG DIBACA
 AUTHOR : I GUSTI MADE GERALDI ( 191524011 ), MUHAMMAD SAKHI HARTANTO ( 1915124030 )
 TANGGAL SELESAI : 15 JULI 2020
 VERSION : 3.1 ( Penambahan Fitur dan Delimiters ) 

 */
package folder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Scanner;
import java.lang.String;


// Class dinamakan FinalIO dikarenakan disini hanyalah satu satunya class yang tidak perlu memerlukan class lain.
public class FinalIO {

    public static void main(String[] args) throws FileNotFoundException {

        // Menggunakan Tree Map sebagai Struktur Data karena memiliki Ascending dan juga mendapatkan Valuenya
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int total = 0;
        int i;
        // Mensplit operator yang tidak perlu seperti " ~ ! @ # $ % ^ & * ( ) - _ < > ? / \ : ; ” “ { } [ ] ' "
        String splitter = "\\t|,|;|\\.|\\?|!|-|:|@\\[|\\]|\\(|\\)|\\{|\\}|_|\\*|/\"|\\+|\\=|\\”|\\“|\\\"|\\#|\\$|\\%|\\^|\\&|\\<|\\>|\\~|\\/|\\\\|\\[|\\'";

        // Menscan dan membuka + membaca File
        try (Scanner txtfile = new Scanner(new File("C:\\Users\\User\\Documents\\NetBeansProjects\\JavaApplication2\\src\\folder\\text.txt"))) {
            while (txtfile.hasNext()) { // Mengecek Kondisi apakah terdapat elemen selanjutnya atau tidak
                String word = txtfile.next(); // Menjadikan text file dibagi per kata
                String[] words = word.toLowerCase().split(splitter); //Fungsi untuk mensplit (delimiter) operator di dalam text file
                for (i = 0; i < words.length; i++) { // Looping untuk panjang kata
                    if (words[i].equals("")) { // Mengecek apakah text file sudah di akhir
                    } else { // Jika tidak maka hitung
                        Integer count = map.get(words[i]);
                        if (map.containsKey(words[i])) { //mengembalikan nilai boolean true jika map memiliki kunci yang merujuk pada suatu nilai( words[i] ).
                            map.put(words[i], ++count); // menggunakan fungsi put untuk mengisi key dan value nya
                        } else {
                            map.put(words[i], 1);
                        }
                        total++; // Menghitung total seluruh kata 
                    }
                }
            }
            // Menggunakan Exception untuk mengecek apakah File tersebut ada atau tidak
        } catch (FileNotFoundException e) {
            System.out.println(e + " \n " + " FILE NOT FOUND !"); 
        }
        System.out.println("Kata" + "\t" + "Jumlah");
        map.entrySet().stream().forEach((entry) -> { // Mengambil semua key dan value yang ada di map dengan memakai loop forEach
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        });

        System.out.println("====================================");
        System.out.println("Total Kata di Dalam File : " + total);
    }
}
