package sgrfUsuarios;

public class Administrador extends Usuario{
	private String senhaAdm = "123456789";
	private String tipo = "Administrador";

	public Administrador(String nome, String senha, String email) {
		super(nome, senha, email);

	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

	public String getTipo() {
		return tipo;
	}


}
