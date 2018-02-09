package P3;
import java.util.*;


public class Resources {
	Scanner input = new Scanner(System.in);
	ArrayList<String> Name = new ArrayList<String>();
	ArrayList<Integer> Alocador = new ArrayList<Integer>();
	ArrayList<String> Estado = new ArrayList<String>();
	ArrayList<Integer> Motivo = new ArrayList<Integer>();
	ArrayList<String> Título = new ArrayList<String>();
	ArrayList<String> Descrição= new ArrayList<String>();
	ArrayList<String> Material = new ArrayList<String>();
	ArrayList<String> Participantes = new ArrayList<String>();
	ArrayList<Integer> hora = new ArrayList<Integer>();
	ArrayList<Integer> dia_i = new ArrayList<Integer>();
	ArrayList<Integer> mes_i = new ArrayList<Integer>();
	ArrayList<Integer> ano_i = new ArrayList<Integer>();
	ArrayList<Integer> dia_f = new ArrayList<Integer>();
	ArrayList<Integer> mes_f = new ArrayList<Integer>();
	ArrayList<Integer> ano_f = new ArrayList<Integer>();
	
	public Resources(){
		Name.add("Laborátorio");
		Name.add("Auditório");
		Name.add("Sala");
		Name.add("Projetor");
		
		int i;
		for(i=0;i<4;++i)
		{
			Estado.add(i,"Desalocado");
			Alocador.add(i,-1);
			Descrição.add(i,"None");
			Título.add(i,"None");
			Motivo.add(i,0);
			Material.add(i,"None");
			Participantes.add(i,"None");
			hora.add(i,25);
			dia_i.add(i,0);
			dia_f.add(i,0);
			ano_i.add(i,0);
			ano_f.add(i,0);
			mes_i.add(i,0);
			mes_f.add(i,0);
		}
	}
	
	public int buscar(int user_id)
	{
		int i;
		for(i=0;i<4;++i)
		{
			if(Alocador.get(i)==user_id)
			{
				return i;
			}
		}
		return -1;
	}
	public int Consulta()
	{
		System.out.println("Qual recurso você quer consultar?");
		System.out.println("[1]Laboratório");
		System.out.println("[2]Auditório");
		System.out.println("[3]Sala");
		System.out.println("[4]Projetor");
		int recurso = input.nextInt();
		return recurso - 1;
	}
	
	public void validar()
	{
		int i, cont = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() != "Desalocado")
			{
				++cont;
				System.out.println("Recurso: " );
				System.out.println("Motivo: ");
				System.out.println("Estado: ");
				System.out.println("Título: ");
				System.out.println("Descrição: ");
				System.out.println("Inicia às "+hora.get(i));
				System.out.println("Inicia na data "+dia_i.get(i)+"/"+mes_i.get(i)+"/"+ano_i.get(i));
				System.out.println("Finaliza na data "+dia_f.get(i)+"/"+mes_f.get(i)+"/"+ano_f.get(i));
				System.out.println("Você gostaria de Confirmar a Alocação desse recurso?");
				System.out.println("[1]Sim");
				System.out.println("[2]Não");
				System.out.println("[0]Sair");
				int x = input.nextInt();
				if(x == 1)
				{
					System.out.println("Para qual estado você gostaria de mudar?");
					System.out.println("[1]Em processo de Alocação");
					System.out.println("[2]Desalocado");
					System.out.println("[3]Concluído");
					System.out.println("[4]Alocado");
					System.out.println("[5]Em Andamento");
					int z = input.nextInt();
					if(z==1)
					{
						Estado.set(i,"Em processo de Alocação" );
					}
					else if(z == 2)
					{
						Estado.set(i, "Desalocado");
					}
					else if(z == 3)
					{
						Estado.set(i, "Concluído");
					}
					else if(z == 4)
					{
						Estado.set(i, "Alocado");
					}
					else if(z == 5)
					{
						Estado.set(i, "Em Andamento");
					}
				}
				else if(x == 0)
				{
					break;
				}
			}
		}
		if(cont == 0)
		{
			System.out.println("Nenhum recurso foi solicitado até o momento");
		}
	}
	public void alocar(int user_id,int flag)
	{
		
		System.out.println("Qual recurso você quer alocar?");
		System.out.println("[1]Laboratório");
		System.out.println("[2]Auditório");
		System.out.println("[3]Sala");
		System.out.println("[4]Projetor");
		int recurso = input.nextInt();
		Alocador.set(recurso-1, user_id);
		Estado.set(recurso-1,"Em processo de Alocação");
		System.out.println("Qual o motivo da alocação?");
		if(flag == 6)
		{
			System.out.println("[1]Aula Tradicional");
			System.out.println("[2]Laboratório");
			System.out.println("[3]Apresentação");
		}
		else
		{
			System.out.println("[3]Apresentação");
		}
		
		int motivo = input.nextInt();
		Motivo.set(recurso-1, motivo);
		System.out.println("Qual o título da atividade?");
		input = new Scanner(System.in);
		String titulo = input.nextLine();
		Título.set(recurso-1, titulo);
		System.out.println("Dê uma breve descrição sobre a atividade");
		input = new Scanner(System.in);
		String descriçao = input.nextLine();
		Descrição.set(recurso-1, descriçao);
		System.out.println("Qual o horário da atividade?");
		int h = input.nextInt();
		hora.set(recurso-1,h);
		System.out.println("Qual dia inicia a atividade?");
		int d = input.nextInt();
		dia_i.set(recurso-1, d);
		System.out.println("Qual mês inicia a atividade?");
		d = input.nextInt();
		mes_i.set(recurso-1, d);
		System.out.println("Qual ano inicia a atividade?");
		d = input.nextInt();
		ano_i.set(recurso-1, d);
		System.out.println("Qual dia termina a atividade?");
		d = input.nextInt();
		dia_f.set(recurso-1, d);
		System.out.println("Qual mês termina a atividade?");
		d = input.nextInt();
		mes_f.set(recurso-1, d);
		System.out.println("Qual ano termina a atividade?");
		d = input.nextInt();
		ano_f.set(recurso-1, d);
		
	}
	
	public String Motivo(int i)
	{
		if(i == 1)
			return "Aula Tradicional";
		else if(i == 2)
			return "Laboratório";
		else
			return "Apresentação";
	}
	
	public int p_al()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() == "Em processo de Alocação")
			{
				++aux;
			}
		}
		return aux;
	}
	
	public int des()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() == "Desalocado")
			{
				++aux;
			}
		}
		return aux;
	}
	
	public int al()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() == "Alocado")
			{
				++aux;
			}
		}
		return aux;
	}
	public int ea()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() == "Em Andamento")
			{
				++aux;
			}
		}
		return aux;
	}
	public int cl()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Estado.get(i).intern() == "Concluído")
			{
				++aux;
			}
		}
		return aux;
	}
	public int a_t()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Motivo.get(i) == 1)
			{
				++aux;
			}
		}
		return aux;
	}
	public int lab()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Motivo.get(i) == 2)
			{
				++aux;
			}
		}
		return aux;
	}
	public int ap()
	{
		int i,aux = 0;
		for(i=0;i<4;++i)
		{
			if(Motivo.get(i) == 3)
			{
				++aux;
			}
		}
		return aux;
	}
}
