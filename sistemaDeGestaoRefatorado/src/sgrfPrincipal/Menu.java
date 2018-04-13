package sgrfPrincipal;

import java.util.ArrayList;
import java.util.Scanner;

import sgrfRecursos.Recursos;
import sgrfUsuarios.Usuario;

public class Menu {
	ArrayList<String> respostas = new ArrayList<String>();
	int leitor;
	Scanner input = new Scanner(System.in);
	
	public Main.status inicio(){
		System.out.println("[1]Fazer login");
		System.out.println("[2]Se cadastrar");
		System.out.println("[0]Sair");
		leitor = input.nextInt();
		switch(leitor) {
			case 1:
				return Main.status.LOGIN;
			case 2:
				return Main.status.CADASTRO;
			case 0:
				return Main.status.FINALIZADO;
			default:
				System.out.println("Esse comando nao existe tente novamente!");
				return Main.status.INICIO;
			}
		
	}

	public void login(){
		System.out.println("Digite seu email:");
		respostas.add(0,input.next());
		System.out.println("Digite sua senha:");
		respostas.add(1, input.next());
		
	}

	public void cadastro(){
		System.out.println("Digite:");
		System.out.println("Seu nome:");
		input = new Scanner(System.in);
		respostas.add(0,input.nextLine());
		System.out.println("Sua senha:");
		respostas.add(1,input.next());
		System.out.println("Seu email:");
		respostas.add(2,input.next());
		System.out.println("Qual opcao voce se enquadra:");
		System.out.println("[1]Professor");
		System.out.println("[2]Pesquisador");
		System.out.println("[3]Aluno Graduacao");
		System.out.println("[4]Aluno Mestrado");
		System.out.println("[5]Aluno Doutorado");
		respostas.add(3,input.next());
	}
	
	public int opcao() {
		System.out.println("[1]Sim");
		System.out.println("[2]Nao");
		return input.nextInt();
	}

	public Main.status menuInicialADM(){
		System.out.println("Escolha uma das seguintes opcoes:");
		System.out.println("[1]Consultar um usuario");
		System.out.println("[2]Consultar um recurso");
		System.out.println("[3]Visualizar Relatorio do Sistema");
		System.out.println("[4]Validar Pedidos de Alocacao");
		System.out.println("[5]Alterar estado de um recurso");
		System.out.println("[0]Sair");
		leitor = input.nextInt();
		
		switch(leitor) {
			case 1:
				return Main.status.CONSULTAUSUARIO;
			case 2:
				return Main.status.CONSULTARECURSO;
			case 3:
				return Main.status.RELATORIO;
			case 4:
				return Main.status.VALIDAR;
			case 5:
				return Main.status.ALTERARESTADO;
			case 0:
				System.out.println("Volte sempre!");
				return Main.status.INICIO;
			default:
				System.out.println("Comando invalido");
				return Main.status.MENUADM;
				
		}
		
		
	}

	public Main.status menuInicialProfessor(){
		System.out.println("Escolha uma das seguintes opcoes:");
		System.out.println("[1]Consultar um usuario");
		System.out.println("[2]Consultar um recurso");;
		System.out.println("[3]Alocar um recurso");
		System.out.println("[0]Sair");
		
		leitor = input.nextInt();
		
		switch(leitor) {
			case 1:
				return Main.status.CONSULTAUSUARIO;
			case 2:
				return Main.status.CONSULTARECURSO;
			case 3:
				return Main.status.ALOCAR;
			case 0:
				System.out.println("Volte sempre!");
				return Main.status.INICIO;
			default:
				System.out.println("Comando invalido");
				return Main.status.MENUPROFESSOR;
				
		}
		
	}

	public Main.status menuInicialAluno(){
		System.out.println("Escolha uma das seguintes opcoes:");
		System.out.println("[1]Consultar um usuario");
		System.out.println("[2]Consultar um recurso");
		System.out.println("[0]Sair");
		leitor = input.nextInt();
		switch(leitor) {
			case 1:
				return Main.status.CONSULTAUSUARIO;
			case 2:
				return Main.status.CONSULTARECURSO;
			case 0:
				System.out.println("Volte sempre!");
				return Main.status.INICIO;
			default:
				System.out.println("Comando invalido");
				return Main.status.MENUALUNO;
				
		}
	}

