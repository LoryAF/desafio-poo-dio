package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private String tutor;
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public Mentoria() {
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n- Mentoria:" +
                "\nTutor = '" + getTutor() + '\'' +
                "\nTitulo = '" + getTitulo() + '\'' +
                "\nDescricao = '" + getDescricao() + '\'' +
                "\ndata = " + data;
    }
}
