package com.company;

public class Main {

    public static void main(String[] args) {
        double[][] In = {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        double[] outAnd = {0, 0, 0, 1};
        double[] outOr = {0, 1, 1, 1};
        double[] outNand = {1, 1, 1, 0};
        double[] outNor = {1, 0, 0, 0};
        double[] outXor = {0, 1, 1, 0};

        Perceptron neuronAnd = new Perceptron(In, outAnd);
        Perceptron neuronOr = new Perceptron(In, outOr, 5, 0.000001);
        Perceptron neuronNAND = new Perceptron(In, outNand, 10, 0.0001, 10000);
        Perceptron neuronNOR = new Perceptron(In, outNor, 25);
        Perceptron neuronXOR = new Perceptron(In, outXor, 15, 0.03, 1000);


    }
}
