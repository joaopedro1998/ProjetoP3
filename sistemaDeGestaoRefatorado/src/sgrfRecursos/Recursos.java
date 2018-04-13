package sgrfRecursos;
import java.util.ArrayList;

public class Recursos {

	private String nome;
	private String alocador;
	private String estadoDeAlocacao;
	private String motivo;
	private String titulo;
	private String descricao;
	private String material;
	private ArrayList<String> nomeDosParticipantes = new ArrayList<String>();


	public Recursos(String nome, String alocador, String estadoDeAlocacao,
			String motivo, String titulo, String descricao, String material) {
		this.nome = nome;
		this.alocador = alocador;
		this.estadoDeAlocacao = estadoDeAlocacao;
		this.motivo = motivo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.material = material;
		this.nomeDosParticipantes = nomeDosParticipantes;
	}

	public String getAlocador() {
		return alocador;
	}
	public String getEstadoDeAlocacao() {
		return estadoDeAlocacao;
	}
	public String getMotivo() {
		return motivo;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getMaterial() {
		return material;
	}
	public ArrayList<String> getNomeDosParticipantes() {
		return nomeDosParticipantes;
	}
	public void setAlocador(String alocador) {
		this.alocador = alocador;
	}
	public void setEstadoDeAlocacao(String estadoDeAlocacao) {
		this.estadoDeAlocacao = estadoDeAlocacao;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setNomeDosParticipantes(String nome) {
		this.nomeDosParticipantes.add(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




}
