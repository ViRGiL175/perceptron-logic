package ru.virgil7.perceptrons;

import ru.virgil7.functions.SigmoidFunction;
import ru.virgil7.neurons.Neuron;

import java.util.Arrays;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class TwoLayerPerceptron extends Perceptron {

    private Neuron[] hiddenNeurons;

    public TwoLayerPerceptron(Neuron[] outNeurons) {
        super(outNeurons);
        System.out.println("\n" + this.getClass().getSimpleName() + ". Out Layer neurons: " + outNeurons.length);
    }

    public void learn(double[][] inputs, double[][] targets, double speed, double maxError, int maxEpoch,
                      double learnEfficiency) throws Exception {

        int hiddenNeuronsCount = (int) (0.1 * inputs.length - inputs[0].length - outs.length -
                0.5 * inputs.length - inputs[0].length - outs.length);
        hiddenNeurons = new Neuron[Math.abs(hiddenNeuronsCount)];
        System.out.println("Start learning.\n" +
                "Speed: " + speed + " " +
                "Max. error: " + maxError + " " +
                "Max. epoch: " + maxEpoch + "\n" +
                "Hidden Layer contain " + hiddenNeurons.length + " neurons.");
        if (targets[0].length != outs.length) {
            throw new IndexOutOfBoundsException("Targets and Neurons count mismatch!");
        }

        for (int i = 0, hiddenLayerNeuronsLength = hiddenNeurons.length; i < hiddenLayerNeuronsLength; i++) {
            Neuron neuron = new Neuron(new SigmoidFunction(1));
            neuron.setInputsCount(inputs[0].length);
            hiddenNeurons[i] = neuron;
        }

        for (Neuron neuron : outNeurons) {
            neuron.setInputsCount(hiddenNeurons.length);
        }

        int epoch = 0;
        double error = 0;
        double neuronError;
        double previousNeuronError;
        int targetsCount = inputs.length;

        do {
            previousNeuronError = error;
            error = 0;
            for (int k = 0; k < targetsCount; k++) {
                for (int i = 0; i < outNeurons.length; i++) {
                    double[] hiddenLayerResults = new double[hiddenNeurons.length];
                    for (int j = 0; j < hiddenLayerResults.length; j++) {
                        hiddenLayerResults[j] = hiddenNeurons[j].getResult(inputs[k]);
                    }
                    double outNeuronResult = outNeurons[i].getResult(hiddenLayerResults);
                    neuronError = (1.0 / 2.0) * Math.pow(targets[k][i] - outNeuronResult, 2);

                    double delta = outNeuronResult * (1 - outNeuronResult) * (targets[k][i] - outNeuronResult);

                    for (int j = 0; j < hiddenLayerResults.length; j++) {
                        double deltaWeightOut = speed * delta * hiddenLayerResults[j];
                        outNeurons[i].getWeights()[j] += deltaWeightOut;

                        for (int l = 0; l < inputs[0].length; l++) {
                            double deltaWeightHidden = speed + delta * outNeurons[i].getWeights()[j] *
                                    hiddenLayerResults[j] * (1 - hiddenLayerResults[j]) * targets[k][i];
                            hiddenNeurons[j].getWeights()[l] += deltaWeightHidden;
                        }
                    }
                    error += Math.abs(neuronError);
                }
            }
            epoch++;
        }
        while ((epoch <= maxEpoch) && (error > maxError) && (Math.abs(previousNeuronError - error) > learnEfficiency));
        System.out.println("Successfully learned.\nLast error: " + error + "\tLast epoch: " + epoch + "\n" +
                "Learn Efficiency: " + Math.abs(previousNeuronError - error));
    }

    @Override
    public double[] getResult(double[] inputs) throws Exception {
        double[] results = new double[outs.length];
        for (int i = 0; i < results.length; i++) {
            double[] hiddenLayerResults = new double[hiddenNeurons.length];
            for (int j = 0; j < hiddenLayerResults.length; j++) {
                hiddenLayerResults[j] = hiddenNeurons[j].getResult(inputs);
            }
            results[i] = outNeurons[i].getResult(hiddenLayerResults);
        }
        return results;
    }

    public void printResult(double[] inputs) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " results:\n" +
                "Inputs:\t\t" + Arrays.toString(inputs) + "\nOutputs:\t" + Arrays.toString(getResult(inputs)));
    }
}
