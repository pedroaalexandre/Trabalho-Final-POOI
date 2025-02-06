import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private int numero;
    private List <Produto> produtos;
    
    //Contrutor da classe pedido
    public Pedido(int numero, Produto produtos) {
        this.numero = numero;
        this.produtos = new ArrayList<>();
    }

    //Gets da classe pedido
    public int getNumero() {
        return numero;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    //Exibição terminal da classe pedido
    public void exibir() {
        System.out.println("Número do pedido: " + numero + "\n \nProdutos: " + produtos);
    }

}
