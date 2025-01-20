package pckg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Indexer {
    public static TreeMap<String, List<Integer>> buildIndex(String datafile, int indexedColumnId) {
        TreeMap<String, List<Integer>> index = new TreeMap<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(datafile))) {
            String line;

            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (parts.length >= indexedColumnId) {
                    String key = parts[indexedColumnId].replace("\"", "");
                    int rowNum = Integer.parseInt(parts[0]);
                    index.computeIfAbsent(key, k -> new ArrayList<>()).add(rowNum);
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR INDEXER");
        }

        return index;
    }
}
