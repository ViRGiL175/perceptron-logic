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

    public static void main(String[] args) {
        firstWork();
        secondWork();
    }

    private static void secondWork() {
        Neuron[] neurons = {
                new Neuron(new SigmoidFunction(1), -0.9)
        };
        TwoLayerPerceptron twoLayerPerceptron = new TwoLayerPerceptron(neurons, 1, 100);

        double[][] testInputs = {
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
                {8},
                {9},
                {10}
        };
        double[][] testTargets = {
                {4},
                {9},
                {16},
                {25},
                {36},
                {49},
                {64},
                {81},
                {100}
        };

        twoLayerPerceptron.learn(testInputs, testTargets, 0.5, 0.0001, 15000, 0.000001);
        twoLayerPerceptron.printResult(new double[]{8});
        twoLayerPerceptron.printResult(new double[]{2});
        twoLayerPerceptron.printResult(new double[]{5});
        twoLayerPerceptron.printResult(new double[]{4});

        neurons = new Neuron[]{
                new Neuron(new SigmoidFunction(1))
        };
        twoLayerPerceptron = new TwoLayerPerceptron(neurons, 1, 100);

        testInputs = new double[][]{
                {1, 4, 9, 16},
                {4, 9, 16, 25},
                {9, 16, 25, 36},
                {16, 25, 36, 49},
                {25, 36, 49, 64},
        };

        testTargets = new double[][]{
                {25},
                {36},
                {49},
                {64},
                {81},
        };

        twoLayerPerceptron.learn(testInputs, testTargets, 1, 0.001, 1500000, 0.000001);
        twoLayerPerceptron.printResult(new double[]{4, 9, 16, 25});
        twoLayerPerceptron.printResult(new double[]{9, 16, 25, 36});
        twoLayerPerceptron.printResult(new double[]{25, 36, 49, 64});
    }

    private static void firstWork() {
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

        oneLayerPerceptron.printResult(new double[]{0, 0});
        oneLayerPerceptron.printResult(new double[]{0, 1});
        oneLayerPerceptron.printResult(new double[]{1, 0});
        oneLayerPerceptron.printResult(new double[]{1, 1});

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

        oneLayerPerceptron.printResult(new double[]{
                1, 1, 1, 1, 1,
                1, 0, 1, 0, 1,
                1, 0, 1, 0, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        });
        oneLayerPerceptron.printResult(new double[]{
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 1,
                1, 0, 0, 0, 1
        });
        oneLayerPerceptron.printResult(new double[]{
                1, 1, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        });
        oneLayerPerceptron.printResult(new double[]{
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 1, 0, 0, 1,
                1, 0, 0, 0, 1
        });
        oneLayerPerceptron.printResult(new double[]{
                1, 0, 0, 0, 1,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 1, 0, 1, 0,
                1, 0, 0, 0, 1
        });
    }
}


