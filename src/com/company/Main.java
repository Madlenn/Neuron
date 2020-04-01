package com.company;

public class Main {

    public static void main(String[] args) {

        double[][] In = {{0, 0, 1}, {0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        double[] outAnd = {0, 0, 0, 1};
        double[] outOr = {0, 1, 1, 1};
        double[] outNAND = {1, 1, 1, 0};
        double[] outNOR = {1, 0, 0, 0};
        double[] outXOR = {0, 1, 1, 0};

        Perceptron neuronAnd = new Perceptron(In, outAnd);
        Perceptron neuronOr = new Perceptron(In, outOr, 5, 0.000001);
        Perceptron neuronNAND = new Perceptron(In, outNAND, 10, 0.0001, 10000);
        Perceptron neuronNOR = new Perceptron(In, outNOR, 25);
        Perceptron neuronXOR = new Perceptron(In, outXOR, 15, 0.03, 1000);

        System.out.println("AND \n");
        neuronAnd.uczenieNeuronu();;
        neuronAnd.printWynik();
        neuronAnd.printWagi();
        neuronAnd.printError();
        neuronAnd.printEpochs();
        System.out.println("----------------------------------------------------- \n");
        System.out.println("OR \n");
        neuronOr.uczenieNeuronu();;
        neuronOr.printWynik();
        neuronOr.printWagi();
        neuronOr.printError();
        neuronOr.printEpochs();
        System.out.println("----------------------------------------------------- \n");
        System.out.println("NAND \n");
        neuronNAND.uczenieNeuronu();;
        neuronNAND.printWynik();
        neuronNAND.printWagi();
        neuronNAND.printError();
        neuronNAND.printEpochs();
        System.out.println("----------------------------------------------------- \n");
        System.out.println("NOR \n");
        neuronNOR.uczenieNeuronu();;
        neuronNOR.printWynik();
        neuronNOR.printWagi();
        neuronNOR.printError();
        neuronNOR.printEpochs();
        System.out.println("----------------------------------------------------- \n");
        System.out.println("XOR \n");
        neuronXOR.uczenieNeuronu();;
        neuronXOR.printWynik();
        neuronXOR.printWagi();
        neuronXOR.printError();
        neuronXOR.printEpochs();


    }
}
