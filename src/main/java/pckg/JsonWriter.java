package pckg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class JsonWriter {

    public static void writeToJson(List<Searcher.SearchResult> results, String outputFile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Writer writer = new FileWriter(outputFile)) {
            gson.toJson(results, writer);
        } catch (Exception e) {
            System.out.println("ERROR JSONWRITER");
        }
    }
}
