package br.edu.ifspsaocarlos.sdm.sorteadorjogos.model;

public class Dado {
    private final int qtdeLado;

    public Dado(int qtdeLado) {
        this.qtdeLado = qtdeLado;
    }

    public int jogar() {
        double sorteado = Math.random() * qtdeLado;
        return (int) sorteado + 1;
    }
}
