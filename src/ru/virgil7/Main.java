package ru.virgil7;

import ru.virgil7.functions.SigmoidFunction;
import ru.virgil7.functions.ThresholdFunction;
import ru.virgil7.neurons.Neuron;
import ru.virgil7.perceptrons.OneLayerPerceptron;
import ru.virgil7.perceptrons.TwoLayerPerceptron;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class Main {

    public static void main(String[] args) throws Exception {

        firstWork();

        Neuron[] neurons = {
                new Neuron(new SigmoidFunction(1), 1),
        };
        TwoLayerPerceptron twoLayerPerceptron = new TwoLayerPerceptron(neurons);

        double[][] testInputs = {
                {0.1},
                {0.2},
                {0.3},
                {0.4},
                {0.5},
                {0.6},
                {0.7},
                {0.8},
                {0.9},
                {1.0}
        };
        double[][] testTargets = {
                {0.01},
                {0.04},
                {0.09},
                {0.16},
                {0.25},
                {0.36},
                {0.49},
                {0.64},
                {0.81},
                {1.0}
        };

        twoLayerPerceptron.learn(testInputs, testTargets, 0.01, 0.01, 15000, 0.0001);
        twoLayerPerceptron.getResult(new double[]{0.6});
        twoLayerPerceptron.getResult(new double[]{0.1});
        twoLayerPerceptron.getResult(new double[]{0.2});
        twoLayerPerceptron.getResult(new double[]{0.4});
        twoLayerPerceptron.getResult(new double[]{1.0});

        neurons = new Neuron[]{
                new Neuron(new SigmoidFunction(1), 1),
        };
        twoLayerPerceptron = new TwoLayerPerceptron(neurons);

        testInputs = new double[][]{
                {0.01, 0.04, 0.09, 0.16},
                {0.04, 0.09, 0.16, 0.25},
                {0.09, 0.16, 0.25, 0.36},
                {0.16, 0.25, 0.36, 0.49},
                {0.25, 0.36, 0.49, 0.64},
        };
        testTargets = new double[][]{
                {0.25},
                {0.36},
                {0.49},
                {0.64},
                {0.81},
        };

        twoLayerPerceptron.learn(testInputs, testTargets, 0.01, 0.0, 15000, 0.0001);

        twoLayerPerceptron.getResult(new double[]{0.04, 0.09, 0.16, 0.25});
        twoLayerPerceptron.getResult(new double[]{0.09, 0.16, 0.25, 0.36});
        twoLayerPerceptron.getResult(new double[]{0.25, 0.36, 0.49, 0.64});
    }

    private static void firstWork() throws Exception {
        double[][] testInputs = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
        };
        double[][] testTargets = {
                {0},
                {0},
                {1},
                {0},
        };

        Neuron[] neurons = {
                new Neuron(new ThresholdFunction(), -0.5),
        };
        OneLayerPerceptron oneLayerPerceptron = new OneLayerPerceptron(neurons);
        oneLayerPerceptron.learn(testInputs, testTargets, 0.001, 0, 1500);

        oneLayerPerceptron.getResult(new double[]{0, 0});
        oneLayerPerceptron.getResult(new double[]{0, 1});
        oneLayerPerceptron.getResult(new double[]{1, 0});
        oneLayerPerceptron.getResult(new double[]{1, 1});

        testInputs = new double[][]{
                {
                        1, 1, 1, 1, 1,
                        1, 0, 1, 0, 1,
                        1, 1, 1, 1, 1,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0
                },

                {
                        0, 0, 1, 0, 0,
                        0, 1, 0, 1, 0,
                        1, 0, 0, 0, 1,
                        1, 1, 1, 1, 1,
                        1, 0, 0, 0, 1
                },

                {
                        1, 1, 1, 1, 1,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0
                },

                {
                        1, 0, 0, 0, 1,
                        1, 0, 0, 1, 1,
                        1, 0, 1, 0, 1,
                        1, 1, 0, 0, 1,
                        1, 0, 0, 0, 1
                },

                {
                        1, 0, 0, 0, 1,
                        0, 1, 0, 1, 0,
                        0, 0, 1, 0, 0,
                        0, 1, 0, 1, 0,
                        1, 0, 0, 0, 1
                }
        };

        testTargets = new double[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1},
        };

        double bias = 2;
        neurons = new Neuron[]{
                new Neuron(new ThresholdFunction(), bias),
                new Neuron(new ThresholdFunction(), bias),
                new Neuron(new ThresholdFunction(), bias),
                new Neuron(new ThresholdFunction(), bias),
                new Neuron(new ThresholdFunction(), bias),
        };

        oneLayerPerceptron = new OneLayerPerceptron(neurons);
        oneLayerPerceptron.learn(testInputs, testTargets, 0.001, 0, 150000);

        oneLayerPerceptron.getResult(new double[]{
                1, 1, 1, 1, 1,
                1, 0, 1, 0, 1,
                1, 1, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        });
        oneLayerPerceptron.getResult(new double[]{
                0, 0, 1, 0, 0,
                0, 1, 0, 1, 0,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 1,
                1, 0, 0, 0, 1
        });
        oneLayerPerceptron.getResult(new double[]{
                1, 1, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        });
        oneLayerPerceptron.getResult(new double[]{
                1, 0, 0, 0, 1,
                1, 0, 0, 1, 1,
                1, 0, 1, 0, 1,
                1, 1, 0, 0, 1,
                1, 0, 0, 0, 1
        });
        oneLayerPerceptron.getResult(new double[]{
                1, 0, 0, 0, 1,
                0, 1, 0, 1, 0,
                0, 0, 1, 0, 0,
                0, 1, 0, 1, 0,
                1, 0, 0, 0, 1
        });
    }
}


