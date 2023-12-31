package com.securian.creditcompass.multiLayerPerceptron.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVToInputOutputData {
    public static double[][][] getInputOutputData() {
        /*
        @return: a 3D array of doubles, where the first dimension is the input data, the second dimension is the output data, and the third dimension is the data itself
         */
        String inputFile = "src/main/java/com/securian/creditcompass/multiLayerPerceptron/training/training.csv";

        double[][] inputData = null;
        double[][] outputData = null;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            int numRows = 0;
            while ((br.readLine()) != null) {
                numRows++;
            }

            // Resetting the reader to start from the beginning of the file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Initializing arrays based on the number of rows in the CSV
            inputData = new double[numRows][6]; // Assuming 7 columns
            outputData = new double[numRows][1]; // Assuming 1 output column

            int row = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (int col = 0; col < values.length - 1; col++) {
                    inputData[row][col] = Double.parseDouble(values[col]);
                }
                outputData[row][0] = Double.parseDouble(values[values.length - 1]);
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new double[][][] {inputData, outputData};
    }

}
