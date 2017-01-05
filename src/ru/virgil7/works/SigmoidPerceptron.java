package ru.virgil7.works;

import java.util.Random;

public class SigmoidPerceptron {

    private double[] weights1;
    private double[] weights2;
    private int hiddenLayer;

    public void train(double[][] exampleData, int[] exampleResult, int hiddenLayer, double learnSpeed, int epochMax) {

        int exampleDataCount = exampleData[0].length;
        int exampleResultsCount = exampleResult.length;
        this.hiddenLayer = hiddenLayer;
        weights1 = new double[exampleDataCount];
        weights2 = new double[hiddenLayer];
        Random random = new Random();

        //initialize weights1
        for (int perceptronInputs = 0; perceptronInputs < exampleDataCount; perceptronInputs++) {
            weights1[perceptronInputs] = random.nextDouble();
        }
        //initialize weights2
        for (int perceptronInputs = 0; perceptronInputs < hiddenLayer; perceptronInputs++) {
            weights2[perceptronInputs] = random.nextDouble();
        }

        for (int epochIndex = 0; epochIndex < epochMax; epochIndex++) {
            int totalError = 0;
            for (int exampleIndex = 0; exampleIndex < exampleResultsCount; exampleIndex++) {
                double inputPerceptronResult = getInputPerceptronResult(exampleData[exampleIndex]);
                double error = 0.5 * Math.pow((exampleResult[exampleIndex] - inputPerceptronResult), 2);

                totalError += error;

                double gamma = inputPerceptronResult * (1 - inputPerceptronResult) * (exampleResult[exampleIndex] - inputPerceptronResult);

                for (int k = 0; k < hiddenLayer; k++) {
                    for (int j = 0; j < exampleDataCount; j++) {
                        double delta = learnSpeed * gamma * weights1[j] * inputPerceptronResult * (1 - inputPerceptronResult) * exampleResult[exampleIndex];
                        weights2[k] += delta;
                    }
                }

                for (int k = 0; k < exampleDataCount; k++) {
                    double delta = learnSpeed * gamma * exampleResult[exampleIndex];
                    weights1[k] += delta;
                }

            }
            if (totalError == 0)
                break;
        }

    }

    private double getInputPerceptronResult(double[] input) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += weights1[i] * input[i];
        }
        return (1 / (1 + Math.exp(-sum)));
    }

    private double getHiddenPerceptronResult(double[] input) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += weights2[i] * input[i];
        }
        return (1 / (1 + Math.exp(-sum)));
    }

    public double getPerceptronResult(double[] input) {
        double sum = 0.0;
        for (int i = 0; i < input.length; i++) {
            sum += weights1[i] * input[i];
        }
        sum = (1 / (1 + Math.exp(-sum)));

        for (int i = 0; i < input.length; i++) {
            sum += weights2[i] * input[i];
        }
        return (1 / (1 + Math.exp(-sum)));
    }
}
