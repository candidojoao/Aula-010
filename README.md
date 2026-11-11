# Aula 010 — TDD (Test-Driven Development)

Atividades da Semana 10 da disciplina de Teste de Software, resolvidas seguindo o ciclo
**RED → GREEN → REFACTOR**. Todos os projetos usam Java 17, Maven e JUnit 5.

| Projeto | O que foi feito | Testes |
|---|---|---|
| [`bubblesort-tdd`](bubblesort-tdd) | Implementado o método `ordenar()` (Bubble Sort com parada antecipada quando não há trocas). Os testes fornecidos não foram alterados. | 3 |
| [`conta-bancaria-tdd-maven`](conta-bancaria-tdd-maven) | Implementados `depositar()` e `sacar()`; depósitos/saques com valor ≤ 0 e saques maiores que o saldo são ignorados. | 4 |
| [`estoque-tdd`](estoque-tdd) | Implementados `adicionarEstoque()` e `retirarEstoque()`; entradas ≤ 0 e retiradas maiores que o estoque não alteram a quantidade. | 6 |
| [`carrinho-compras-tdd`](carrinho-compras-tdd) | Escritos os testes de cada requisito (1 a 6) e implementada a classe `Carrinho` (adicionar, remover, subtotal, desconto e total). | 9 |

## Decisões tomadas

- **Carrinho — Requisito 5 (preço negativo):** o carrinho lança `IllegalArgumentException`
  ao tentar adicionar um produto com preço negativo, e o total permanece inalterado.
  Lançar exceção torna o erro explícito para quem chama o método, em vez de falhar silenciosamente.
- **Carrinho — Requisito 6 (desconto):** desconto de 10% quando o subtotal é **≥ R$ 500,00**.
  Foram testados os valores de fronteira R$ 499,99 (sem desconto), R$ 500,00 e R$ 500,01 (com desconto).

## Como executar

Em cada pasta de projeto:

```bash
mvn test
```

## Resultado

```text
bubblesort-tdd            Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
conta-bancaria-tdd-maven  Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
estoque-tdd               Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
carrinho-compras-tdd      Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
```
