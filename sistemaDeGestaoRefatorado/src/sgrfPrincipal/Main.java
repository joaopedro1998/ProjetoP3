package sgrfPrincipal;

import java.util.ArrayList;
import java.util.Scanner;

import sgrfRecursos.*;
import sgrfUsuarios.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();
		ArrayList<Recursos> recursos = new ArrayList<Recursos>();
		
		Scanner input = new Scanner(System.in);
		
		Usuario usuarioLogado = null;
		
		Menu menu = new Menu();
		
		Auditorio auditorio = new Auditorio("vazio","Desalocado","vazio","vazio","vazio","vazio");
		Laboratorio laboratorio = new Laboratorio("vazio","Desalocado","vazio","vazio","vazio","vazio");
		Sala sala = new Sala("vazio","Desalocado","vazio","vazio","vazio","vazio"); 
		Projetor projetor = new Projetor("vazio","Desalocado","vazio","vazio","vazio","vazio");
		
		recursos.add(projetor);
		recursos.add(sala);
		recursos.add(auditorio);
		recursos.add(laboratorio);
		
		Administrador administrador = new Administrador("admin","admin","admin");
		Aluno aluno;
		Pesquisador pesquisador;
		Professor professor;
		
		usuario.add(administrador);
		
		int flag2;
		status flag = status.INICIO;
		status flagAnterior = null;
		
		String respostaString;
		int escolha;
		
		while(flag != status.FINALIZADO) {
		
			switch(flag) {
				case INICIO:
					flag = menu.inicio();
					break;
				case LOGIN:
					menu.login();
					flag2 = 0;
					for(Usuario u: usuario) {
						if(u.getEmail().equals(menu.respostas.get(0))) {
							if(u.getSenha().equals(menu.respostas.get(1))) {
								System.out.println("Login efetuado com sucesso!");
								System.out.println("Seja bem vindo "+ u.getNome());
								usuarioLogado = u;
								flag2 = 1;
								if(u.getClass() == Aluno.class) {
									flag = status.MENUALUNO;
									break;
								}
								else if(u.getClass() == Professor.class || u.getClass() == Pesquisador.class) {
									flag = status.MENUPROFESSOR;
									break;
								}
								else{
									flag = status.MENUADM;
									break;
								}
							}
						}
						
					}
					if(flag2 == 0)
					{
						System.out.println("Usuario nao encontrado!");
						flag = status.INICIO;
					}
					break;
				case CADASTRO:
					menu.cadastro();
					switch(menu.respostas.get(3)) {
						case "0": 
							professor = new Professor(menu.respostas.get(0),menu.respostas.get(1),menu.respostas.get(2));
							usuario.add(professor);
							break;
						case "1": 
							pesquisador = new Pesquisador(menu.respostas.get(0),menu.respostas.get(1),menu.respostas.get(2));
							usuario.add(pesquisador);
							break;
						case "2": 
							aluno = new Aluno(menu.respostas.get(0),menu.respostas.get(1),menu.respostas.get(2),"Graduacao");
							usuario.add(aluno);
							break;
						case "3": 
							aluno = new Aluno(menu.respostas.get(0),menu.respostas.get(1),menu.respostas.get(2),"Mestrado");
							usuario.add(aluno);
							break;
						case "4": 
							aluno = new Aluno(menu.respostas.get(0),menu.respostas.get(1),menu.respostas.get(2),"Doutorado");
							usuario.add(aluno);
							break;
						
						
					}
					System.out.println("Cadastro Efetuado!");
					flag = status.INICIO;
					break;
				case MENUALUNO:
					flagAnterior = flag;
					flag = menu.menuInicialAluno();
					break;
				case MENUPROFESSOR:
					flagAnterior = flag;
					flag = menu.menuInicialProfessor();
					break;
				case MENUADM:
					flagAnterior = flag;
					flag = menu.menuInicialADM();
					break;
				case VALIDAR:
					System.out.println("Os seguintes recursos estao para validacao:");
					for(Recursos r: recursos) {
						if(!r.getAlocador().equals("vazio") && r.getEstadoDeAlocacao().equals("Desalocado")) {
							System.out.println("Esses sao os dados do recurso a ser validado!");
							System.out.println("Recurso escolhido: "+ r.getNome());
							System.out.println("Alocado por: "+ r.getAlocador());
							System.out.println("Motivo de alocacao: "+ r.getMotivo());
							System.out.println("Descricao da atividade: "+ r.getDescricao());
							System.out.println("Material utilizado: "+ r.getMaterial());
							System.out.println("Titulo: "+ r.getTitulo());
							if(r.getNomeDosParticipantes() != null) {
								System.out.println("Lista de participantes:");
								for(String s: r.getNomeDosParticipantes()) {
									System.out.println(s);
								}
							}
							else {
								System.out.println("Nao ha participantes cadastrados");
							}
							System.out.println("Voce gostaria de validar a alocacao?");
							if(menu.opcao() == 1) {
								r.setEstadoDeAlocacao("Em processo de alocacao");
							}
						}
					}
					flag = flagAnterior;
					break;
				case ALTERARESTADO:
					menu.alterarEstado(recursos);
					flag = flagAnterior;
					break;
				case RELATORIO:
					menu.relatorio(usuario.size(),recursos);
					flag = flagAnterior;
					break;
				case CONSULTAUSUARIO:
					respostaString = menu.consultarUsuario();
					for(Usuario u: usuario){
						if(u.getNome().equals(respostaString)) {
							System.out.println("Nome:" + u.getNome());
							System.out.println("Email:" + u.getEmail());
							if(u.getClass() == Aluno.class) {
								System.out.println("Grupo pertencente: Aluno");
							}
							else if(u.getClass() == Professor.class) {
								System.out.println("Grupo pertencente: Professor");
							}
							else if(u.getClass() == Pesquisador.class) {
								System.out.println("Grupo pertencente: Pesquisador");
							}
						}
					}
					flag = flagAnterior;
					break;
				case CONSULTARECURSO:
					escolha = menu.consultarRecurso();
					System.out.println("Recurso escolhido: "+ recursos.get(escolha-1).getNome());
					System.out.println("Alocado por: "+ recursos.get(escolha-1).getAlocador());
					System.out.println("Motivo de alocacao: "+ recursos.get(escolha-1).getMotivo());
					System.out.println("Descricao da atividade: "+ recursos.get(escolha-1).getDescricao());
					System.out.println("Material utilizado: "+ recursos.get(escolha-1).getMaterial());
					System.out.println("Estado de alocacao: "+ recursos.get(escolha-1).getEstadoDeAlocacao());
					System.out.println("Titulo: "+ recursos.get(escolha-1).getTitulo());
					if(recursos.get(escolha-1).getNomeDosParticipantes() != null) {
						System.out.println("Lista de participantes:");
						for(String s: recursos.get(escolha-1).getNomeDosParticipantes()) {
							System.out.println(s);
						}
					}
					else {
						System.out.println("Nao ha participantes cadastrados");
					}
					
					flag = flagAnterior;
					break;
				case ALOCAR:
					escolha = menu.alocarRecursos();
					if(escolha >= 1 && escolha <= 4)
					{
						recursos.get(escolha+1).setAlocador(usuarioLogado.getNome());
						recursos.get(escolha+1).setMotivo(menu.respostas.get(0));
						recursos.get(escolha+1).setTitulo(menu.respostas.get(1));
						recursos.get(escolha+1).setDescricao(menu.respostas.get(2));
						recursos.get(escolha+1).setMaterial(menu.respostas.get(3));
						System.out.println("Voce gostaria de adicionar algum paricipante?");
						while(menu.opcao() == 1) {
							
							System.out.println("Digite o nome do participante:");
							input = new Scanner(System.in);
							recursos.get(escolha+1).setNomeDosParticipantes(input.nextLine());
							System.out.println("Voce gostaria de adicionar mais algum paricipante?");
						}
						if(usuarioLogado.getClass() == Professor.class)
							((Professor) usuarioLogado).setRecursoAssociado(recursos.get(escolha+1).getNome());
						else
							((Pesquisador) usuarioLogado).setRecursoAssociado(recursos.get(escolha+1).getNome());
					}
					else
						System.out.println("Opcao invalida!");
					flag = flagAnterior;
					break;
				default:
					flag = status.INICIO;
				
		
			}
		}

	}
	
	public enum status{
		INICIO,
		LOGIN,
		MENUADM,
		MENUALUNO,
		MENUPROFESSOR,
		CADASTRO,
		FINALIZADO, 
		ALOCAR, 
		CONSULTARECURSO, 
		CONSULTAUSUARIO, 
		VALIDAR, 
		ALTERARESTADO,
		RELATORIO;
	}

}
