import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Curso curso3 = new Curso();
        curso3.setTitulo("curso HTML e CSS");
        curso3.setDescricao("descrição curso HTML e CSS");
        curso3.setCargaHoraria(5);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTutor("Camilla Cavalcante");
        mentoria1.setTitulo("mentoria de java");
        mentoria1.setDescricao("descrição mentoria java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTutor("Camilla Cavalcante");
        mentoria2.setTitulo("mentoria de js");
        mentoria2.setDescricao("descrição mentoria js");
        mentoria2.setData(LocalDate.now());

        Mentoria mentoria3 = new Mentoria();
        mentoria3.setTutor("Camilla Cavalcante");
        mentoria3.setTitulo("mentoria de HTML e CSS");
        mentoria3.setDescricao("descrição mentoria HTML e CSS");
        mentoria3.setData(LocalDate.now());

        Bootcamp bootcamp1 = new Bootcamp();
        bootcamp1.setNome("Bootcamp Java Developer");
        bootcamp1.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp1.getConteudos().add(curso1);
        bootcamp1.getConteudos().add(curso2);
        bootcamp1.getConteudos().add(mentoria1);

        Bootcamp bootcamp2 = new Bootcamp();
        bootcamp2.setNome("Bootcamp Java Developer");
        bootcamp2.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp2.getConteudos().add(curso3);
        bootcamp2.getConteudos().add(mentoria3);

        System.out.println("==================== Camila ====================");
        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp1);
        devCamila.exibirConteudosInscritos();
        devCamila.progredir();
        System.out.println("---------------------------------------------------");
        devCamila.cancelarInscricaoConteudo(curso2);
        devCamila.exibirConteudosInscritos();
        devCamila.exibirConteudosConcluidos();
        System.out.println("---------------------------------------------------");
        devCamila.exibirProgresso();


        System.out.println("==================== João ====================");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp1);
        devJoao.exibirConteudosInscritos();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("---------------------------------------------------");
        devJoao.exibirConteudosInscritos();
        devJoao.exibirConteudosConcluidos();
        System.out.println("---------------------------------------------------");
        devJoao.exibirProgresso();


        System.out.println("==================== Lucas ====================");

        Dev devLucas = new Dev();
        devLucas.setNome("Lucas");
        devLucas.inscreverBootcamp(bootcamp1);
        devLucas.inscreverBootcamp(bootcamp2);
        devLucas.exibirConteudosInscritos();
        devLucas.progredir();
        System.out.println("---------------------------------------------------");
        devLucas.cancelarInscricaoBootcamp(bootcamp2);
        devLucas.exibirConteudosInscritos();
        devLucas.exibirConteudosConcluidos();
        System.out.println("---------------------------------------------------");
        devLucas.exibirProgresso();

    }

}
