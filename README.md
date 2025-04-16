---

# Sistema Bancário em Java

Este sistema bancário foi desenvolvido utilizando **Programação Orientada a Objetos (POO)**, aplicando conceitos como **abstração**, **encapsulamento**, **herança** e **polimorfismo**. Abaixo está a explicação detalhada de cada classe e suas funcionalidades.

---

## 1. Classe `MainConta`

### ✅ Responsabilidades:
- Criar um cliente e associá-lo a contas bancárias.
- Realizar operações como depósito, saque e transferência.
- Imprimir extratos e históricos das contas.
- Gerar relatórios do banco, como saldo total e lista de clientes.

### 🔄 Fluxo:
1. Um cliente chamado **"Axel"** é criado.
2. São criadas duas contas para o cliente:
   - Uma **conta corrente** (`ContaCorrente`)
   - Uma **conta poupança** (`ContaPoupanca`)
3. Operações bancárias realizadas:
   - Depósito de **R$100** na conta corrente.
   - Transferência de **R$50** da conta corrente para a conta poupança.
   - Saque de **R$30** na conta corrente.
4. Os **extratos** e **históricos** das contas são exibidos.
5. O **saldo total** do banco e a **lista de clientes** são impressos.

---

## 2. Classe `Conta`

Classe **abstrata**, base para todas as contas bancárias. Implementa a interface `ContaAcoes`.

### 🔐 Atributos:
- `agencia`: Número da agência (fixo como 1)
- `numero`: Número da conta (gerado sequencialmente)
- `saldo`: Saldo da conta
- `cliente`: Cliente associado à conta
- `historico`: Lista de transações realizadas

### 🛠️ Métodos:
- **Operações básicas:**
  - `sacar(double valor)`
  - `depositar(double valor)`
  - `transferir(double valor, ContaAcoes contaDestino)`
- **Histórico:**
  - `registrarTransacao(String descricao)`
  - `imprimirHistorico()`
- **Impressão:**
  - `imprimirInfosComuns()`

---

## 3. Interface `ContaAcoes`

Define ações obrigatórias para todas as contas.

### 📋 Métodos:
- `sacar(double valor)`
- `depositar(double valor)`
- `transferir(double valor, ContaAcoes contaDestino)`
- `imprimirExtrato()`

---

## 4. Classe `ContaCorrente`

Especialização da classe `Conta`.

### 🧾 Características:
- Aplica **taxa de 2%** em saques
- Cabeçalho personalizado em extrato

### 🔁 Métodos sobrescritos:
- `sacar(double valor)`
- `imprimirExtrato()`

---

## 5. Classe `ContaPoupanca`

Especialização da classe `Conta`.

### 🧾 Características:
- **Sem taxas** em operações
- Cabeçalho personalizado em extrato

---

## 6. Classe `Cliente`

Representa o cliente do banco.

### 🔐 Atributos:
- `nome`: Nome do cliente

### 📋 Métodos:
- `getNome()`
- `setNome(String nome)`

---

## 🏛7. Classe `Banco`

Gerencia as contas associadas.

### 🔐 Atributos:
- `nome`: Nome do banco
- `contas`: Lista de contas

### 📋 Métodos:
- `calcularSaldoTotal()`
- `listarClientes()`

---

## 📚 Conceitos de POO Aplicados

### 🔹 Abstração
Interface `ContaAcoes` define ações comuns, ocultando detalhes.

### 🔹 Encapsulamento
Atributos privados com acesso controlado via `get/set`.

### 🔹 Herança
`ContaCorrente` e `ContaPoupanca` herdam de `Conta`.

### 🔹 Polimorfismo
Método `imprimirExtrato` é sobrescrito nas subclasses.

---

## 🚀 Melhorias Implementadas

1. ✅ **Validações**:
   - Impede saques com saldo insuficiente ou valores negativos.
2. 🕘 **Histórico de Transações**:
   - Depósitos, saques e transferências registrados.
3. 💸 **Taxas**:
   - Conta corrente aplica taxa de 2% em saques.
4. 📊 **Relatórios do Banco**:
   - Saldo total e lista de clientes disponíveis.

---
