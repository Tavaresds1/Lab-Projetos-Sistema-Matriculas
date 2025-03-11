import java.util.List;

public class DisciplinaObrigatoria extends Disciplina {

    public DisciplinaObrigatoria(String nome, int creditos, Professor professor, List<Aluno> alunosMatriculados) {
        super(nome, creditos, professor, alunosMatriculados);
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

}
