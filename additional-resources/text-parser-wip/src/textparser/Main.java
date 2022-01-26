/*
 * The MIT License
 *
 * Copyright 2019 Erazem Kokot <contact@erazem.eu>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package textparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Erazem Kokot <contact@erazem.eu>
 * 
 * @todo create a .jar library
 * 
 */

public class Main {
    
    public static void main(String[] args) {
        
        File f = new File("/home/erazem/Documents/Vegova/Seminarska/hundred.csv");
        
        TreeMap<Character, Integer> map = new TreeMap<>();        
        Map<Character, Integer> sortedMap = new TreeMap<>();
        
        String line;
        String word;
        int repeats;
        boolean countRepeats = false;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            while ((line = reader.readLine()) != null) {
                word = line.split(",")[0];
                repeats = Integer.valueOf(line.split(",")[1]);
                sortedMap = CountLetters.count(word, repeats, map, countRepeats);
            }
        }
        
        catch (IOException e) {
            System.out.println("Couldn't find file!");
        }
        
        Set set = sortedMap.entrySet();
        Iterator i = set.iterator();
        
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}