package com.securian.creditcompass.ComplexityModel.data;

public class Main {
    public static void main(String[] args) {
        // File paths for input and output files
        String inputFileName = "src/main/java/com/securian/creditcompass/ComplexityModel/data/mock_raw_data.csv"; // Replace with your input file name
        String outputFileName = "src/main/java/com/securian/creditcompass/ComplexityModel/data/processed_data.csv"; // Replace with your output file name

        // Create an instance of DataPreparation
        DataPreparation dataPreparation = new DataPreparation();

        // Process the data
        dataPreparation.processDataFile(inputFileName, outputFileName);

    }
}
