import java.util.List;

class GerenciadorMatricula {

    private List<Disciplina> disciplinas;

    public GerenciadorMatricula(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public boolean matricularAluno(Aluno aluno, Disciplina disciplina) {
        if (disciplina.matricularAluno(aluno)) {
            return true;
        }
        return false;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}