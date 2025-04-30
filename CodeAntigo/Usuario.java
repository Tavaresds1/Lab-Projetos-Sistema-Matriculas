class Usuario implements IUsuario {

	private String login;

	private String senha;

	public Usuario(String login, String senha) {

		this.login = login;
		this.senha = senha;
	}

	public boolean validarLogin(String login, String senha) {

		if (this.login.equals(login) && this.senha.equals(senha)) {
			return true;
		}
		else {
			return false;
		}

	}

}
