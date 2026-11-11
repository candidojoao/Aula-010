package br.edu.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static final double VALOR_MINIMO_DESCONTO = 500.0;
    private static final double PERCENTUAL_DESCONTO = 0.10;

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        if (produto.getPreco() < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo");
        }
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        produtos.remove(produto);
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Produto produto : produtos) {
            subtotal += produto.getPreco();
        }
        return subtotal;
    }

    public double getDesconto() {
        double subtotal = getSubtotal();
        return subtotal >= VALOR_MINIMO_DESCONTO ? subtotal * PERCENTUAL_DESCONTO : 0;
    }

    public double getTotal() {
        return getSubtotal() - getDesconto();
    }
}
