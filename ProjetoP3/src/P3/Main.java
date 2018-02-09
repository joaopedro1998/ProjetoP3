package P3;
import java.util.*;


public class Main {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int flag = 100,retorno,aux, user_id = -1,aux2,alocador;	
		Users U = new Users();
		Resources r = new Resources();
		
		while(flag!=0)
		{
			if(flag == 100)
			{
				System.out.println("[1]Login");
				System.out.println("[2]Cadastramento");
				System.out.println("[0]Sair");
				flag = input.nextInt();
				
			}
			if(flag == 1)
			{
				retorno = U.Login();
				if(retorno == -1)
				{
					flag = 100;
					System.out.println("Email ou Senha incorreta!\nVocê Será redirecionado para o Menu Inicial");
				}
				else 
				{
					user_id = retorno;
					flag = U.Type.get(retorno) + 5;
					
				}
				
					
			}
			if(flag == 2)
			{
				U.Cadastro();
				flag = 100;
			}
			if(flag == 5)
			{
				System.out.println("Escolha uma das seguintes opções:");
				System.out.println("[1]Consultar um usuário");
				System.out.println("[2]Consultar um recurso");
				System.out.println("[3]Visualizar Relatório do Sistema");
				System.out.println("[4]Validar Pedidos de Alocação");
				System.out.println("[0]Sair");
				retorno = input.nextInt();
				if(retorno == 0)
					flag = 100;
				else if(retorno == 1)
				{
					aux = U.Consulta();
					if(aux == -1)
					{
						System.out.println("Usuário não encontrado!");
					}
					else
					{
						System.out.println("Primeiro Nome: " + U.FirstName.get(aux));
						System.out.println("Último Nome: " + U.LastName.get(aux));
						System.out.println("Email: " + U.Email.get(aux));
						aux2=r.buscar(aux);
						if(aux2 == -1)
						{
							System.out.println("Nenhum recurso e nem atividade alocada!");
						}
						else
						{
							System.out.println("Recurso Alocado: "+ r.Name.get(aux2));
							System.out.println("Atividade: "+r.Motivo(r.Motivo.get(aux2)));
						}
					}
					
				}					
				else if(retorno == 2)
				{
					aux2 = r.Consulta();
					if(r.Estado.get(aux2).intern() == "Desalocado")
					{
						System.out.println("Este recurso está desalocado!");
					}
					else
					{
						alocador = r.Alocador.get(aux2);
						System.out.println("Dados do Associado:");
						System.out.println("Primeiro Nome: "+U.FirstName.get(alocador));
						System.out.println("Último Nome: "+U.LastName.get(alocador));
						System.out.println("Email: "+U.Email.get(alocador));
						System.out.println("Atividade: "+r.Motivo(aux2));
					}
					
				}
				else if(retorno == 3)
				{
					System.out.println("Número de Usuários: " + U.Email.size());
					System.out.println("Número de recursos Desalocados: "+r.des());
					System.out.println("Número de recursos em processo de alocação: " + r.p_al());
					System.out.println("Número de recursos alocados: " + r.al());
					System.out.println("Número de recursos em andamento: " + r.ea());
					System.out.println("Número de recursos concluídos: " + r.cl());
					System.out.println("Número Total de alocações: " + (4-r.des()));
					System.out.println("Número de Atividades de Laboratório: " + r.lab());
					System.out.println("Número de Atividades de Apresentação: " + r.ap());
					System.out.println("Número de Atividades de Aula Tradicional: " + r.a_t());
				}
				else if(retorno == 4)
				{
					r.validar();
				}	
				
			}
			if(flag == 6)
			{
				System.out.println("Escolha uma das seguintes opções:");
				System.out.println("[1]Consultar um usuário");
				System.out.println("[2]Consultar um recurso");;
				System.out.println("[3]Alocar um recurso");
				System.out.println("[0]Sair");
				retorno = input.nextInt();
				if(retorno == 0)
					flag = 100;
				else if(retorno == 3)
					r.alocar(user_id,flag);
				else if(retorno == 1)
				{
					aux = U.Consulta();
					if(aux == -1)
					{
						System.out.println("Usuário não encontrado!");
					}
					else
					{
						System.out.println("Primeiro Nome: " + U.FirstName.get(aux));
						System.out.println("Último Nome: " + U.LastName.get(aux));
						System.out.println("Email: " + U.Email.get(aux));
						aux2=r.buscar(aux);
						if(aux2 == -1)
						{
							System.out.println("Nenhum recurso e nem atividade alocada!");
						}
						else
						{
							System.out.println("Recurso Alocado: "+ r.Name.get(aux2));
							System.out.println("Atividade: "+r.Motivo(r.Motivo.get(aux2)));
						}
					}
					
				}					
				else if(retorno == 2)
				{
					aux2 = r.Consulta();
					if(r.Estado.get(aux2).intern() == "Desalocado")
					{
						System.out.println("Este recurso está desalocado!");
					}
					else
					{
						alocador = r.Alocador.get(aux2);
						System.out.println("Dados do Associado:");
						System.out.println("Primeiro Nome: "+U.FirstName.get(alocador));
						System.out.println("Último Nome: "+U.LastName.get(alocador));
						System.out.println("Email: "+U.Email.get(alocador));
						System.out.println("Atividade: "+r.Motivo(aux2));
					}
					
				}
					
				
			}
			if(flag == 7)
			{
				System.out.println("Escolha uma das seguintes opções:");
				System.out.println("[1]Consultar um usuário");
				System.out.println("[2]Consultar um recurso");				
				System.out.println("[3]Alocar um recurso");
				System.out.println("[0]Sair");
				retorno = input.nextInt();
				if(retorno == 0)
					flag = 100;
				else if(retorno == 3)
					r.alocar(user_id,flag);
				else if(retorno == 1)
				{
					aux = U.Consulta();
					if(aux == -1)
					{
						System.out.println("Usuário não encontrado!");
					}
					else
					{
						System.out.println("Primeiro Nome: " + U.FirstName.get(aux));
						System.out.println("Último Nome: " + U.LastName.get(aux));
						System.out.println("Email: " + U.Email.get(aux));
						aux2=r.buscar(aux);
						if(aux2 == -1)
						{
							System.out.println("Nenhum recurso e nem atividade alocada!");
						}
						else
						{
							System.out.println("Recurso Alocado: "+ r.Name.get(aux2));
							System.out.println("Atividade: "+r.Motivo(r.Motivo.get(aux2)));
						}
					}
					
				}					
				else if(retorno == 2)
				{
					aux2 = r.Consulta();
					if(r.Estado.get(aux2).intern() == "Desalocado")
					{
						System.out.println("Este recurso está desalocado!");
					}
					else
					{
						alocador = r.Alocador.get(aux2);
						System.out.println("Dados do Associado:");
						System.out.println("Primeiro Nome: "+U.FirstName.get(alocador));
						System.out.println("Último Nome: "+U.LastName.get(alocador));
						System.out.println("Email: "+U.Email.get(alocador));
						System.out.println("Atividade: "+r.Motivo(aux2));
					}
					
				}
			}
			if(flag >= 8 && flag <=10)
			{
				System.out.println("Escolha uma das seguintes opções:");
				System.out.println("[1]Consultar um usuário");
				System.out.println("[2]Consultar um recurso");	
				System.out.println("[0]Sair");
				retorno = input.nextInt();
				if(retorno == 0)
					flag = 100;
				else if(retorno == 1)
				{
					aux = U.Consulta();
					if(aux == -1)
					{
						System.out.println("Usuário não encontrado!");
					}
					else
					{
						System.out.println("Primeiro Nome: " + U.FirstName.get(aux));
						System.out.println("Último Nome: " + U.LastName.get(aux));
						System.out.println("Email: " + U.Email.get(aux));
						aux2=r.buscar(aux);
						if(aux2 == -1)
						{
							System.out.println("Nenhum recurso e nem atividade alocada!");
						}
						else
						{
							System.out.println("Recurso Alocado: "+ r.Name.get(aux2));
							System.out.println("Atividade: "+r.Motivo(r.Motivo.get(aux2)));
						}
					}
					
				}					
				else if(retorno == 2)
				{
					aux2 = r.Consulta();
					if(r.Estado.get(aux2).intern() == "Desalocado")
					{
						System.out.println("Este recurso está desalocado!");
					}
					else
					{
						alocador = r.Alocador.get(aux2);
						System.out.println("Dados do Associado:");
						System.out.println("Primeiro Nome: "+U.FirstName.get(alocador));
						System.out.println("Último Nome: "+U.LastName.get(alocador));
						System.out.println("Email: "+U.Email.get(alocador));
						System.out.println("Atividade: "+r.Motivo(aux2));
					}
					
				}
			}
			
					
		}

	}

}