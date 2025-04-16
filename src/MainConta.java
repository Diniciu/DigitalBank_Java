import java.util.ArrayList;

public class MainConta {
    public static void main(String[] args) {
        Cliente usuario = new Cliente();
        usuario.setNome("Axel");

        Conta cc = new ContaCorrente(usuario);
        Conta poupanca = new ContaPoupanca(usuario);

        cc.depositar(100);
        cc.transferir(50, poupanca);
        cc.sacar(30);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.imprimirHistorico();
        poupanca.imprimirHistorico();

        Banco banco = new Banco();
        banco.setNome("Banco Digital");
        banco.setContas(new ArrayList<>());
        banco.getContas().add(cc);
        banco.getContas().add(poupanca);

        System.out.println("Saldo total no banco: R$" + banco.calcularSaldoTotal());
        banco.listarClientes();
    }
}