package ru.virgil7;

import ru.virgil7.functions.ThresholdFunction;
import ru.virgil7.perceptron.Neuron;
import ru.virgil7.perceptron.OneLayerPerceptron;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class Main {

    public static void main(String[] args) throws Exception {

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


