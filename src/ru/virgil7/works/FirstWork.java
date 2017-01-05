package ru.virgil7.works;

import java.util.Arrays;


/**
 * Created by virgi on 05.01.2017.
 * Project: Perceptron_logic
 */
public class FirstWork {

    public static void firstWork() {
        System.out.println("\nSingle perceptron:");
        SelfLearningPerceptron singleSelfLearningPerceptronNetwork = new SelfLearningPerceptron();
        double[][] inputDoubles = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        int[] outputInts = {0, 0, 1, 0};
        System.out.println("Train on:");
        System.out.println("Input:\t" + Arrays.deepToString(inputDoubles));
        System.out.println("Output:\t" + Arrays.toString(outputInts));
        singleSelfLearningPerceptronNetwork.train(inputDoubles, outputInts, 0, 0.1, 1500);
        System.out.println("Trained!\n");
        System.out.println("Results:");
        System.out.println(singleSelfLearningPerceptronNetwork.getPerceptronResult(new double[]{0, 0}));
        System.out.println(singleSelfLearningPerceptronNetwork.getPerceptronResult(new double[]{0, 1}));
        System.out.println(singleSelfLearningPerceptronNetwork.getPerceptronResult(new double[]{1, 0}));
        System.out.println(singleSelfLearningPerceptronNetwork.getPerceptronResult(new double[]{1, 1}));

        System.out.println("\nSymbols:");
        SelfLearningPerceptron selfLearningPerceptron1 = new SelfLearningPerceptron();
        SelfLearningPerceptron selfLearningPerceptron2 = new SelfLearningPerceptron();
        SelfLearningPerceptron selfLearningPerceptron3 = new SelfLearningPerceptron();
        SelfLearningPerceptron selfLearningPerceptron4 = new SelfLearningPerceptron();
        SelfLearningPerceptron selfLearningPerceptron5 = new SelfLearningPerceptron();
        double[][] inputData = {
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

        int[] outputDoubles1 = {1, 0, 0, 0, 0};
        int[] outputDoubles2 = {0, 1, 0, 0, 0};
        int[] outputDoubles3 = {0, 0, 1, 0, 0};
        int[] outputDoubles4 = {0, 0, 0, 1, 0};
        int[] outputDoubles5 = {0, 0, 0, 0, 1};

        selfLearningPerceptron1.train(inputData, outputDoubles1, 0, 0.1, 1500);
        selfLearningPerceptron2.train(inputData, outputDoubles2, 0, 0.1, 1500);
        selfLearningPerceptron3.train(inputData, outputDoubles3, 0, 0.1, 1500);
        selfLearningPerceptron4.train(inputData, outputDoubles4, 0, 0.1, 1500);
        selfLearningPerceptron5.train(inputData, outputDoubles5, 0, 0.1, 1500);
        System.out.println("Trained!\n");
        System.out.println("Results:");

        double[] doublesTest1 = new double[]{
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1
        };

        double[] doublesTest2 = new double[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                1, 1, 1, 1, 1
        };

        double[] doublesTest3 = new double[]{
                1, 0, 0, 0, 0,
                0, 1, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 0, 1, 0,
                0, 0, 0, 0, 1
        };

        System.out.println(selfLearningPerceptron1.getPerceptronResult(doublesTest2));
        System.out.println(selfLearningPerceptron2.getPerceptronResult(doublesTest2));
        System.out.println(selfLearningPerceptron3.getPerceptronResult(doublesTest2));
        System.out.println(selfLearningPerceptron4.getPerceptronResult(doublesTest2));
        System.out.println(selfLearningPerceptron5.getPerceptronResult(doublesTest2));
    }
}
