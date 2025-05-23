import java.util.ArrayList;
import java.util.List;

class Disciplina {

    protected String nome;
    protected boolean ativa;
    protected static int creditos;
    protected static final int maxAluno = 60;
    protected static final int minAluno = 3;
    protected List<Aluno> alunosMatriculados;
    private Professor professor;

    public Disciplina(String nome, int creditos, Professor professor) {
        this.nome = nome;
        this.creditos = creditos;
        this.professor = professor;
        this.alunosMatriculados = new ArrayList<>();
        this.ativa = false;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (alunosMatriculados.size() < maxAluno) {
            alunosMatriculados.add(aluno);
            verificarAtivacao();
            return true;
        }
        return false;
    }

    private void verificarAtivacao() {
        if (alunosMatriculados.size() >= minAluno) {
            ativa = true;
        } else {
            ativa = false;
        }
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public static int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
