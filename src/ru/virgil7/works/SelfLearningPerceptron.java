package ru.virgil7.works;

import java.util.Random;

public class SelfLearningPerceptron {

    private double[] weights;
    private double threshold;

    public void train(double[][] exampleData, int[] exampleResult, double threshold, double lrate, int epochMax) {

        this.threshold = threshold;
        int exampleDataCount = exampleData[0].length;
        int exampleResultsCount = exampleResult.length;
        weights = new double[exampleDataCount];
        Random random = new Random();

        //initialize weights
        for (int perceptronInputs = 0; perceptronInputs < exampleDataCount; perceptronInputs++) {
            weights[perceptronInputs] = random.nextDouble();
        }

        for (int epochIndex = 0; epochIndex < epochMax; epochIndex++) {
            int totalError = 0;
            for (int exampleIndex = 0; exampleIndex < exampleResultsCount; exampleIndex++) {
                int perceptronResult = getPerceptronResult(exampleData[exampleIndex]);
                int error = exampleResult[exampleIndex] - perceptronResult;

                totalError += error;

                for (int k = 0; k < exampleDataCount; k++) {
                    double delta = lrate * exampleData[exampleIndex][k] * error;
                    weights[k] += delta;
                }

            }
            if (totalError == 0)
                break;
        }

    }

    public int getPerceptronResult(double[] input) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += weights[i] * input[i];
        }

        if (sum > threshold)
            return 1;
        else
            return 0;
    }
}
