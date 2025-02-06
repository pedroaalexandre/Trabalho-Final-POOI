import java.util.List;

public class Cliente {

    private int codigo;
    private String nome;
    private Pedido pedido;
    private List <Produto> produtos;

    public Cliente(int codigo, String nome, Pedido pedido) {
        this.codigo = codigo;
        this.nome = nome;
        this.pedido = pedido;
    }

    public Pedido novoPedido(int numero, int codigo, String nome, double preco) {
        Produto produto = new Produto(codigo, nome, preco);
        produtos.add(produto);
        return pedido;
    }
    
}
