import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class ProdutoComTamanhoTest extends ProdutoTest {

    Produto produto2;
    Produto produto3;

    @Override
    public void init() {
        produto = new ProdutoComTamanho(123L, "Camisa", 150.0, "M");
        produto3 = new ProdutoComTamanho(123L, "Camisa", 150.0, "S");
        produto2 = new ProdutoComTamanho(150L, "Calça", 200.0, "42");
        lista = new HashSet<>();
        lista.add(produto);
        lista.add(produto2);
        lista.add(produto3);
    }

    @Override
    public void find() {
        Produto pesquisa = new ProdutoComTamanho(123L, "M");

        assertEquals(true, lista.contains(pesquisa));

    }

    @Test
    public void findComProdutoInexistente() {
        Produto pesquisa = new ProdutoComTamanho(123L, "G");
        Produto pesquisa2 = new ProdutoComTamanho(150L, "G");
        Produto pesquisa3 = new ProdutoComTamanho(20L, "Qualquer outra coisa");

        assertNotEquals(true, lista.contains(pesquisa));

        assertNotEquals(true, lista.contains(pesquisa2));

        assertNotEquals(true, lista.contains(pesquisa3));
    }
}