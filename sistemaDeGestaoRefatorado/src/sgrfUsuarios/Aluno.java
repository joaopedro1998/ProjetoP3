package sgrfUsuarios;

public class Aluno extends Usuario {

	private String tipo = "Aluno";
	private String tipoDoAluno;

	public Aluno(String nome, String senha, String email, String tipoDoAluno) {
		super(nome, senha, email);
		this.tipoDoAluno = tipoDoAluno;
	}

	public String getTipoDoAluno() {
		return tipoDoAluno;
	}

	public void setTipoDoAluno(String tipoDoAluno) {
		this.tipoDoAluno = tipoDoAluno;
	}

	public String getTipo() {
		return tipo;
	}
}
