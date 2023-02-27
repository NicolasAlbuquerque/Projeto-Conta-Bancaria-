package conta.Controller;

import conta.Repository.ContaRepository;
import conta.model.Conta;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

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

    }

    @Override
    public void depositar(int numero, float valor) {

    }

    @Override
    public void transferir(int numero, int numeroDestino, float valor) {

    }
    public int gerarNumero(){
        return listaConta.size()+1;
    }

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
