package ru.virgil7.perceptrons;

import ru.virgil7.neurons.Neuron;

import java.util.Arrays;


public class OneLayerPerceptron extends Perceptron {

    public OneLayerPerceptron(Neuron[] outNeurons) {
        super(outNeurons);
        System.out.println("\n" + this.getClass().getSimpleName() + ". Neurons: " + outNeurons.length);
    }

    public void learn(double[][] inputs, double[][] targets, double speed, double maxError, int maxEpoch) {

        System.out.println("Start learning.\n" +
                "Speed: " + speed + " " +
                "Max. error: " + maxError + " " +
                "Max. epoch: " + maxEpoch);
        if (targets[0].length != outs.length) {
            throw new IndexOutOfBoundsException("Targets and Neurons count mismatch!");
        }

        for (Neuron neuron : outNeurons) {
            neuron.setInputsCount(inputs[0].length);
        }

        int epoch = 0;
        double error;
        double neuronError;
        int targetsCount = inputs.length;

        do {
            error = 0;
            for (int k = 0; k < targetsCount; k++) {
                for (int i = 0; i < outNeurons.length; i++) {
                    neuronError = targets[k][i] - outNeurons[i].getResult(inputs[k]);
                    for (int j = 0; j < inputs[k].length; j++) {
                        double deltaWeight = speed * neuronError * inputs[k][j];
                        outNeurons[i].getWeights()[j] += deltaWeight;
                    }
                    error += Math.abs(neuronError);
                }
            }
            epoch++;
        } while ((epoch <= maxEpoch) && (error > maxError));
        System.out.println("Successfully learned.\nLast error: " + error + "\tLast epoch: " + epoch + "\n");
    }

    @Override
    public double[] getResult(double[] inputs) {
        double[] results = new double[outNeurons.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = outNeurons[i].getResult(inputs);
        }
        return results;
    }

    public void printResult(double[] inputs) {
        System.out.println(this.getClass().getSimpleName() + " results:\n" +
                "Inputs:\t\t" + Arrays.toString(inputs) + "\nOutputs:\t" + Arrays.toString(getResult(inputs)));
    }
}
