import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarrinhoDeComprasTest {

    CarrinhoDeCompras carrinhoDeCompras;
    ProdutoComTamanho produtoA, produtoB, produtoC;

    @Before
    public void init(){
        carrinhoDeCompras = new CarrinhoDeCompras();
        produtoA = new ProdutoComTamanho(123L, "Camisa", 150, "M");
        produtoB = new ProdutoComTamanho(123L, "Camisa1", 100, "S");
        produtoC = new ProdutoComTamanho(150L, "Calça", 200, "43");


        //Adicionando 4 produtos iguais
        carrinhoDeCompras.adicionarProduto(produtoB);
        carrinhoDeCompras.adicionarProduto(produtoB);
        carrinhoDeCompras.adicionarProduto(produtoB);
        carrinhoDeCompras.adicionarProduto(produtoB);

    }

    @Test
    public void adicionarProduto() {
        carrinhoDeCompras.adicionarProduto(produtoB);
        carrinhoDeCompras.adicionarProduto(produtoC);

        assertTrue(carrinhoDeCompras.getQuantidadeProdutos().containsKey(produtoB));
        assertTrue(carrinhoDeCompras.getQuantidadeProdutos().containsKey(produtoC));
    }

    @Test
    public void removeProduto() {

        carrinhoDeCompras.adicionarProduto(produtoA);

        //Remover 1 produto
        assertTrue(carrinhoDeCompras.removeProduto(produtoA, 1));

        //Remover 3 produtos iguais
        assertTrue(carrinhoDeCompras.removeProduto(produtoB, 3));

        //Remover quantidade inexistente de produto
        assertFalse(carrinhoDeCompras.removeProduto(produtoA, 2));

        //Remover produto inexistente
        assertFalse(carrinhoDeCompras.removeProduto(produtoC, 1));

    }

    @Test
    public void calculaPreco() {
        carrinhoDeCompras.adicionarProduto(produtoA);
        carrinhoDeCompras.adicionarProduto(produtoC);
        double valorTotal = carrinhoDeCompras.calculaPreco();

        CarrinhoDeCompras carrinhoVazio = new CarrinhoDeCompras();

        //Calcular preço carrinho sem produtos
        assertEquals(0, carrinhoVazio.calculaPreco(), 0);


        //Calcular preço carrinho com produtos
        //(4 x  produtoB) + produtoA + produtoC = 750
        assertEquals(750.0, valorTotal, 0);
    }
}