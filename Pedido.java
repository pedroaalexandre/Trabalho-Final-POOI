import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private int numero;
    private List <Produto> produtos;
    public static int qntdeProdutos;
    
    public Pedido() {
    }

    //Contrutor da classe pedido
    public Pedido(int numero, Produto produtos) {
        this.numero = numero;
        this.produtos = new ArrayList<>();
    }

    //Gets da classe pedido
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    //Exibição terminal da classe pedido
    public void exibir() {
        System.out.println("Número do pedido: " + numero + "\n \nProdutos: " + produtos);
    }

    public double totalPedido(List <Produto> produtos) {
        double soma = 0;

        for(int i = 0; i < produtos.size(); i++) {
            soma += produtos.get(i).getPreco();
        }

        return soma;
    }

}
