public class ContaCorrente extends Conta {

    private static final double TAXA_SAQUE = 0.02; // 2% de taxa

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + (valor * TAXA_SAQUE);
        if (valor > 0 && saldo >= valorComTaxa) {
            saldo -= valorComTaxa;
            registrarTransacao(String.format("Saque com taxa: R$%.2f (Taxa: R$%.2f)", valor, valor * TAXA_SAQUE));
        } else {
            System.out.println("Operação inválida: saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("-x-x-x-x- Extrato Conta Corrente -x-x-x-x-");
        super.imprimirInfosComuns();
    }
}