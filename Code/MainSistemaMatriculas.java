import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;

public class MainSistemaMatriculas {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date inicio = sdf.parse("01/02/2023");
            Date fim = sdf.parse("15/02/2023");
            
            SistemaMatriculas sistema = new SistemaMatriculas(inicio, fim);
            
            // Criar usuários
            Usuario usuarioProf = new Usuario("prof1", "senha123");
            Professor professor = new Professor("Computação", usuarioProf);
            
            // Criar curso
            Curso curso = new Curso("Engenharia de Software", 240);
            
            // Criar disciplinas
            DisciplinaObrigatoria poo = new DisciplinaObrigatoria("Programação Orientada a Objetos", 4, professor);
            DisciplinaObrigatoria bd = new DisciplinaObrigatoria("Banco de Dados", 4, professor);
            DisciplinaOptativa redes = new DisciplinaOptativa("Redes de Computadores", 4, professor);
            DisciplinaObrigatoria engSoft = new DisciplinaObrigatoria("Engenharia de Software", 4, professor);
            DisciplinaOptativa ia = new DisciplinaOptativa("Inteligência Artificial", 2, professor);
            DisciplinaObrigatoria mobile = new DisciplinaObrigatoria("Desenvolvimento Mobile", 2, professor);
            
            // Adicionar disciplinas ao sistema
            sistema.getGerenciadorDisciplina().adicionarDisciplina(poo);
            sistema.getGerenciadorDisciplina().adicionarDisciplina(bd);
            sistema.getGerenciadorDisciplina().adicionarDisciplina(redes);
            sistema.getGerenciadorDisciplina().adicionarDisciplina(engSoft);
            sistema.getGerenciadorDisciplina().adicionarDisciplina(ia);
            sistema.getGerenciadorDisciplina().adicionarDisciplina(mobile);
            
            // Adicionar disciplinas ao curso
            curso.adicionarDisciplinaObrigatoria(poo);
            curso.adicionarDisciplinaObrigatoria(bd);
            curso.adicionarDisciplinaOptativa(redes);
            curso.adicionarDisciplinaObrigatoria(engSoft);
            curso.adicionarDisciplinaOptativa(ia);
            curso.adicionarDisciplinaObrigatoria(mobile);
            
            // Criar alunos
            Usuario usuarioAluno1 = new Usuario("aluno1", "senha456");
            Aluno aluno1 = new Aluno("2023001", usuarioAluno1);
            
            Usuario usuarioAluno2 = new Usuario("aluno2", "senha789");
            Aluno aluno2 = new Aluno("2023002", usuarioAluno2);
            
            // Matricular alunos
            if (sistema.isPeriodoMatricula()) {
                // Matrícula do aluno1
                sistema.matricularAluno(aluno1, poo);
                sistema.matricularAluno(aluno1, bd);
                sistema.matricularAluno(aluno1, redes);
                sistema.matricularAluno(aluno1, ia);
                
                // Matrícula do aluno2
                sistema.matricularAluno(aluno2, poo);
                sistema.matricularAluno(aluno2, bd);
                sistema.matricularAluno(aluno2, mobile);
                
                System.out.println("Alunos matriculados com sucesso!");
                
                // Testar cancelamento de matrícula
                sistema.cancelarMatriculaAluno(aluno1, bd);
                System.out.println("Matrícula de " + aluno1.getMatricula() + " em BD cancelada.");
            } else {
                System.out.println("Fora do período de matrícula");
            }
            
            // Verificar disciplinas ativas
            sistema.verificarDisciplinasAtivas();
            
            // Professor consulta alunos matriculados
            List<Aluno> alunosMatriculados = professor.consultarAlunosMatriculados(poo);
            System.out.println("Alunos matriculados em POO: " + alunosMatriculados.size());
            
            System.out.println("Sistema de Matrículas iniciado com sucesso!");
        } catch (ParseException e) {
            System.out.println("Erro ao processar datas: " + e.getMessage());
        }
    }
}