package ru.virgil7.perceptrons;

import ru.virgil7.functions.SigmoidFunction;
import ru.virgil7.neurons.Neuron;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class TwoLayerPerceptron extends Perceptron {

    private final int min;
    private final int max;
    private Neuron[] hiddenNeurons;

    public TwoLayerPerceptron(Neuron[] outNeurons, int min, int max) {
        super(outNeurons);
        this.min = min;
        this.max = max;
        System.out.println("\n" + this.getClass().getSimpleName() + ". Out Layer neurons: " + outNeurons.length);
    }

    public void learn(double[][] inputs, double[][] targets, double speed, double maxError, int maxEpoch,
                      double learnEfficiency) {

        int hiddenNeuronsCount = (int) Math.abs(0.1 * inputs.length - inputs[0].length - outs.length -
                0.5 * inputs.length - inputs[0].length - outs.length);
        hiddenNeurons = new Neuron[hiddenNeuronsCount];
        System.out.println("Start learning.\n" +
                "Speed: " + speed + " " +
                "Max. error: " + maxError + " " +
                "Max. epoch: " + maxEpoch + "\n" +
                "Hidden Layer contain " + hiddenNeurons.length + " neurons.");
        if (targets[0].length != outs.length) {
            throw new IndexOutOfBoundsException("Targets count and Neurons count mismatch!");
        }

        Random random = new Random();
        for (int i = 0; i < hiddenNeurons.length; i++) {
            Neuron neuron = new Neuron(new SigmoidFunction(random.nextDouble()));
            neuron.setInputsCount(inputs[0].length);
            hiddenNeurons[i] = neuron;
        }

        for (Neuron neuron : outNeurons) {
            neuron.setInputsCount(hiddenNeurons.length);
        }

        scaleTargets(targets, min, max);

        int epoch = 0;
        double error = 0;
        double targetError;
        double previousNeuronError;

        do {
            previousNeuronError = error;
            error = 0;
            for (int k = 0; k < targets.length; k++) {
                for (int i = 0; i < outNeurons.length; i++) {
                    double[] hiddenLayerResults = new double[hiddenNeurons.length];
                    double outNeuronResult;
                    for (int j = 0; j < hiddenLayerResults.length; j++) {
                        hiddenLayerResults[j] = hiddenNeurons[j].getResult(inputs[k]);
                    }
                    outNeuronResult = outNeurons[i].getResult(hiddenLayerResults);
                    targetError = (0.5) * Math.pow(targets[k][i] - outNeuronResult, 2);

                    double delta = outNeuronResult * (1 - outNeuronResult) * (targets[k][i] - outNeuronResult);

                    for (int j = 0; j < hiddenLayerResults.length; j++) {
                        double deltaWeightOut = speed * delta * hiddenLayerResults[j];
                        outNeurons[i].getWeights()[j] += deltaWeightOut;

                        for (int l = 0; l < inputs[0].length; l++) {
                            double deltaWeightHidden = speed + delta * outNeurons[i].getWeights()[j] *
                                    hiddenLayerResults[j] * (1 - hiddenLayerResults[j]) * inputs[k][i];
                            hiddenNeurons[j].getWeights()[l] += deltaWeightHidden;
                        }
                    }
                    error += Math.abs(targetError);
                }
            }
            epoch++;
        }
        while ((epoch <= maxEpoch) && (error > maxError) && (Math.abs(previousNeuronError - error) > learnEfficiency));
        System.out.println("Successfully learned.\nLast error: " + error + "\tLast epoch: " + epoch + "\n" +
                "Learn Efficiency: " + Math.abs(previousNeuronError - error));
    }

    @Override
    public double[] getResult(double[] inputs) {
        double[] outerLayerResults = new double[outs.length];
        double[] hiddenLayerResults = new double[hiddenNeurons.length];
        for (int i = 0; i < outerLayerResults.length; i++) {
            for (int j = 0; j < hiddenLayerResults.length; j++) {
                hiddenLayerResults[j] = hiddenNeurons[j].getResult(inputs);
            }
            outerLayerResults[i] = outNeurons[i].getResult(hiddenLayerResults);
        }
        scaleResult(outerLayerResults, min, max);
        return outerLayerResults;
    }

    @Override
    public void printResult(double[] inputs) {
        System.out.println(this.getClass().getSimpleName() + " results:\n" +
                "Inputs:\t\t" + Arrays.toString(inputs) + "\nOutputs:\t" + Arrays.toString(getResult(inputs)));
    }

    private void scaleResult(double[] result, double min, double max) {
        double m = 0.1 / min;
        double k = 0.8 / max;
        for (int i = 0; i < result.length; i++) {
            result[i] = (result[i] - m) / k;
        }
    }

    private void scaleTargets(double[][] testTargets, double min, double max) {
        double m = 0.1 / min;
        double k = 0.8 / max;
        for (int i = 0; i < testTargets.length; i++) {
            for (int j = 0; j < testTargets[0].length; j++) {
                testTargets[i][j] = testTargets[i][j] * k + m;
            }
        }
    }
}
