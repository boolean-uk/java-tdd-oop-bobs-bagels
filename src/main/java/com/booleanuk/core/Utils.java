package com.booleanuk.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static String getJsonAsString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder jsonContentBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonContentBuilder.append(line);
        }

        return jsonContentBuilder.toString();
    }
}
