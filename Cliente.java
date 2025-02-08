import java.util.List;

public class Cliente {

    private String codigo;
    private String nome;
    private double desconto;
    private Pedido pedido;

    public Cliente(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Cliente(String codigo, String nome, double desconto) {       //Construtor sobrecarregado
        this.codigo = codigo;
        this.nome = nome;
        this.desconto = desconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public String exibe(String codigo, String nome) {
        double total = pedido.totalPedido(pedido.getProdutos());
        return String.format("Código: %s - Nome: %s\nLista de pedidos: %s\nValor total: %.2f", codigo, nome, pedido.getProdutos(), total);
    }

    public String exibe(String codigo, String nome, double desconto) {
        double total = pedido.totalPedido(pedido.getProdutos());
        double totalDesconto = pedido.totalPedido(pedido.getProdutos()) - (pedido.totalPedido(pedido.getProdutos()) * desconto);
        return String.format("Código: %s - Nome: %s\nLista de pedidos: %s\nValor total: %.2f\nValor com desconto: %.2f\n", codigo, nome, pedido.getProdutos(), total,totalDesconto);
    }
    
}
