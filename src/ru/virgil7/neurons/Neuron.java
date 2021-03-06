package ru.virgil7.neurons;

import ru.virgil7.functions.NeuronFunction;

import java.util.Random;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class Neuron {

    private int inputsCount = 1;
    private double[] inputs = new double[inputsCount];
    private double[] weights = new double[inputsCount];
    private double bias = 1;
    private double sum;
    private NeuronFunction neuronFunction;
    private double output;

    public Neuron(NeuronFunction neuronFunction) {
        this.neuronFunction = neuronFunction;
    }

    public Neuron(NeuronFunction neuronFunction, double bias) {
        this.neuronFunction = neuronFunction;
        this.bias = bias;
    }

    public void setInputsCount(int inputsCount) {
        this.inputsCount = inputsCount;
        inputs = new double[this.inputsCount];
        weights = new double[this.inputsCount];
        Random random = new Random();
        for (int i = 0; i < weights.length; i++) {
            weights[i] = random.nextDouble();
        }
    }

    public double[] getWeights() {
        return weights;
    }

    public double getResult(double[] inputs) {
        if (inputsCount != inputs.length) {
            System.out.println("Error!");
            throw new IndexOutOfBoundsException("Inputs count mismatch!");
        }
        sum = getSum(inputs);
        return f(sum);
    }

    private double f(double sum) {
        return neuronFunction.apply(sum);
    }

    private double getSum(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        sum += bias;
        return sum;
    }

    public double[] getInputs() {
        return inputs;
    }

    public double getBias() {
        return bias;
    }
}
