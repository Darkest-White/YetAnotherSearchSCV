package pckg;

import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        ArgParser arguments = ArgParser.parse(args); // парсим аргументы

        TreeMap<String, List<Integer>> index = Indexer.buildIndex(arguments.getDataFile(), arguments.getIndexedColumnID());

        List<Searcher.SearchResult> results = Searcher.search(index, arguments.getInputFile());

        JsonWriter.writeToJson(results, arguments.getOutputFile());
    }
}
