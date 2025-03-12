import java.util.Date;
import java.util.List;

class SistemaMatriculas {

    private Aluno[] aluno;
    private Professor[] professor;
    private Date date;
    private Curso[] curso;
    private SistemaCobranca sistemaCobranca;
    private Date inicioPeriodoMatricula;
    private Date fimPeriodoMatricula;
    private GerenciadorDisciplina gerenciadorDisciplina;
    private GerenciadorMatricula gerenciadorMatricula;

    public SistemaMatriculas(Date inicioPeriodoMatricula, Date fimPeriodoMatricula) {
        this.sistemaCobranca = new SistemaCobranca();
        this.inicioPeriodoMatricula = inicioPeriodoMatricula;
        this.fimPeriodoMatricula = fimPeriodoMatricula;
        this.gerenciadorDisciplina = new GerenciadorDisciplina();
        this.gerenciadorMatricula = new GerenciadorMatricula(gerenciadorDisciplina.listarDisciplinas());
        this.aluno = new Aluno[100]; 
        this.professor = new Professor[50];
        this.curso = new Curso[20]; 
    }

    public void notificarSistemaCobranças(Aluno aluno) {
        double valor = sistemaCobranca.cobrarAluno(aluno);
        System.out.println("Cobrança gerada para o aluno " + aluno.getMatricula() + ": " + valor);
    }

    public boolean isPeriodoMatricula() {
        Date hoje = new Date();
        return hoje.after(inicioPeriodoMatricula) && hoje.before(fimPeriodoMatricula);
    }

    public GerenciadorDisciplina getGerenciadorDisciplina() {
        return gerenciadorDisciplina;
    }

    public GerenciadorMatricula getGerenciadorMatricula() {
        return gerenciadorMatricula;
    }

    public boolean matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (isPeriodoMatricula()) {
            if (disciplina instanceof DisciplinaObrigatoria) {
                if (aluno.getDisciplinasMatriculadasObrigatoria().size() < 4) {
                    boolean matriculado = gerenciadorMatricula.matricularAluno(aluno, disciplina);
                    if (matriculado) {
                        aluno.matricularDisciplinaObrigatoria((DisciplinaObrigatoria)disciplina);
                        notificarSistemaCobranças(aluno);
                        return true;
                    }
                } else {
                    System.out.println("Aluno já atingiu o limite de disciplinas obrigatórias.");
                    return false;
                }
            } else if (disciplina instanceof DisciplinaOptativa) {
                if (aluno.getDisciplinasMatriculadasOptativa().size() < 2) {
                    boolean matriculado = gerenciadorMatricula.matricularAluno(aluno, disciplina);
                    if (matriculado) {
                        aluno.matricularDisciplinaOptativa((DisciplinaOptativa)disciplina);
                        notificarSistemaCobranças(aluno);
                        return true;
                    }
                } else {
                    System.out.println("Aluno já atingiu o limite de disciplinas optativas.");
                    return false;
                }
            }
            return false;
        } else {
            System.out.println("Fora do período de matrícula.");
            return false;
        }
    }

    public void cancelarMatriculaAluno(Aluno aluno, Disciplina disciplina) {
        if (isPeriodoMatricula()) {
            gerenciadorMatricula.cancelarMatriculaAluno(aluno, disciplina);
            if (disciplina instanceof DisciplinaObrigatoria) {
                aluno.cancelarMatriculaDisciplinaObrigatoria((DisciplinaObrigatoria)disciplina);
            } else if (disciplina instanceof DisciplinaOptativa) {
                aluno.cancelarMatriculaDisciplinaOptativa((DisciplinaOptativa)disciplina);
            }
        } else {
            System.out.println("Fora do período de matrícula.");
        }
    }

    public void verificarDisciplinasAtivas() {
        List<Disciplina> disciplinas = gerenciadorDisciplina.listarDisciplinas();
        for (Disciplina disciplina : disciplinas) {
            if (!disciplina.isAtiva()) {
                System.out.println("Disciplina " + disciplina.getNome() + " foi cancelada por falta de alunos.");
            }
        }
    }

    public void adicionarAluno(Aluno aluno, int index) {
        if (index >= 0 && index < this.aluno.length) {
            this.aluno[index] = aluno;
        } else {
            System.out.println("Índice inválido para adicionar aluno.");
        }
    }

    public void adicionarProfessor(Professor professor, int index) {
        if (index >= 0 && index < this.professor.length) {
            this.professor[index] = professor;
        } else {
            System.out.println("Índice inválido para adicionar professor.");
        }
    }

    public void adicionarCurso(Curso curso, int index) {
        if (index >= 0 && index < this.curso.length) {
            this.curso[index] = curso;
        } else {
            System.out.println("Índice inválido para adicionar curso.");
        }
    }
}
