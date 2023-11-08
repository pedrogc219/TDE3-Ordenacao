import java.util.Random;

public class Mergesort {
    private int[] array;
    private int trocas;
    private int iteracoes;
    private Random rand;
    private long tempoExecucao;
    public Mergesort(int tamanho, int seed) {
        array = new int[tamanho];
        trocas = 0;
        iteracoes = 0;
        rand = new Random(seed);
        tempoExecucao = 0;
    }

    public int[] getArray() {
        return array;
    }
    public int getIteracoes() {
        return iteracoes;
    }
    public int getTrocas() {
        return trocas;
    }
    public long getTempoExecucao() {
        return tempoExecucao;
    }

    public void fill() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(999999999);
        }
    }

    public void sort() {
        long tempoInicial = System.nanoTime();
        array = split(array);
        tempoExecucao = System.nanoTime() - tempoInicial;
    }

    public int[] split(int[] array) {
        int tamanho = array.length;
        if (tamanho == 1) {
            return array;
        }

        int[] arrayEsquerda = new int[tamanho/2];
        int[] arrayDireita = new int[tamanho-(tamanho/2)];
        for (int i = 0; i < arrayEsquerda.length; i++) {
            arrayEsquerda[i] = array[i];
        }
        for (int i = 0; i < arrayDireita.length; i++) {
            arrayDireita[i] = array[i+ arrayEsquerda.length];
        }
        arrayEsquerda = split(arrayEsquerda);
        arrayDireita = split(arrayDireita);

        iteracoes++;

        return merge(arrayEsquerda, arrayDireita);
    }

    public int[] merge(int[] arrayA, int[] arrayB) {
        iteracoes++;
        int[] arrayMerge = new int[arrayA.length+arrayB.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] < arrayB[j]) {
                arrayMerge[k] = arrayA[i];
                i++;
            } else {
                arrayMerge[k] = arrayB[j];
                j++;
            }
            k++;
            trocas++;
        }
        while (i < arrayA.length) {
            arrayMerge[k] = arrayA[i];
            i++;
            k++;
            trocas++;
        }
        while (j < arrayB.length) {
            arrayMerge[k] = arrayB[j];
            j++;
            k++;
            trocas++;
        }
        return arrayMerge;
    }

    public void imprimir() {
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
        System.out.println("Tempo de execucao: "+tempoExecucao);
        System.out.println("Trocas: "+trocas);
        System.out.println("Iteracoes: "+iteracoes);
    }
}