	public String consultarUsuario(){
		System.out.println("Digite o nome do usuario a ser consultado:");
		input = new Scanner(System.in);
		return input.nextLine();
	}

	public int consultarRecurso(){
		System.out.println("Escolha uma opcao de recurso a ser consultado:");
		System.out.println("[1]Projetor");
		System.out.println("[2]Sala de aula");
		System.out.println("[3]Auditorio");
		System.out.println("[4]Laboratorio");
		
		return input.nextInt();
	}
	
	public void alterarEstado(ArrayList<Recursos> recursos){
		System.out.println("Escolha uma opcao de recurso para alterar o seu estado:");
		System.out.println("[1]Projetor");
		System.out.println("[2]Sala de aula");
		System.out.println("[3]Auditorio");
		System.out.println("[4]Laboratorio");
		leitor = input.nextInt();
		System.out.println("Recurso escolhido: "+ recursos.get(leitor-1).getNome());
		System.out.println("Estado de alocacao: "+ recursos.get(leitor-1).getEstadoDeAlocacao());
		System.out.println("Para qual estado voce gostaria de alterar o recurso escolhido?");
		input = new Scanner(System.in);
		recursos.get(leitor - 1).setEstadoDeAlocacao(input.nextLine());
		
	}
	public int alocarRecursos() {
		System.out.println("Qual dos seguintes recursos voce gostaria de alocar?");
		System.out.println("[1]Projetor");
		System.out.println("[2]Sala de aula");
		System.out.println("[3]Auditorio");
		System.out.println("[4]Laboratorio");
		leitor = input.nextInt();
		System.out.println("Qual o motivo da alocacao?");
		input = new Scanner(System.in);
		respostas.add(0,input.nextLine());
		System.out.println("Qual o titulo?");
		input = new Scanner(System.in);
		respostas.add(1,input.nextLine());
		System.out.println("Faca uma breve descricao do que voce fara:");
		input = new Scanner(System.in);
		respostas.add(2,input.nextLine());
		System.out.println("Qual material sera utilizado?");
		input = new Scanner(System.in);
		respostas.add(3,input.nextLine());
		return leitor;
	}

	public void relatorio(int numeroDeUsuarios, ArrayList<Recursos> recursos) {
		System.out.println("Numero de Usuarios: " + numeroDeUsuarios);
		int rDesalocados = 0, rEmProcesso = 0, rAlocados = 0, rEmAndamento = 0, rConcluidos = 0,
				rLaboratorio = 0, rApresentacao = 0, rAula = 0;
		for(Recursos r: recursos) {
			switch(r.getEstadoDeAlocacao()){
				case "Desalocado":
					++rDesalocados;
					break;
				case "Em Processo de alocacao":
					++rEmProcesso;
					break;
				case "Alocado":
					++rAlocados;
					break;
				case "Em Andamento":
					++rEmAndamento;
					break;
				case "Concluido":
					++rConcluidos;
					break;
				default:
			}
			switch(r.getMotivo()) {
				case "Laboratorio":
					++rLaboratorio;
					break;
				case "Apresentacao":
					++rApresentacao;
					break;
				case "Aula Tradicional":
					++rAula;
					break;
				default:
					
			}
		}
		System.out.println("Numero de recursos Desalocados: "+rDesalocados);
		System.out.println("Numero de recursos em processo de alocacao: " + rEmProcesso);
		System.out.println("Numero de recursos alocados: " + rAlocados);
		System.out.println("Numero de recursos em andamento: " + rEmAndamento);
		System.out.println("Numero de recursos concluídos: " + rConcluidos);
		System.out.println("Numero Total de alocacoes: " + (4-rDesalocados));
		System.out.println("Numero de Atividades de Laboratorio: " + rLaboratorio);
		System.out.println("Numero de Atividades de Apresentacao: " + rApresentacao);
		System.out.println("Numero de Atividades de Aula Tradicional: " + rAula);
		
	}
}
