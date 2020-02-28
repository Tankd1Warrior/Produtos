import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ProdutoTest {

    Produto produto;
    Set<Produto> lista;


    @Before
    public void init() {
        produto = new Produto(123L, "Camisa", 150);
        lista = new HashSet<>();
    }

    @Test
    public void getNome() {
        assertEquals("Camisa", produto.getNome());
    }

    @Test
    public void getPreco() {
        assertEquals(150.0, produto.getPreco(), 0);
    }

    @Test
    public void find(){
        lista.add(produto);
        Produto pesquisa = new Produto(123L);
        assertTrue(lista.contains(pesquisa));
    }

}