import java.util.Random;

public class Quicksort {
    private int[] array;
    private int trocas;
    private int iteracoes;
    private Random rand;
    private long tempoExecucao;
    public Quicksort(int tamanho, int seed) {
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
    public void setTempoExecucao(long tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public void fill() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(999999999);
        }
    }

    public void sort(int esquerda, int direita) {
        if (esquerda >= direita) {
            return;
        }
        int pivo = array[esquerda];
        int iFinal = esquerda;
        int aux;

        for (int j = esquerda+1; j < direita; j++) {
            if (array[j] < pivo) {
                iFinal++;
                aux = array[j];
                array[j] = array[iFinal];
                array[iFinal] = aux;
                trocas++;
            }
        }
        aux = array[iFinal];
        array[iFinal] = array[esquerda];
        array[esquerda] = aux;
        trocas++;
        
        sort(esquerda, iFinal);
        sort(iFinal+1, direita);
        iteracoes++;
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
