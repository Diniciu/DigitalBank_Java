import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaAcoes {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    private List<String> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            registrarTransacao(String.format("Saque: R$%.2f", valor));
        } else {
            System.out.println("Operação inválida: saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarTransacao(String.format("Depósito: R$%.2f", valor));
        } else {
            System.out.println("Operação inválida: valor inválido.");
        }
    }

    @Override
    public void transferir(double valor, ContaAcoes contaDestino) {
        if (valor > 0 && saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            registrarTransacao(String.format("Transferência de R$%.2f para conta %d", valor, ((Conta) contaDestino).getNumero()));
        } else {
            System.out.println("Operação inválida: saldo insuficiente ou valor inválido.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: R$%.2f", this.saldo));
    }

    public void imprimirHistorico() {
        System.out.println("=== Histórico de Transações ===");
        for (String transacao : historico) {
            System.out.println(transacao);
        }
    }

    protected void registrarTransacao(String descricao) {
        historico.add(descricao);
    }
}