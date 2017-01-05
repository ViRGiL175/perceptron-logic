package ru.virgil7.functions;

/**
 * Created by virgi on 05.01.2017.
 * Project: Perceptron_logic
 */
public class ThresholdFunction extends NeuronFunction {

    @Override
    public Double apply(Double aDouble) {
        return aDouble < 0.0 ? 0.0 : 1.0;
    }
}
