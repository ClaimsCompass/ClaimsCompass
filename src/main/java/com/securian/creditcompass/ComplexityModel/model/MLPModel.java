package com.securian.creditcompass.ComplexityModel.model;

import org.deeplearning4j.datasets.iterator.impl.ListDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.NormalizerMinMaxScaler;
import org.nd4j.linalg.factory.Nd4j;

public class MLPModel {

    public static void main(String[] args) {
        // Define sample dataset
        double[][] inputData = {
                {10000, 0, 1, 1, 0, 0},
                {5000, 1, 0, 0, 1, 1},
                {10000, 2, 1, 0, 2, 3}
        };
        double[][] outputData = {
                {2},
                {0},
                {1}
        };

        // Convert data into INDArrays
        INDArray input = Nd4j.create(inputData);
        INDArray output = Nd4j.create(outputData);

        // Normalize input data
        DataNormalization normalizer = new NormalizerMinMaxScaler();
        normalizer.fit(new DataSet(input, output));
        normalizer.transform(input);

        // Create a DataSet from the INDArrays
        DataSet dataSet = new DataSet(input, output);

        // Create a DataSetIterator from the DataSet
        ListDataSetIterator<DataSet> dataSetIterator = new ListDataSetIterator<>(dataSet.asList(), 1);

        // Set up network configuration
        int numInputs = inputData[0].length;
        int numOutputs = outputData[0].length;
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(123)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .list()
                .layer(new DenseLayer.Builder().nIn(numInputs).nOut(10)
                        .activation(Activation.RELU)
                        .build())
                .layer(new DenseLayer.Builder().nIn(10).nOut(10)
                        .activation(Activation.RELU)
                        .build())
                .layer(new OutputLayer.Builder()
                        .nIn(10).nOut(numOutputs)
                        .activation(Activation.IDENTITY)
                        .build()) // Output layer should be an OutputLayer
                .build();

        // Create the model
        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(100));

        // Train the model
        int numEpochs = 10;
        for (int i = 0; i < numEpochs; i++) {
            model.fit(dataSetIterator);
            dataSetIterator.reset();
        }

        // Test the trained model (optional)
        INDArray testInput = Nd4j.create(new double[][]{{100000, 1, 1, 0, 0, 1}});
        normalizer.transform(testInput); // Normalize test data
        INDArray predicted = model.output(testInput);
        System.out.println("Predicted Output: " + predicted);
    }
}
