public class Pedido {
    
    private int numero;
    Produto produtos;
    
    public Pedido(int numero, Produto produtos) {
        this.numero = numero;
        this.produtos = produtos;
    }

    public int getNumero() {
        return numero;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void exibir() {
        System.out.println("Número do pedido: " + numero);
    }

}
