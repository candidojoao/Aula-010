package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarrinhoTest {

    private static final double DELTA = 0.001;

    // Requisito 1 — Carrinho vazio
    @Test
    void carrinhoVazioDeveTerTotalZero() {
        Carrinho carrinho = new Carrinho();

        assertEquals(0.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 2 — Adicionar um produto
    @Test
    void deveAdicionarUmProduto() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100.0));

        assertEquals(100.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 3 — Adicionar vários produtos
    @Test
    void deveSomarPrecosDeVariosProdutos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Teclado", 100.0));
        carrinho.adicionar(new Produto("Mouse", 50.0));

        assertEquals(150.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 4 — Remover produto
    @Test
    void deveRemoverProduto() {
        Carrinho carrinho = new Carrinho();
        Produto teclado = new Produto("Teclado", 100.0);
        Produto mouse = new Produto("Mouse", 50.0);
        carrinho.adicionar(teclado);
        carrinho.adicionar(mouse);

        carrinho.remover(mouse);

        assertEquals(100.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 5 — Produto com preço inválido
    // Decisão: lançar IllegalArgumentException e não alterar o carrinho.
    @Test
    void naoDevePermitirProdutoComPrecoNegativo() {
        Carrinho carrinho = new Carrinho();

        assertThrows(IllegalArgumentException.class,
                () -> carrinho.adicionar(new Produto("Teclado", -100.0)));

        assertEquals(0.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 6 — Desconto de 10% a partir de R$ 500,00
    @Test
    void deveAplicarDescontoDeDezPorCentoAcimaDeQuinhentos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Monitor", 600.0));

        assertEquals(60.0, carrinho.getDesconto(), DELTA);
        assertEquals(540.0, carrinho.getTotal(), DELTA);
    }

    // Requisito 6 — Fronteira: R$ 499,99 (sem desconto)
    @Test
    void naoDeveAplicarDescontoEmQuatrocentosENoventaENoveENoventaENove() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Cadeira", 499.99));

        assertEquals(499.99, carrinho.getTotal(), DELTA);
    }

    // Requisito 6 — Fronteira: R$ 500,00 (com desconto)
    @Test
    void deveAplicarDescontoEmExatamenteQuinhentos() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Cadeira", 500.00));

        assertEquals(450.00, carrinho.getTotal(), DELTA);
    }

    // Requisito 6 — Fronteira: R$ 500,01 (com desconto)
    @Test
    void deveAplicarDescontoEmQuinhentosEUmCentavo() {
        Carrinho carrinho = new Carrinho();

        carrinho.adicionar(new Produto("Cadeira", 500.01));

        assertEquals(450.009, carrinho.getTotal(), DELTA);
    }
}
