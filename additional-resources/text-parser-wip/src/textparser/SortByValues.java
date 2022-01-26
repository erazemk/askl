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

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Erazem Kokot <contact@erazem.eu>
 *
 */

public class SortByValues {
    
    public static <K, V extends Comparable<V>> Map<K, V> sort(final Map<K, V> map) {
        
        Comparator<K> valueComparator = (K k1, K k2) -> {
            int compare = map.get(k1).compareTo(map.get(k2));
            if (compare == 0)
                return 1;
            else
                return compare;
        };
 
        Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
