package com.learning;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
public class JavaCodeForeReadingAndWritingDataBetweenJSONandCSV {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Base paths
    private static final String INPUT_PATH = "src/main/resources/InputFileData/";
    private static final String OUTPUT_PATH = "src/main/resources/OutPutFileData/";

    // Convert JSON file to CSV
    public static void jsonToCsv(String inputFileName, String outputFileName) throws IOException {
        File inputFile = new File(INPUT_PATH + inputFileName);
        File outputFile = new File(OUTPUT_PATH + outputFileName);

        // Read JSON array into list of maps
        List<Map<String, Object>> data = mapper.readValue(inputFile, List.class);

        if (data.isEmpty()) {
            throw new RuntimeException("JSON file is empty!");
        }

        // Extract headers from first row
        Set<String> headers = data.get(0).keySet();

        try (Writer writer = new FileWriter(outputFile);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0])))) {

            for (Map<String, Object> row : data) {
                List<String> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(String.valueOf(row.get(header)));
                }
                csvPrinter.printRecord(values);
            }
        }
        System.out.println("✅ JSON → CSV created at: " + outputFile.getAbsolutePath());
    }

    // Convert CSV file to JSON
    public static void csvToJson(String inputFileName, String outputFileName) throws IOException {
        File inputFile = new File(INPUT_PATH + inputFileName);
        File outputFile = new File(OUTPUT_PATH + outputFileName);

        try (Reader reader = new FileReader(inputFile);
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<Map<String, String>> records = new ArrayList<>();
            for (CSVRecord record : parser) {
                Map<String, String> map = new HashMap<>();
                for (String header : parser.getHeaderMap().keySet()) {
                    map.put(header, record.get(header));
                }
                records.add(map);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(outputFile, records);
        }
        System.out.println("✅ CSV → JSON created at: " + outputFile.getAbsolutePath());
    }

    public static void main(String[] args) throws IOException {
        // Ensure output directory exists
        Files.createDirectories(Paths.get(OUTPUT_PATH));

        // Example usage:
        jsonToCsv("data.json", "output.csv");
        csvToJson("data.csv", "output.json");
    }
}
