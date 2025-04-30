import java.util.List;

class Professor  {

	private String departamento;

	private Usuario usuario;

	public Professor(String departamento, Usuario usuario) {

		this.departamento = departamento;
		this.usuario = usuario;
	}

	public List<Aluno> consultarAlunosMatriculados(Disciplina disciplina) {

		if (disciplina.equals(disciplina)){
			return disciplina.getAlunosMatriculados();
		}
		else {
			return null;
		}

	}



	public boolean validarLogin(String login, String senha) {

		return usuario.validarLogin(login, senha);
	}
}
