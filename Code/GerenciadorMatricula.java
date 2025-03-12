import java.util.List;

class GerenciadorMatricula {

    private List<Disciplina> disciplinas;

    public GerenciadorMatricula(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public GerenciadorMatricula() {
    }

    public boolean matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (disciplina.matricularAluno(aluno)) {
            return true;
        }
        return false;
    }
    
    public void cancelarMatriculaAluno(Aluno aluno, Disciplina disciplina) {
        if (disciplina.getAlunosMatriculados().contains(aluno)) {
            disciplina.getAlunosMatriculados().remove(aluno);
            disciplina.verificarAtivacao();
        }
    }
    
    public List<Aluno> alunosMatriculados(Disciplina disciplina) {
        return disciplina.getAlunosMatriculados();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}