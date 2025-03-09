import java.util.List;

class Aluno {

	private String matricula;

	private Usuario usuario;

	private List<DisciplinaOptativa> disciplinasMatriculadasOptativa;
	private List<DisciplinaObrigatoria> disciplinasMatriculadasObrigatoria;

	public Aluno(String matricula, Usuario usuario) {

		this.matricula = matricula;
		this.usuario = usuario;
	}

	public void matricularDisciplinaObrigatoria(DisciplinaObrigatoria disciplina) {


		if (disciplinasMatriculadasObrigatoria.size() < 6){
			disciplinasMatriculadasObrigatoria.add(disciplina);
		}
		else{
			System.out.println("Numero maximo de disciplinas obrigatorias atingido");
		}
	}

	public void matricularDisciplinaOptativa(DisciplinaOptativa disciplina) {
          if (disciplinasMatriculadasOptativa.size() < 2){
			disciplinasMatriculadasOptativa.add(disciplina);
		  }
		else {
			System.out.println("Numero maximo de disciplinas optativas atingido");
		}
	}

	public void cancelarMatriculaDisciplinaObrigatoria(DisciplinaObrigatoria disciplina) {

		disciplinasMatriculadasObrigatoria.remove(disciplina);
	}

	public void cancelarMatriculaDisciplinaOptativa(DisciplinaOptativa disciplina) {

		disciplinasMatriculadasOptativa.remove(disciplina);
	}




	public boolean validarLogin(String login, String senha) {

		return usuario.validarLogin(login, senha);
	}


}
