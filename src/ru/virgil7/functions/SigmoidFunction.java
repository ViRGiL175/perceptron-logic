package ru.virgil7.functions;

/**
 * Created by virgi on 05.01.2017.
 * Project: Perceptron_logic
 */
public class SigmoidFunction extends NeuronFunction {

    private double alpha;

    public SigmoidFunction(double alpha) {
        this.alpha = alpha;
    }

    private SigmoidFunction() {
        // Forcing alpha value
    }

    @Override
    public Double apply(Double sum) {
        return 1 / (1 + Math.exp(-alpha * sum));
    }
}

