package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner read = new Scanner (System.in);
		int option;
		//criamos o objeto conta
		Conta c1= new Conta(1,123,1,"Nicolas",30000.0f);
		//visualizamos
		c1.visualizar();
		//altermos o saldo 
		c1.setSaldo(35000.0f);
		//visualizamos apenas o saldo da conta c1
		System.out.println(c1.getSaldo());
		
		
		//criamos a conta c2
		Conta c2= new Conta(2,321,1,"Ariane",70000.0f);
		//visualizamos a conta c2
		c2.visualizar();
		//efetuando um saque da conta c2 e visualizamos o novo saldo
		if(c2.sacar(1000.0f))
			///efetuamos um deposito na conta c1
			c1.depositar(1000.0f);
		//visualiuzamos os dados da conta c1 após o Depósitos
		
		System.out.println(c2.getSaldo()
);		
		
		
		while(true ) {
			
			System.out.println(Cores.ANSI_CYAN_BACKGROUND+Cores.TEXT_PURPLE_BOLD+" -------------------------------------------");
			System.out.println("|                                           |");
			System.out.println("|           Banco Generarion.               |");
			System.out.println("|                                           |");
			System.out.println(" -------------------------------------------");
			System.out.println("|                                           |");
			System.out.println("|    [1]- Criar Conta.                      |");
			System.out.println("|    [2]- Listar todas as Contas.           |");
			System.out.println("|    [3]- Buscar Conta por numero.          |");
			System.out.println("|    [4]- Atualizar dados da Conta.         |");
			System.out.println("|    [5]- Apagar Conta.                     |");
			System.out.println("|    [6]- Sacar.                            |");
			System.out.println("|    [7]- Depositar.                        |");
			System.out.println("|    [8]- Transferir valores entre Contas.  |");
			System.out.println("|    [9]- Sair.                             |");
			System.out.println("|                                           |");
			System.out.println(" -------------------------------------------");
			System.out.println("|                                           |");
			System.out.println("|    Entre com a opção Desejada:            |");
			System.out.println("|                                           |");
			System.out.println(" -------------------------------------------"+Cores.TEXT_RESET);
			option=read.nextInt();
			 
			if (option==9) {
				System.out.println("\nBanco Gen, Seu Futuro comaça Aqui!");
				read.close();
				System.exit(0);
			}
			 switch(option) {
			 
			 case 1 -> System.out.println("Criar Conta \n\n");
			 case 2 -> System.out.println("Listar todas as Contas;");
			 case 3 -> System.out.println("Consultar dados da Conta - por numero.");
			 case 4 -> System.out.println("Atualizar dados da Conta.");
			 case 5 -> System.out.println("Apagar Conta.");
			 case 6 -> System.out.println("Sacar.");
			 case 7 -> System.out.println("Depósito.");
			 case 8 -> System.out.println("Transferencia entre Contas.");
			 default -> System.out.println("\nOpção inválida. \n");
			 }
			 
		
		
		}
		
		
	}

}
