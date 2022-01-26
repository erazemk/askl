package TextParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class TextParser {

    static void readFile(File f) {
        String line = "";
        int repeats = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            //while ((line = reader.readLine()) != null) {
            for (int i = 0; i < 100; i++) { // For debugging
                line = (reader.readLine()).split(",")[0];
                repeats = Integer.valueOf((reader.readLine()).split(",")[1]);
                countLetters(line, repeats);
            }
        }
        catch (IOException e) {
            System.out.println("Couldn't find file!");
        }
    }

    static void countLetters(String word, int numberOfRepeats) {
        /*
        System.out.println("Word: " + word);
        System.out.println("Repeats: " + numberOfRepeats);
        System.out.println();
        */

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('b', 10);
        map.put('c', 4);

        map.forEach((letter, repeats) -> {
            System.out.println(letter + " : " + repeats);
        });
    }

    public static void main(String[] args) {
        File f = new File("besede.csv");
        //readFile(f);
        countLetters("test", 1);
    }
}

/* Todo:

* razdeli podano besedo na črke
* za vsako črko poglej če obstaja v mapu, če ne jo naredi in dodaj vrednost
* izpiši cel seznam črk in ponovitev
* za vsako črko pomnoži s številom ponovitev (numberOfRepeates)

*/