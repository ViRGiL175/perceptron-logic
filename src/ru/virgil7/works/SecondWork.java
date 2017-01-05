package ru.virgil7.works;

/**
 * Created by ViRGiL7 on 05.01.2017.
 * Project: Perceptron_logic
 */
public class SecondWork {

    public static void secondWork() {

        SigmoidPerceptron sigmoidPerceptron = new SigmoidPerceptron();

        double[][] inputDoubles = {{1}, {2}, {3}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        int[] outputInts = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};

        sigmoidPerceptron.train(inputDoubles, outputInts, 4, 0.1, 1500);
        System.out.println("\nApproximation: ");
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{1}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{2}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{3}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{4}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{5}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{6}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{7}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{8}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{9}));
        System.out.println(sigmoidPerceptron.getPerceptronResult(new double[]{10}));
    }
}
