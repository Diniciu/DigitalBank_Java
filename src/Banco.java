import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public double calcularSaldoTotal() {
        return contas.stream().mapToDouble(Conta::getSaldo).sum();
    }

    public void listarClientes() {
        System.out.println("=== Lista de Clientes ===");
        contas.forEach(conta -> System.out.println(conta.getCliente().getNome()));
    }
}