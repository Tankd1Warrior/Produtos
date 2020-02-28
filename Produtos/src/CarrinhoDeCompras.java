import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

    private Map<Produto, Integer> quantidadeProdutos;

    public CarrinhoDeCompras() {
        this.quantidadeProdutos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto){
        if(quantidadeProdutos.containsKey(produto)){
            quantidadeProdutos.replace(produto, quantidadeProdutos.get(produto)+1);
            return;
        }
        quantidadeProdutos.put(produto, 1);
    }

    public Map<Produto, Integer> getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public boolean removeProduto(Produto produto, Integer quantidade){

        boolean condition = quantidadeProdutos.containsKey(produto);


        //Verifica se se o produto existe no carrinho ou se a quantidade não é maior do que existe no carrinho
        if(!condition || quantidade > quantidadeProdutos.get(produto)){
            return false;
        }

        quantidadeProdutos.replace(produto, quantidadeProdutos.get(produto) - quantidade);

        if(quantidadeProdutos.get(produto) <= 0){
            quantidadeProdutos.remove(produto);
        }
        return true;
    }

    public double calculaPreco(){

        double valorTotal = 0;

        for(HashMap.Entry<Produto, Integer> map: quantidadeProdutos.entrySet()){
            Produto produto = map.getKey();
            valorTotal += (produto.getPreco() * map.getValue());
        }

        return valorTotal;
    }

}
