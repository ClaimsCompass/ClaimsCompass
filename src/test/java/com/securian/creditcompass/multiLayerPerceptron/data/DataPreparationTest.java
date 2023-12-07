package com.securian.creditcompass.multiLayerPerceptron.data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataPreparationTest {

    @Test
    void testProcessDataFile() throws IOException {
        String inputFileName = "src/main/java/com/securian/creditcompass/multiLayerPerceptron/data/mock_raw_data.csv";
        String outputFileName = "src/main/java/com/securian/creditcompass/multiLayerPerceptron/data/processed_data.csv";

        DataPreparation dataPreparation = new DataPreparation();
        dataPreparation.processDataFile(inputFileName, outputFileName);

        // Validate the output file
        try (BufferedReader br = new BufferedReader(new FileReader(outputFileName))) {
            String header = br.readLine(); // Read header
            assertNotNull(header);
        }
    }

    @Test
    void testProcessAttributes() {
        DataPreparation dataPreparation = new DataPreparation();
        String[] attributes = {"100", "Life", "1", "2", "3", "4", "Low"};

        String processedData = dataPreparation.processAttributes(attributes);

        // Validate the processed data string
        assertEquals("100, 0, 1, 2, 3, 4, 0", processedData);
    }

    @Test
    void testEncodeClaimType() {
        DataPreparation dataPreparation = new DataPreparation();

        int lifeEncoded = dataPreparation.encodeClaimType("Life");
        int healthEncoded = dataPreparation.encodeClaimType("Health");
        int employmentEncoded = dataPreparation.encodeClaimType("Employment");
        int unknownEncoded = dataPreparation.encodeClaimType("UnknownType");

        assertEquals(0, lifeEncoded);
        assertEquals(1, healthEncoded);
        assertEquals(2, employmentEncoded);
        assertEquals(-1, unknownEncoded);
    }

    @Test
    void testEncodeComplexityRating() {
        DataPreparation dataPreparation = new DataPreparation();

        int lowEncoded = dataPreparation.encodeComplexityRating("Low");
        int mediumEncoded = dataPreparation.encodeComplexityRating("Medium");
        int highEncoded = dataPreparation.encodeComplexityRating("High");
        int unknownEncoded = dataPreparation.encodeComplexityRating("UnknownRating");

        assertEquals(0, lowEncoded);
        assertEquals(1, mediumEncoded);
        assertEquals(2, highEncoded);
        assertEquals(-1, unknownEncoded);
    }
}
