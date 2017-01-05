package ru.virgil7.perceptron;

/**
 * Created by virgi on 05.01.2017.
 * Project: Perceptron_logic
 */
public class OneLayerPerceptron {

    private double[] outs;
    private Neuron[] neurons;

    public OneLayerPerceptron(Neuron[] neurons) {
        this.neurons = neurons;
        outs = new double[neurons.length];
    }

    public void learn(double[][] inputs, double[][] targets, double speed, double maxError, double maxEpoch)
            throws Exception {

        if (targets[0].length != outs.length) {
            throw new IndexOutOfBoundsException("Targets and Neurons count mismatch!");
        }

        for (Neuron neuron : neurons) {
            neuron.setInputsCount(inputs[0].length);
        }

        double[][] biasedInputs = new double[inputs.length][inputs[0].length + 1];
        for (int i = 0; i < biasedInputs.length; i++) {
            biasedInputs[i][0] = neurons[0].getBias();
            System.arraycopy(inputs[i], 0, biasedInputs[i], 1, inputs[0].length);
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
    }

    public double[] getResult(double[] inputs) throws Exception {
        double[] results = new double[neurons.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = neurons[i].getResult(inputs);
        }
        return results;
    }
}
