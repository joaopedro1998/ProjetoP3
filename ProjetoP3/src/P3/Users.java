package P3;
import java.util.*;

public class Users {
	Scanner input = new Scanner(System.in);
	ArrayList<String> FirstName = new ArrayList<String>();
	ArrayList<String> LastName = new ArrayList<String>();
	ArrayList<String> Email = new ArrayList<String>();
	ArrayList<Integer> Type = new ArrayList<Integer>();
	
	ArrayList<String> Senha = new ArrayList<String>();
	
	public Users(){
		FirstName.add("adm");
		LastName.add("adm");
		Email.add("admin@hotmail.com");
		Senha.add("123");
		Type.add(0);
		
	}
	
	
	
	public void Cadastro()
	{
		System.out.println("Primeiro Nome:");
		String firstname = input.next();
		System.out.println("Último Nome:");
		String lastname = input.next();
		System.out.println("Email:");
		String email = input.next();
		System.out.println("Senha:");
		String senha = input.next();
		System.out.println("Qual dessas opções você se enquadra:");
		System.out.println("[1]Professor");
		System.out.println("[2]Pesquisador");
		System.out.println("[3]Aluno Graduação");
		System.out.println("[4]Aluno Mestrado");
		System.out.println("[5]Aluno Doutorado");
		int type = input.nextInt();
		
		FirstName.add(firstname);
		LastName.add(lastname);
		Email.add(email);
		Senha.add(senha);
		Type.add(type);
		
		
		
	}
	
	public int Consulta()
	{
		System.out.println("Qual o Primeiro Nome do Usuário que você quer consultar?");
		String firstname = input.next();
		System.out.println("E o último Nome?");
		String lastname = input.next();
		int i;		
		for(i = 0; i < FirstName.size();++i)
		{			
			if(FirstName.get(i).intern() == firstname.intern())
			{				
				if(LastName.get(i).intern() == lastname.intern())
				{
						return i;			
				}			
			}
		}
		return -1;
	}
	
	public int Login()
	{
		System.out.println("Email:");
		String email = input.next();
		System.out.println("Senha:");
		String senha = input.next();
		int aux = verify(email,senha);
		return aux;
			
	}
	
	public int verify(String email, String senha)
	{
		int i;		
		for(i = 0; i < Email.size();++i)
		{			
			if(Email.get(i).intern() == email.intern())
			{				
				if(Senha.get(i).intern() == senha.intern())
				{
					return i;					
				}
				break;
			}
		}
		
		return -1;
	}
	
	public int numero_usuarios()
	{
		return Email.size();
	}
		


}
