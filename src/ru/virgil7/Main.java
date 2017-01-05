package ru.virgil7;

import ru.virgil7.functions.SigmoidFunction;
import ru.virgil7.functions.ThresholdFunction;
import ru.virgil7.perceptron.Neuron;
import ru.virgil7.perceptron.OneLayerPerceptron;
import ru.virgil7.perceptron.TwoLayerPerceptron;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        //        FirstWork.firstWork();
        //        SecondWork.secondWork();

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

        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{0, 0})));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{0, 1})));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{1, 0})));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{1, 1})));

        testInputs = new double[][]{
                {
                        1, 0, 0, 0, 0,
                        0, 1, 0, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 0, 1, 0,
                        0, 0, 0, 0, 1
                },

                {
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0,
                        0, 0, 1, 0, 0
                },

                {
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0,
                        1, 1, 1, 1, 1
                },

                {
                        0, 0, 0, 0, 1,
                        0, 0, 0, 0, 1,
                        0, 0, 0, 0, 1,
                        0, 0, 0, 0, 1,
                        0, 0, 0, 0, 1
                },

                {
                        1, 0, 0, 0, 1,
                        1, 0, 0, 0, 1,
                        1, 0, 0, 0, 1,
                        1, 0, 0, 0, 1,
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


        //        neurons = new Neuron[]{
        //                new Neuron(new ThresholdFunction()),
        //                new Neuron(new ThresholdFunction()),
        //                new Neuron(new ThresholdFunction()),
        //                new Neuron(new ThresholdFunction()),
        //                new Neuron(new ThresholdFunction()),
        //        };

        neurons = new Neuron[]{
                new Neuron(new SigmoidFunction(1)),
                new Neuron(new SigmoidFunction(1)),
                new Neuron(new SigmoidFunction(1)),
                new Neuron(new SigmoidFunction(1)),
                new Neuron(new SigmoidFunction(1)),
        };
        oneLayerPerceptron = new OneLayerPerceptron(neurons);
        oneLayerPerceptron.learn(testInputs, testTargets, 0.001, 0, 1500);

        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1
        })));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1
        })));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                1, 0, 0, 1, 1
        })));
        System.out.println(Arrays.toString(oneLayerPerceptron.getResult(new double[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
                0, 0, 0, 0, 1
        })));


        TwoLayerPerceptron twoLayerPerceptron;


    }


}


