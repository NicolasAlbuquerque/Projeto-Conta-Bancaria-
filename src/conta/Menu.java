package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner read = new Scanner (System.in);
		int option;
		int numerodestino;
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

		int opcao, numero, agencia, tipo = 0, aniversario;
		float saldo,limite,valor;
		String titular;

		while(true ) {

			System.out.println(" -------------------------------------------");
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
			tipo =0;
			 switch(option) {

			 case 1 -> {System.out.println("Criar Conta \n\n");
					 System.out.println("Numero da Agencia");
					 read.skip("\\R?");
					 agencia=read.nextInt();

					 System.out.println("nome do titular:");
					 titular=read.nextLine();
					 do {
						 System.out.println("Tipo de Conta (1 CC / 2 CP");
					 }while(tipo <1 && tipo >2);
					 tipo= read.nextInt();
					 System.out.println("Saldo da Conta: ");
					 saldo= read.nextFloat();
				 keyPress();
					 switch (tipo)
					 {
						 case 1->{System.out.println("Limite da Conta Corrente : ");
						 limite= read.nextFloat();
							 ContaCorrente cc = new ContaCorrente(0,agencia,tipo,titular,saldo,limite);
						 }
						 case 2 -> {System.out.println("Aniversario da poupança: ");
						 aniversario = read.nextInt();
							 ContaPoupanca cc = new ContaPoupanca(0,agencia,tipo,titular,saldo,aniversario);
						 }
					 }




				 }
			 case 2 -> {
				 System.out.println("Listar todas as Contas;");
				 keyPress();
			 }
			 case 3 -> {
				 System.out.println("Consultar dados da Conta - por numero.");
				 System.out.println("Numero da conta: ");
				 numero= read.nextInt();

				 keyPress();
			 }
			 case 4 -> {
				 System.out.println("Atualizar dados da Conta.");
				 System.out.println("numero da conta: ");
				 numero= read.nextInt();
				 System.out.println("Numero da Agencia");
				 read.skip("\\R?");
				 agencia=read.nextInt();

				 System.out.println("nome do titular:");
				 titular=read.nextLine();

				 tipo= read.nextInt();
				 System.out.println("Saldo da Conta: ");
				 saldo= read.nextFloat();



				 keyPress();
			 }
			 case 5 -> {System.out.println("Apagar Conta.");
				 System.out.println("numero da conta: ");
				 numero= read.nextInt();
					 keyPress();
				 }
			 case 6 ->{

			  System.out.println("Sacar.");
				 System.out.println("numero da conta: ");
				 numero= read.nextInt();
				 System.out.println("Valor do Saque: ");
				 valor=read.nextFloat();

				 keyPress();
			 }
			 case 7 -> {System.out.println("Depósito.");
					 System.out.println("numero da conta: ");
					 numero= read.nextInt();
					 System.out.println("Valor: ");
					 read.nextFloat();
			 }
			 case 8 -> {
				 System.out.println("Transferencia entre Contas.");

					 System.out.println("numero da conta origem: ");
					 numero= read.nextInt();
					 System.out.println("numero da conta destino: ");
					 numerodestino = read.nextInt();
			 }
			 default -> System.out.println("\nOpção inválida. \n");
			 }



		}


	}
	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
