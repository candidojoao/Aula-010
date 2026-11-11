package br.edu.exemplo;

public class BubbleSort {

    private int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = numeros;
    }

    public void ordenar() {
        int n = numeros.length;
        boolean houveTroca = true;

        for (int passada = 0; passada < n - 1 && houveTroca; passada++) {
            houveTroca = false;
            for (int i = 0; i < n - 1 - passada; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    trocar(i, i + 1);
                    houveTroca = true;
                }
            }
        }
    }

    private void trocar(int i, int j) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }

    public int[] getNumeros() {
        return numeros;
    }
}
