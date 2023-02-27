package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.Controller.ContaController;

import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);


		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		float saldo, limite, valor;
		String titular;


		System.out.println("\nCriar Contas\n");

		var cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 10000f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();




		/*	// Criamos o Objeto Conta c1
		Conta c1 = new Conta(1, 123, 1, "Erica Araújo", 30000.0f);

		// Visualizamos os dados da Conta c1
		c1.visualizar();

		// Alteramos o Saldo da Conta c1
		c1.setSaldo(35000.0f);

		// Visualizamos apenas o Saldo da Conta c1
		System.out.println("\n\n" + c1.getSaldo());

		// Criamos o Objeto Conta c2
		Conta c2 = new Conta(2, 123, 1, "Dener Cardoso", 50000.0f);

		// Visualizamos os dados da Conta c2
		c2.visualizar();

		// Efetuamos um Saque na Conta c2 e visualizamos o novo Saldo
		if(c2.sacar(1000.0f))
			System.out.println("\n\n" + c2.getSaldo());

		// Efetuamos um Depósito na Conta c1
		c1.depositar(10000.0f);

		// Visualizamos os dados da Conta c1 após o Depósito
		c1.visualizar();
*/
		//ContaCorrente c3 = new ContaCorrente(3, 123, 1, tipo, "Vitoria", 30000.0f, 1000.0f);

	//	c3.visualizar();
//
	///	c3.sacar(32000);

		//c3.visualizar();

		//ContaPoupanca c4 = new ContaPoupanca(4, 123, 2, tipo, "Lia", 20000.0f, 5);

		//c4.visualizar();



		while (true) {

			System.out.println( " ------------------------------------------------------");
			System.out.println(" ------------------------------------------------------");
			System.out.println("|                FUCK THE CAPITALISM BANK              |");
			System.out.println(" ------------------------------------------------------");
			System.out.println("|            1 - Criar Conta                           |");
			System.out.println("|            2 - Listar todas as Contas                |");
			System.out.println("|            3 - Buscar Conta por Numero               |");
			System.out.println("|            4 - Atualizar Dados da Conta              |");
			System.out.println("|            5 - Apagar Conta                          |");
			System.out.println("|            6 - Sacar                                 |");
			System.out.println("|            7 - Depositar                             |");
			System.out.println("|            8 - Transferir valores entre Contas       |");
			System.out.println("|            9 - Sair                                  |");
			System.out.println("|                                                      |");
			System.out.println(" ------------------------------------------------------ ");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
					try {
						opcao = leia.nextInt();
					}catch(InputMismatchException e){
						System.out.println("Digite valores Inteiros.");
						leia.nextLine();
								opcao=0;

					}
			if (opcao == 9) {
				System.out.println("\nFuck the capitalism - Controlamos o seu Futuro  daqui!");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Criar Conta\n\n");

					System.out.println("Número da Agencia: ");
					agencia = leia.nextInt();

					System.out.println("Nome do Titular: ");
					leia.skip("\\R?");
					titular =  leia.nextLine();

					do {
						System.out.println("Tipo da Conta (1-CC / 2-CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);

					System.out.println("Saldo da Conta: ");
					saldo = leia.nextFloat();

					switch(tipo) {
						case 1 ->{
							System.out.println("Limite da Conta Corrente: ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia,
									tipo, titular, saldo, limite));
							//cc.visualizar();
						}
						case 2 ->{
							System.out.println("Aniversário da Conta Poupança: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia,
									tipo, titular, saldo, aniversario));
						}
					}

					keyPress();

					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");
						contas.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - Por Número\n\n");

					System.out.println(" Digite o Número da Conta: ");
					numero = leia.nextInt();
						contas.procurarPorNumero(numero);
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");

					System.out.println("Digite o Número da Conta que deseja Atualizar: ");
					numero = leia.nextInt();

					// Condicional para checar se a conta existe

					if (contas.buscarNaCollection(numero)!=null) {

						System.out.println("Número da Agencia: ");
						agencia = leia.nextInt();

						System.out.println("Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();

						System.out.println("Saldo da Conta: ");
						saldo = leia.nextFloat();

						tipo = contas.retornaTipo(numero);


						switch (tipo) {
							case 1 -> {
								System.out.println("Limite da Conta Corrente: ");
								limite = leia.nextFloat();
								contas.atualizar(new ContaCorrente(0, agencia, tipo, titular, saldo, limite));                            //cc.visualizar();
							}
							case 2 -> {
								System.out.println("Aniversário da Conta Poupança: ");
								aniversario = leia.nextInt();
								contas.atualizar(new ContaPoupanca(0, agencia, tipo, titular, saldo, aniversario));
							}
							default -> {
								System.out.println("Tipo da Conta Inválido.");
							}
						}
					}else {
						System.out.println("Conta não encontrada.");
					}
					keyPress();
					break;
				case 5:
					System.out.println("Apagar a Conta\n\n");
					System.out.println("Digite o Número da Conta que deseja apagar: ");
					numero= leia.nextInt();
						contas.deletar(numero);// Chamada para o Método Deletar

					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");



					System.out.println("Número da Conta: ");
					numero = leia.nextInt();

					System.out.println("Valor do Saque: ");
					valor = leia.nextFloat();
					contas.sacar(numero,valor);// Chamada para o Método Sacar

					keyPress();
					break;
				case 7:
					System.out.println("Depósito\n\n");

					System.out.println("Número da Conta: ");
					numero = leia.nextInt();

					System.out.println("Valor do Depósito: ");
					valor = leia.nextFloat();

					contas.depositar(numero,valor);// Chamada para o Método Depositar

					keyPress();
					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");

					System.out.println("Número da Conta - Origem: ");
					numero = leia.nextInt();

					System.out.println("Número da Conta - Destino: ");
					numeroDestino = leia.nextInt();

					System.out.println("Valor da Transferência: ");
					valor = leia.nextFloat();

					// Chamada para o Método Transferir
					contas.transferir(numero, numeroDestino,valor);

					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					keyPress();
					break;
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