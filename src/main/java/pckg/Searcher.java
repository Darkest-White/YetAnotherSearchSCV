package pckg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Searcher {

    public static List<SearchResult> search(TreeMap<String, List<Integer>> index, String inputFile) {
        List<SearchResult> results = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(inputFile))) {
            String search;
            while ((search = bf.readLine()) != null) {
                List<Integer> result = new ArrayList<>();

                index.subMap(search, search + Character.MAX_VALUE).values().forEach(result::addAll);

                Collections.sort(result);

                results.add(new SearchResult(search, result));
            }
        } catch (Exception e) {
            System.out.println("ERROR SEARCH");
        }
        return results;
    }

    static class SearchResult {
        String search;
        List<Integer> result;

        public SearchResult(String search, List<Integer> result) {
            this.search = search;
            this.result = result;
        }

    }
}
