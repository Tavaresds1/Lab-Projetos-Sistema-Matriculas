import java.util.List;

class Disciplina {

	private String nome;

	private int creditos;

	private boolean ativa;

	static final int maxAluno = 60;

	static final int minAluno = 3;

	private List<Aluno> alunosMatriculados;

	private Professor professor;

	private Aluno[] aluno;

	public Disciplina(String nome, int creditos, Professor professor) {

	}

	public boolean matricularAluno(Aluno aluno) {
		return false;
	}

	private boolean verificarAtivacao() {
		return false;
	}

	public List<Aluno> getAlunosMatriculados() {
		return null;
	}

}
