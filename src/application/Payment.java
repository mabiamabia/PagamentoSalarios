package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Agente;

public class Payment {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Agente> list  = new ArrayList<>();
		
		//Parte 1 - lendo os dados
		
		System.out.println("Quantos funcionaries deseja cadastrar?");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++){
			System.out.println();
			System.out.println("Funcionarie: "+ i );	

			System.out.println("ID: ");	
			int id = sc.nextInt();
			while (hasId(list, id)) { // while para não repetir o id
					System.out.println("ID already taken. Try again");
					id = sc.nextInt();
			}
		
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.println("salario: ");
			double salario = sc.nextDouble();
			list.add(new Agente(id, name, salario));
		}
		
		//PARTE 2 - ATUALIZANDO SALARIO DA FUNCIONARIA
		
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Agente age = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(age == null) {
			System.out.println("This id does not exist");
		}
		else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			age.increaseSalario(percentage);
		}
		
		//PARTE - 3 - Listando funcionarios
		
		System.out.println();
		System.out.println("List of Employees: ");
		for(Agente obj : list) {
			System.out.println(obj);
		}
		
		
		sc.close();

	}
	
	public static boolean hasId(List<Agente> list, int id) {
		Agente age = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return age != null;
	}

}
