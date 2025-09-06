package com.learning;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class JavaCodeForConversionBetweenJSONandCSV {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Convert JSON file to CSV file
    public static void jsonToCsv(String jsonFile, String csvFile) throws IOException {
        // Read JSON array
        List<Map<String, Object>> data = mapper.readValue(new File(jsonFile), List.class);

        if (data.isEmpty()) {
            throw new RuntimeException("JSON file is empty!");
        }

        // Get headers from first object
        Set<String> headers = data.get(0).keySet();

        try (Writer writer = new FileWriter(csvFile);
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0])))) {

            for (Map<String, Object> row : data) {
                List<String> values = new ArrayList<>();
                for (String header : headers) {
                    values.add(String.valueOf(row.get(header)));
                }
                csvPrinter.printRecord(values);
            }
        }
    }

    // Convert CSV file to JSON file
    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        try (Reader reader = new FileReader(csvFile);
             CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<Map<String, String>> records = new ArrayList<>();
            for (CSVRecord record : parser) {
                Map<String, String> map = new HashMap<>();
                for (String header : parser.getHeaderMap().keySet()) {
                    map.put(header, record.get(header));
                }
                records.add(map);
            }

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), records);
        }
    }

    public static void main(String[] args) throws IOException {
        String jsonFile = "data.json";
        String csvFile = "data.csv";

        // JSON → CSV
        jsonToCsv(jsonFile, "output.csv");
        System.out.println("✅ Converted JSON to CSV: output.csv");

        // CSV → JSON
        csvToJson(csvFile, "output.json");
        System.out.println("✅ Converted CSV to JSON: output.json");
    }

}
