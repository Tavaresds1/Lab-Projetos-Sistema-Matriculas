import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar usuários
        Usuario usuarioProf = new Usuario("prof1", "senha123");
        Professor professor = new Professor("Computação", usuarioProf);

        // Criar curso
        Curso curso = new Curso("Engenharia de Software", 240);

        // Criar disciplinas
        DisciplinaObrigatoria poo = new DisciplinaObrigatoria("Programação Orientada a Objetos", 4, professor);
        DisciplinaObrigatoria bd = new DisciplinaObrigatoria("Banco de Dados", 4, professor);
        DisciplinaOptativa redes = new DisciplinaOptativa("Redes de Computadores", 4, professor);

        // Adicionar disciplinas ao curso
        curso.adicionarDisciplinaObrigatoria(poo);
        curso.adicionarDisciplinaObrigatoria(bd);
        curso.adicionarDisciplinaOptativa(redes);

        // Criar alunos
        Usuario usuarioAluno1 = new Usuario("aluno1", "senha456");
        Aluno aluno1 = new Aluno("2023001", usuarioAluno1);

        Usuario usuarioAluno2 = new Usuario("aluno2", "senha789");
        Aluno aluno2 = new Aluno("2023002", usuarioAluno2);

        Usuario usuarioAluno3 = new Usuario("aluno3", "senha101");
        Aluno aluno3 = new Aluno("2023003", usuarioAluno3);

        Usuario usuarioAluno4 = new Usuario("aluno4", "senha102");
        Aluno aluno4 = new Aluno("2023004", usuarioAluno4);

        Usuario usuarioAluno5 = new Usuario("aluno5", "senha103");
        Aluno aluno5 = new Aluno("2023005", usuarioAluno4);

        // Criar gerenciador de matrículas
        GerenciadorMatricula gerenciadorMatricula = new GerenciadorMatricula();

        // Matricular alunos
        gerenciadorMatricula.matricularAluno(aluno1, poo);
        gerenciadorMatricula.matricularAluno(aluno1, bd);
        gerenciadorMatricula.matricularAluno(aluno2, poo);
        gerenciadorMatricula.matricularAluno(aluno3, redes);
        gerenciadorMatricula.matricularAluno(aluno4, bd);
        gerenciadorMatricula.matricularAluno(aluno5, poo);

        // Listar alunos matriculados em uma disciplina antes do cancelamento
        List<Aluno> alunosMatriculadosPOO = gerenciadorMatricula.alunosMatriculados(poo);
        System.out.println("Alunos matriculados em POO antes do cancelamento: " + alunosMatriculadosPOO.size());

        // Cancelar matrícula
        gerenciadorMatricula.cancelarMatriculaAluno(aluno5, poo);

        // Listar alunos matriculados em uma disciplina depois do cancelamento
        alunosMatriculadosPOO = gerenciadorMatricula.alunosMatriculados(poo);
        System.out.println("Alunos matriculados em POO depois do cancelamento: " + alunosMatriculadosPOO.size());

        // Verificar disciplinas do curso
        List<Disciplina> disciplinasCurso = curso.getDisciplinas();
        System.out.println("Disciplinas do curso: " + disciplinasCurso.size());
        System.out.println("Lista de disciplinas do curso:" + disciplinasCurso);
    }
}