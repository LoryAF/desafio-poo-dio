package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public void exibirProgresso() {
        int totalConcluidos = this.conteudosConcluidos.size();
        int totalInscritos = this.conteudosInscritos.size();
        System.out.println("Progresso de " + this.nome + ":");
        System.out.println("Conteúdos Concluídos: " + totalConcluidos);
        System.out.println("Conteúdos Inscritos: " + totalInscritos);
        System.out.println("XP:" + calcularTotalXp());
    }

    public void exibirConteudosInscritos() {
        System.out.println("Conteúdos inscritos de " + this.nome + ":");
        this.conteudosInscritos.forEach(conteudo -> System.out.println(conteudo.getTitulo()));
    }

    public void exibirConteudosConcluidos() {
        System.out.println("Conteúdos concluídos de " + this.nome + ":");
        this.conteudosConcluidos.forEach(conteudo -> System.out.println(conteudo.getTitulo()));
    }

    public void cancelarInscricaoConteudo(Conteudo conteudo) {
        if (this.conteudosConcluidos.contains(conteudo)) {
            System.err.println("Não é possível cancelar a inscrição em um conteúdo já concluído!");
            return;
        }
        if (this.conteudosInscritos.contains(conteudo)) {
            this.conteudosInscritos.remove(conteudo);
            System.out.println("Inscrição de " + getNome() + " cancelada no conteúdo: " + conteudo.getTitulo());
        } else {
            System.err.println("Você não está inscrito nesse conteúdo!");
        }
    }

    public void cancelarInscricaoBootcamp(Bootcamp bootcamp) {
        int conteudosCancelados = bootcamp.getConteudos().size();
        if (this.conteudosInscritos.removeAll(bootcamp.getConteudos())) {
            bootcamp.getDevsInscritos().remove(this);
            System.out.println("Inscrição de " + getNome() + " cancelada no Bootcamp: " + bootcamp.getNome() +
                    ". Total de conteúdos removidos: " + conteudosCancelados);
        } else {
            System.err.println("Você não estava inscrito neste Bootcamp.");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
