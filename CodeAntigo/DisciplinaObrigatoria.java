import java.util.List;

public class DisciplinaObrigatoria extends Disciplina {

    public DisciplinaObrigatoria(String nome, int creditos, Professor professor) {
        super(nome, creditos, professor);
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
    @Override
    public String toString() {
        return "DisciplinaObrigatoria{" +
                "nome='" + nome + '\'' +
                ", creditos=" + creditos+ "}";

    }

}
