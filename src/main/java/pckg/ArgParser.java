package pckg;

public class ArgParser {

    private String dataFile;
    private String inputFile;
    private String outputFile;
    private int indexedColumnID = -1;

    //
    /*private String dataFile = "src/main/resources/airports.csv";
    private String inputFile = "src/main/resources/input.txt";
    private String outputFile = "src/main/resources/result.json";
    private int indexedColumnID = 1;*/

    public static ArgParser parse(String[] args) {
        ArgParser arguments = new ArgParser();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--data":
                    if (i + 1 < args.length) {
                        arguments.setDataFile(args[++i]);
                    }
                    break;
                case "--indexed-column-id":
                    if (i + 1 < args.length) {
                        arguments.setIndexedColumnID(Integer.parseInt(args[++i]) - 1);
                    }
                    break;
                case "--input-file":
                    if (i + 1 < args.length) {
                        arguments.setInputFile(args[++i]);
                    }
                    break;
                case "--output-file":
                    if (i + 1 < args.length) {
                        arguments.setOutputFile(args[++i]);
                    }
                    break;
            }
        }

        if (!arguments.isValid()) { // проверяем аргументы
            System.out.println("ERROR ARGS");
        }
        return arguments;
    }

    public String getDataFile() {
        return dataFile;
    }

    private void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }

    public String getInputFile() {
        return inputFile;
    }

    private void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    private void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public int getIndexedColumnID() {
        return indexedColumnID;
    }

    private void setIndexedColumnID(int indexedColumnID) {
        this.indexedColumnID = indexedColumnID;
    }

    public boolean isValid() {
        return dataFile != null && inputFile != null && outputFile != null && indexedColumnID > 0;
    }
}
