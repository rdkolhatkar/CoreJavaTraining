package com.learning;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
public class JavaCodeForDataConversionBetweenXMLandJSON {
    /**
     * Convert XML string to JSON string.
     */
    public static String convertXmlToJson(String xmlData) {
        try {
            // Create XML mapper
            XmlMapper xmlMapper = new XmlMapper();

            // Parse XML into a JsonNode tree
            JsonNode node = xmlMapper.readTree(xmlData.getBytes());

            // Convert JsonNode into pretty JSON string
            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);

        } catch (Exception e) {
            return "{\"error\": \"Failed to convert XML to JSON - " + e.getMessage() + "\"}";
        }
    }

    /**
     * Convert JSON string to XML string.
     */
    public static String convertJsonToXml(String jsonData) {
        try {
            // Create JSON mapper
            ObjectMapper jsonMapper = new ObjectMapper();

            // Parse JSON into JsonNode
            JsonNode node = jsonMapper.readTree(jsonData);

            // Convert JsonNode into XML string
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);

        } catch (Exception e) {
            return "<error>Failed to convert JSON to XML - " + e.getMessage() + "</error>";
        }
    }

    public static void main(String[] args) {
        // Example 1: Simple XML -> JSON
        String simpleXml = "<person><id>1</id><name>Alice</name></person>";
        String simpleJson = convertXmlToJson(simpleXml);
        System.out.println("✅ Simple XML → JSON:\n" + simpleJson);

        // Example 2: Nested XML -> JSON
        String nestedXml = "<company>" +
                "<name>TechCorp</name>" +
                "<employees>" +
                "   <employee><id>101</id><name>John</name><skills><skill>Java</skill><skill>Spring</skill></skills></employee>" +
                "   <employee><id>102</id><name>Mary</name><skills><skill>Python</skill><skill>ML</skill></skills></employee>" +
                "</employees>" +
                "</company>";
        String nestedJson = convertXmlToJson(nestedXml);
        System.out.println("\n✅ Nested XML → JSON:\n" + nestedJson);

        // Example 3: JSON -> XML (from the simple JSON)
        String backToXml = convertJsonToXml(simpleJson);
        System.out.println("\n🔄 Simple JSON → XML:\n" + backToXml);

        // Example 4: JSON -> XML (from the nested JSON)
        String nestedBackToXml = convertJsonToXml(nestedJson);
        System.out.println("\n🔄 Nested JSON → XML:\n" + nestedBackToXml);
    }
}
