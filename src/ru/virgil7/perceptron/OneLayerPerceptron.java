package ru.virgil7.perceptron;

import java.util.Arrays;


public class OneLayerPerceptron {

    private double[] outs;
    private Neuron[] neurons;

    public OneLayerPerceptron(Neuron[] neurons) {
        this.neurons = neurons;
        outs = new double[neurons.length];
        System.out.println("\n" + this.getClass().getSimpleName() + ". Neurons: " + neurons.length);
    }

    public void learn(double[][] inputs, double[][] targets, double speed, double maxError, double maxEpoch)
            throws Exception {
        System.out.println("Start learning.\n" +
                "Speed: " + speed + "\t" +
                "Max. error: " + maxEpoch + "\t" +
                "Max. epoch: " + maxEpoch);
        if (targets[0].length != outs.length) {
            throw new IndexOutOfBoundsException("Targets and Neurons count mismatch!");
        }

        for (Neuron neuron : neurons) {
            neuron.setInputsCount(inputs[0].length);
        }

        int epoch = 0;
        double error;
        double neuronError;
        int targetsCount = inputs.length;

        do {
            error = 0;
            for (int k = 0; k < targetsCount; k++) {
                for (int i = 0; i < neurons.length; i++) {
                    neuronError = targets[k][i] - neurons[i].getResult(inputs[k]);
                    for (int j = 0; j < inputs[k].length; j++) {
                        double delta = speed * neuronError * inputs[k][j];
                        neurons[i].getWeights()[j] += delta;
                    }
                    error += Math.abs(neuronError);
                }
            }
            epoch++;
        } while ((epoch <= maxEpoch) && (error > maxError));
        System.out.println("Successfully learned.\nLast error: " + error + "\tLast epoch: " + epoch + "\n");
    }

    public double[] getResult(double[] inputs) throws Exception {
        double[] results = new double[neurons.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = neurons[i].getResult(inputs);
        }
        System.out.println(this.getClass().getSimpleName() + " results:\n" +
                "Inputs:\t\t" + Arrays.toString(inputs) + "\nOutputs:\t" + Arrays.toString(results));
        return results;
    }
}
