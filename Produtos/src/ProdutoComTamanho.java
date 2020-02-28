public class ProdutoComTamanho extends Produto {

    private String tamanho;

    //Construtor para pesquisa de obj
    public ProdutoComTamanho(Long codigo) {
        super(codigo);
    }

    public ProdutoComTamanho(long codigo, String tamanho){
        super(codigo);
        this.tamanho = tamanho;
    }

    public ProdutoComTamanho(long codigo, String nome, double preco, String tamanho) {
        super(codigo, nome, preco);
        this.tamanho = tamanho;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoComTamanho)) return false;
        if (!super.equals(o)) return false;

        ProdutoComTamanho that = (ProdutoComTamanho) o;

        return tamanho != null ? tamanho.equals(that.tamanho) : that.tamanho == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (tamanho != null ? tamanho.hashCode() : 0);
        return result;
    }
}
