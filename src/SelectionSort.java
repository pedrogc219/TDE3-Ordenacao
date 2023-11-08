import java.util.Random;

public class SelectionSort {
    private int[] array;
    private int trocas;
    private int iteracoes;
    private Random rand;
    private long tempoExecucao;
    public SelectionSort(int tamanho, int seed) {
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
        int iMenorValor;
        int aux;
        for (int i = 0; i < array.length; i++) {
            iMenorValor = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[iMenorValor]) {
                    iMenorValor = j;
                }
            }
            if (iMenorValor != i) {
                aux = array[i];
                array[i] = array[iMenorValor];
                array[iMenorValor] = aux;
                trocas++;
            }
            iteracoes++;
        }
        tempoExecucao = System.nanoTime() - tempoInicial;
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
