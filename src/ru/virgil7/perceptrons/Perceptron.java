package ru.virgil7.perceptrons;

import ru.virgil7.neurons.Neuron;

/**
 * Created by ViRGiL7 on 07.01.2017.
 * Project: Perceptron_logic
 */
public abstract class Perceptron {

    protected double[] outs;
    protected Neuron[] outNeurons;

    public Perceptron(Neuron[] outNeurons) {
        this.outNeurons = outNeurons;
        outs = new double[outNeurons.length];
    }

    public abstract double[] getResult(double[] inputs) throws Exception;
}
