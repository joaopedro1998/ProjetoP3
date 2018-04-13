package sgrfUsuarios;

public class Professor extends Usuario{

	private String recursoAssociado;
	private String tipo = "Professor";

	public Professor(String nome, String senha, String email) {
		super(nome, senha, email);
		// TODO Auto-generated constructor stub
	}

	public String getRecursoAssociado() {
		return recursoAssociado;
	}

	public void setRecursoAssociado(String recursoAssociado) {
		this.recursoAssociado = recursoAssociado;
	}

	public String getTipo() {
		return tipo;
	}

}
