package conta.Controller;

import conta.Repository.ContaRepository;
import conta.model.Conta;

import java.util.ArrayList;

public class ContaController implements ContaRepository {
         int numero=0;
        private ArrayList<Conta> listaConta=new ArrayList<Conta>();

    @Override
    public void procurarPorNumero(int numero) {
        var conta = buscarNaCollection(numero);
        if (conta != null)
            conta.visualizar();
        else System.out.println("A conta numero: "+ numero + " não foi encontrado");

    }

    @Override
    public void listarTodas() {
        for(var conta:listaConta)
            conta.visualizar();
    }

    @Override
    public void cadastrar(Conta conta) {
        listaConta.add(conta);
        System.out.println("A conta foi criada");
    }

    @Override
    public void atualizar(Conta conta) {

            var buscarConta = buscarNaCollection(conta.getNumero());
            if (conta != null) {
                listaConta.set(listaConta.indexOf(buscarConta), conta);
            } else {System.out.println("A conta numero: "+ conta.getNumero() + " não foi encontrado");

        }
    }


    @Override
    public void deletar(int numero) {
            var conta = buscarNaCollection(numero);
            if (conta != null){
            if (listaConta.remove(conta)) {
                System.out.println("Conta de numero: " + numero + " foi excluida");

            } else System.out.println("A conta numero: "+ numero + " não foi encontrado");

        }
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
        if (conta != null){
            if (conta.sacar(valor) == true) ;
        System.out.println("Saque realizado com Sucesso ");
    }else
            System.out.println("A conta numero: "+ numero + " não foi encontrado");

    }


    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarNaCollection(numero);
        if (conta != null){
            conta.depositar(valor);
            System.out.println("Saque realizado com Sucesso ");
        }else
            System.out.println("A conta numero: "+ numero + " não foi encontrado");

    }

    @Override
    public void transferir(int numero, int numeroDestino, float valor) {
        var contaOrigem = buscarNaCollection(numero);
        var contaDestino = buscarNaCollection(numeroDestino);
        if (contaOrigem != null && contaDestino != null){
            if(contaOrigem.sacar(valor)==true)
              contaDestino.depositar(valor);
              System.out.println("Deposito efetuada com Sucesso ");
        }else
            System.out.println("A conta de Origem e/ou Destino não foram encontradas");


    }
    public int gerarNumero(){
      /*  if (listaConta.size()==0){
            return numero;
        }else{
            numero ++;*/
            return  ++ numero ;
        }

   // }

        public Conta buscarNaCollection(int numero){
            for(var conta :listaConta){
                if (conta.getNumero()==numero)
                    return conta;
            }
            return null;
        }


    public int retornaTipo(int numero) {

        for (var conta : listaConta) {
            if (conta.getNumero() == numero) {
                return  conta.getTipo();
            }
        }
        return 0;
    }


}
