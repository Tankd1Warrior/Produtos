import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        List<Produto> lista = new ArrayList<>();

        Produto produto1 = new Produto(123, "Camisa", 54.90);
        Produto produto2 = new Produto(201, "Calças", 54.90);
        Produto produto3 = new ProdutoComTamanho(150, "Casaco", 54.90, "M");

        Produto pesquisa = new Produto(150);

        lista.add(produto1);
        lista.add(produto2);
        lista.add(produto3);

        if(lista.contains(pesquisa)){
            System.out.println("Contem!");
        }

        for(Produto produto: lista){
            if(produto instanceof ProdutoComTamanho){
                System.out.println("Achei um produto com tamanho em sua lista!\nNome: " + produto.getNome() );
            }
        }
    }

}
