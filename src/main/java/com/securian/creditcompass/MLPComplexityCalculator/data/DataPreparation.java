package com.securian.creditcompass.MLPComplexityCalculator.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataPreparation {

    public void processDataFile(String inputFileName, String outputFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String header = br.readLine(); // Read and skip the header line

            if (header != null) {
                bw.write(header + "\n"); // Write header to the output file
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(", ");

                // Process the data and write to output
                String processedData = processAttributes(attributes);
                bw.write(processedData + "\n");
            }
            System.out.println("Data processing complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processAttributes(String[] attributes) {
        // Get the data from the attributes
        int claimAmount = Integer.parseInt(attributes[0]);
        String claimType = attributes[1];
        int partyA = Integer.parseInt(attributes[2]);
        int partyB = Integer.parseInt(attributes[3]);
        int partyC = Integer.parseInt(attributes[4]);
        int examinerSeniorityLevel = Integer.parseInt(attributes[5]);
        String complexityRating = attributes[6];

        // Encode the data
        int claimTypeEncoded = encodeClaimType(claimType);
        int complexityRatingEncoded = encodeComplexityRating(complexityRating);

        // Creating the processed data string
        return claimAmount + ", " + claimTypeEncoded + ", " + partyA + ", " + partyB + ", " + partyC +
                ", " + examinerSeniorityLevel + ", " + complexityRatingEncoded;
    }

    // Mock encoding methods (replace with actual encoding logic)
    private int encodeClaimType(String claimType) {
        return switch (claimType) {
            case "Life" -> 0;
            case "Health" -> 1;
            case "Employment" -> 2;
            default -> -1; // Handle unknown types
        };
    }

    private int encodeComplexityRating(String complexityRating) {
        return switch (complexityRating) {
            case "Low" -> 0;
            case "Medium" -> 1;
            case "High" -> 2;
            default -> -1; // Handle unknown ratings
        };
    }

    public static void main(String[] args) {
        // File paths for input and output files
        String inputFileName = "src/main/java/com/securian/creditcompass/ComplexityModel/data/mock_raw_data.csv";
        String outputFileName = "src/main/java/com/securian/creditcompass/ComplexityModel/data/processed_data.csv";

    }
}

