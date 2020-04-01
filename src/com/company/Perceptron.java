package com.company;

import java.util.Arrays;
import java.util.Random;

public class Perceptron {
    private double[][] in; //wzorcowa tablica wejsciowa
    private double[] out; //wzorcowa tablica wyjsciowa
    private double lr = 10; //predkosc uczenia perceptronu
    private double maxError = 0.001;//maksymalny bład
    private int maxEpochs = 10000; //maksymalna liczba epok
    private double[] wagi; //tablica z wagami
    private double error; //błąd uczenia
    private int epochs; //liczba epok

    public Perceptron() {
        super();
    }

    public Perceptron(double[][] in, double[] out) {
        this.in = in;
        this.out = out;
    }

    public Perceptron(double[][] in, double[] out, double lr) {
        this(in, out);
        this.lr = lr;
    }

    public Perceptron(double[][] in, double[] out, double lr, double maxError) {
        this(in, out, lr);
        this.maxError = maxError;
    }

    public Perceptron(double[][] in, double[] out, double lr, double maxError, int maxEpochs) {
        this(in, out, lr, maxError);
        this.maxEpochs = maxEpochs;

    }


    private double[] losujWagi() {
        Random rand = new Random();
        double[] wgs = new double[this.out.length];

        for (int i = 0; i < this.in[0].length; i++) {
            wgs[i] = 2 * rand.nextDouble() - 1;
        }
        return wgs;
    }

    public void uczenieNeuronu() {
//przypisanie wartości początkowych epok i błędu uczenia
        this.epochs = 0;
        this.error = 1;
//inicjowanie tablic lokalnych (istnieją tylko w tej metodzie)
        double[] y = new double[this.out.length];
        double[] zeros = new double[this.out.length];
        double[] blad = new double[this.out.length];
        double[] poprawka = new double[this.out.length];
        this.wagi = losujWagi(); //losowanie wag początkowych
        while (this.error > this.maxError && this.epochs < this.maxEpochs) {
//klonowanie tablicy zero, która posiada zerowe elementy
            y = zeros.clone();
            blad = zeros.clone(); //jw
            poprawka = zeros.clone(); //jw
//obliczanie aktualnych wart. Wyjść. perceptronu i tablicy poprawek
            for (int i = 0; i < this.out.length; i++) {
                for (int j = 0; j < this.in[0].length; j++) {
//mnożenie wejscia i wagi z jednoczesnym sumowaniem
                    y[i] += this.in[i][j] * this.wagi[j];
                }
                y[i] = Sigmoid.f(y[i]); //wartość wyjściowa perceptronu
                blad[i] = this.out[i] - y[i]; // wyjść. wzorcowe – wyjść. aktualne
                poprawka[i] = blad[i] * Sigmoid.der(y[i]); //tablica poprawek
            }
//wagi
            for (int k = 0; k < this.in[0].length; k++) {
                double sum = 0;
                for (int l = 0; l < this.out.length; l++) {
                    sum += this.in[l][k] * poprawka[l];
                }
                this.wagi[k] += this.lr * sum; // wyznaczenie nowych wag
            }
//błąd uczenia
            this.error = 0;
            for (int m = 0; m < this.out.length; m++) {
//błąd średniokwadratowy
                this.error += Math.pow(blad[m], 2) / this.out.length;
            }
            this.epochs++; //liczba epok + 1
        }
    }

    public void printWynik() {

        System.out.println("Uczenie pojedynczego perceptronu do realizacji funkcji logicznej:");
        System.out.println("Wynik neuronu | Wynik wzorcowy");
        double[] Yspr = new double[this.out.length];
        for (int i = 0; i < this.out.length; i++) {
            for (int j = 0; j < this.in[0].length; j++) {
                Yspr[i] += this.in[i][j] * this.wagi[j];
            }
            Yspr[i] = Sigmoid.f(Yspr[i]);
            System.out.println(Yspr[i] + " | " + this.out[i]);
        }
        System.out.println("");
    }

    public void printWagi() {
        System.out.println(" Współczynniki wagowe:  ");
        System.out.println(Arrays.toString(wagi));

    }

    public void printError() {
        System.out.println("Błąd uczenia " + error);
    }

    public void printEpochs() {
        System.out.println("Liczba epok uczenia: " + epochs);
    }
}

