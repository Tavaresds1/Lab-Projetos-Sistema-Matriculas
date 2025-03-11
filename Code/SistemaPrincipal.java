import java.util.Scanner;

public class SistemaPrincipal {
    private static Scanner scanner = new Scanner(System.in);
    private static GerenciadorMatricula gerenciadorMatricula = new GerenciadorMatricula();
    private static GerenciadorDisciplina gerenciadorDisciplina = new GerenciadorDisciplina();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nSistema de Matrícula");
            System.out.println("1. Adicionar disciplina");
            System.out.println("2. Listar disciplinas");
            System.out.println("3. Matricular aluno em disciplina");
            System.out.println("4. Listar alunos de uma disciplina");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarDisciplina();
                    break;
                case 2:
                    listarDisciplinas();
                    break;
                case 3:
                    matricularAluno();
                    break;
                case 4:
                    listarAlunosDisciplina();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void adicionarDisciplina() {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Créditos: ");
        int creditos = scanner.nextInt();
        scanner.nextLine();
        Disciplina disciplina = new Disciplina(nome, creditos);
        gerenciadorDisciplina.adicionarDisciplina(disciplina);
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void listarDisciplinas() {
        for (Disciplina disciplina : gerenciadorDisciplina.listarDisciplinas()) {
            System.out.println("- " + disciplina.getNome());
        }
    }

    private static void matricularAluno() {
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : gerenciadorDisciplina.listarDisciplinas()) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplina = d;
                break;
            }
        }

        if (disciplina != null) {
            Aluno aluno = new Aluno(nomeAluno);
            gerenciadorMatricula.matricularAluno(aluno, disciplina);
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void listarAlunosDisciplina() {
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        Disciplina disciplina = null;
        for (Disciplina d : gerenciadorDisciplina.listarDisciplinas()) {
            if (d.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplina = d;
                break;
            }
        }

        if (disciplina != null) {
            System.out.println("Alunos matriculados em " + disciplina.getNome() + ":");
            for (Aluno aluno : gerenciadorMatricula.alunosMatriculados(disciplina)) {
                System.out.println("- " + aluno.getMatricula());
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }
}
