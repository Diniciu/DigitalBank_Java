public interface ContaAcoes {
	
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, ContaAcoes contaDestino);
	void imprimirExtrato();
}