package com.learning;

import java.util.*;

public class JsonToHashMap {

    private final String json;
    private int index = 0;

    public JsonToHashMap(String json) {
        this.json = json.trim();
    }

    public static void main(String[] args) {

        String json = "{"
                + "\"status\":\"OK\","
                + "\"place_id\":\"723c9f067d980c3330d7824e07b67274\","
                + "\"location\":{\"lat\":18.5204,\"lng\":73.8567},"
                + "\"types\":[\"park\",\"tourist_place\"],"
                + "\"active\":true,"
                + "\"ratings\":["
                + "  {\"user\":\"Amit\",\"score\":4.5},"
                + "  {\"user\":\"Ravi\",\"score\":4.0}"
                + "]"
                + "}";

        JsonToHashMap parser = new JsonToHashMap(json);
        Map<String, Object> result = parser.parseObject();

        System.out.println(result);
    }

    // ---------- Core Parsing Logic ----------

    private Map<String, Object> parseObject() {
        consume('{');
        Map<String, Object> map = new HashMap<>();

        while (json.charAt(index) != '}') {
            skipWhitespace();
            String key = parseString();
            skipWhitespace();
            consume(':');
            skipWhitespace();
            Object value = parseValue();
            map.put(key, value);
            skipWhitespace();

            if (json.charAt(index) == ',') {
                index++;
            }
        }
        consume('}');
        return map;
    }

    private Object parseValue() {
        skipWhitespace();
        char ch = json.charAt(index);

        if (ch == '"') return parseString();
        if (ch == '{') return parseObject();
        if (ch == '[') return parseArray();
        if (ch == 't' || ch == 'f') return parseBoolean();
        if (ch == 'n') return parseNull();
        return parseNumber();
    }

    private List<Object> parseArray() {
        consume('[');
        List<Object> list = new ArrayList<>();

        while (json.charAt(index) != ']') {
            list.add(parseValue());
            skipWhitespace();
            if (json.charAt(index) == ',') {
                index++;
            }
        }
        consume(']');
        return list;
    }

    private String parseString() {
        consume('"');
        StringBuilder sb = new StringBuilder();

        while (json.charAt(index) != '"') {
            sb.append(json.charAt(index++));
        }
        consume('"');
        return sb.toString();
    }

    private Boolean parseBoolean() {
        if (json.startsWith("true", index)) {
            index += 4;
            return true;
        } else {
            index += 5;
            return false;
        }
    }

    private Object parseNull() {
        index += 4;
        return null;
    }

    private Number parseNumber() {
        int start = index;
        while (index < json.length()
                && "-0123456789.".indexOf(json.charAt(index)) != -1) {
            index++;
        }
        String number = json.substring(start, index);
        return number.contains(".")
                ? Double.parseDouble(number)
                : Long.parseLong(number);
    }

    private void consume(char expected) {
        if (json.charAt(index) != expected) {
            throw new RuntimeException(
                    "Expected '" + expected + "' at index " + index
            );
        }
        index++;
    }

    private void skipWhitespace() {
        while (index < json.length()
                && Character.isWhitespace(json.charAt(index))) {
            index++;
        }
    }
}
