package sgrfUsuarios;

public class Pesquisador extends Usuario {

	private String tipo = "Pesquisador";
	private String recursoAssociado;
	
	public Pesquisador(String nome, String senha, String email) {
		super(nome, senha, email);

	}

	public String getTipo() {
		return tipo;
	}
	
	public String getRecursoAssociado() {
		return recursoAssociado;
	}

	public void setRecursoAssociado(String recursoAssociado) {
		this.recursoAssociado = recursoAssociado;
	}

}
