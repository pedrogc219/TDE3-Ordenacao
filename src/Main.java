import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    /*
    BCC 4A
    Pedro Gonçalves Classen

    A - Selection sort
    B - Quick sort, Merge sort
     */
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output/resultados4.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Algoritimo,Tamanho do Vetor,Trocas,Iteracoes,Tempo(ns)");
        bw.newLine();

        int[] tamanhoDeTeste = {50, 500, 1000, 5000, 10000};

        for (int tamanho: tamanhoDeTeste) {
            for (int i = 0; i < 5; i++) {
                SelectionSort selectionSort = new SelectionSort(tamanho, 219727);
                selectionSort.fill();
                selectionSort.sort();
                selectionSort.imprimir();
                bw.write("Selection sort,"+selectionSort.getArray().length+","+selectionSort.getTrocas()+","+selectionSort.getIteracoes()+","+selectionSort.getTempoExecucao());
                bw.newLine();
            }
        }

        for (int tamanho: tamanhoDeTeste) {
            for (int i = 0; i < 5; i++) {
                Quicksort quicksort = new Quicksort(tamanho, 219727);
                quicksort.fill();
                long tempoInicio = System.nanoTime();
                quicksort.sort(0, quicksort.getArray().length);
                quicksort.setTempoExecucao(System.nanoTime() - tempoInicio);
                quicksort.imprimir();
                bw.write("Quick sort,"+quicksort.getArray().length+","+quicksort.getTrocas()+","+quicksort.getIteracoes()+","+quicksort.getTempoExecucao());
                bw.newLine();
            }
        }

        for (int tamanho: tamanhoDeTeste){
            for (int i = 0; i < 5; i++) {
                Mergesort mergesort = new Mergesort(tamanho, 219727);
                mergesort.fill();
                mergesort.sort();
                mergesort.imprimir();
                bw.write("Merge sort,"+mergesort.getArray().length+","+mergesort.getTrocas()+","+mergesort.getIteracoes()+","+mergesort.getTempoExecucao());
                bw.newLine();
            }
        }

        bw.close();
    }
}
