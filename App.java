import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        String usuario = "usuario";     //Definição de um usuario default
        String senha = "123";           //Definição de uma senha default
        boolean entrada = false;
        double desconto = 0.10;         //Definição do valor da variável desconto para utilizar no contrutor sobrecarregado
        int opcao;

        Pedido pedido = new Pedido();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Produto> pedidoCliente = new ArrayList<>();       //Criação de uma lista para armazenar os produtos escolhido pelo cliente

        // Criação dos produtos;
        produtos.add(new Produto(1, "Arroz", 5.50));
        produtos.add(new Produto(2, "Feijão", 4.30));
        produtos.add(new Produto(3, "Açúcar", 3.20));
        produtos.add(new Produto(4, "Café", 8.70));
        produtos.add(new Produto(5, "Macarrão", 2.80));
        produtos.add(new Produto(6, "Leite", 3.50));
        produtos.add(new Produto(7, "Pão", 1.20));
        produtos.add(new Produto(8, "Queijo", 9.40));
        produtos.add(new Produto(9, "Manteiga", 4.60));
        produtos.add(new Produto(10, "Presunto", 6.80));
        produtos.add(new Produto(11, "Ovos", 5.00));
        produtos.add(new Produto(12, "Tomate", 4.10));
        produtos.add(new Produto(13, "Alface", 2.50));
        produtos.add(new Produto(14, "Banana", 3.00));
        produtos.add(new Produto(15, "Laranja", 4.00));

        //Menu e validação do usuário e senha
        do {
            System.out.print("Usuário: ");
            String user = s.next();
            System.out.print("Senha: ");
            String pass = s.next();
            System.out.println();
            
            if(user.equals(usuario) && pass.equals(senha)){
                entrada = true;               
            }else{ 
                System.out.println("Usuario ou senha incorretos, tente novamente.\n");
            }
            
        } while (!entrada);

        do {
            menuFuncoes();
            opcao = s.nextInt();

            switch (opcao) {
                // Opção de listagem dos produtos;
                case 1:
                    System.out.println();
                    for (Produto produto : produtos) {
                        System.out.println(produto.toString());
                    }
                    System.out.println();
                break;

                // Opção de fazer um novo pedido;
                case 2:
                    System.out.println();
                    System.out.print("Código do produto: ");
                    int indice = s.nextInt();
                    char continuar;
                        
                    //Chamada do método para gerar um número de pedido
                    pedido.setNumero(Utilitaria.gerarPedido());

                    //try catch para capturar um erro caso um usuário digite um índice maior que o tamanho da lista
                    try {
                        pedidoCliente.add(produtos.get(indice - 1));    //Adicionar produto à lista do cliente
                        pedido.setProdutos(pedidoCliente);              //Setar produtos à classe Pedido
                        Pedido.qntdeProdutos++;                         //Método estático para contar a quantidade de pedidos
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erro: Código de produto inválido. Tente novamente.");
                        break;
                    }

                    do {
                        System.out.println("Os itens do pedido são:");     //Exibir os itens que estão na lista do cliente
                        for (Produto produto : pedidoCliente) {
                            System.out.println(produto);
                        }
                        System.out.println("Deseja adionar mais? s / n");   //Opção para adicionar mais produtos
                        continuar = s.next().charAt(0);

                        if (continuar == 's') {
                            indice = s.nextInt();
                            try {
                                pedidoCliente.add(produtos.get(indice - 1));
                                pedido.setProdutos(pedidoCliente);
                                Pedido.qntdeProdutos++;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Erro: Código de produto inválido. Tente novamente.");
                                break;
                            }
                        }else if(continuar == 'n'){
                            System.out.println("Pedido finalizado.");

                        }else{
                            System.out.println("Opção inválida.");
                            
                        }
                            
                    } while (continuar == 's');
                break;
                
                // Opção de informar ao usuário o total do pedido;
                case 3:
                    menuCartao();
                    int opcaoCartao = s.nextInt();  //Usuário deve informar se possui o cartão

                    if(opcaoCartao == 1) {      //Caso tenha o cartão, instanciará a classe cliente que possui o atributo "desconto"
                        String codigo = Utilitaria.gerarCodigo();
                        Cliente cliente = new Cliente(codigo, usuario, desconto);
                        cliente.setPedido(pedido);      //Setando a classe pedido em cliente.
                        System.out.println(cliente.exibe(codigo, usuario, desconto));
                        
                    }else{          //Caso tenha o cartão, instanciará a classe cliente que não possui o atributo "desconto"
                        String codigo = Utilitaria.gerarCodigo();
                        Cliente cliente = new Cliente(codigo, usuario);
                        cliente.setPedido(pedido);
                        System.out.println(cliente.exibe(codigo, usuario));
                    }
                break;

                // Opção sair do programa;
                case 4:
                    System.out.println();
                    System.out.println("Saindo...");
                    System.exit(1);
                break;
            }
            
        } while (opcao != 4);

    }
    
    public static void menuCartao() {
        Scanner s = new Scanner(System.in);

        System.out.println();
        System.out.println(" -------- MENU CARTÃO -------");
        System.out.println("| Possui o cartão da loja?   |");
        System.out.println("| 1. Sim                     |");
        System.out.println("| 2. Não                     |");
        System.out.print("| Digite a opção desejada: ");
    }   

    public static void menuFuncoes() {
    Scanner s = new Scanner(System.in);
    
        System.out.println();
        System.out.println("+------ MENU PRINCIPAL -----+");
        System.out.println("| 1. Listar produtos        |");
        System.out.println("| 2. Fazer pedido           |");
        System.out.println("| 3. Total do pedido        |");
        System.out.println("| 4. Sair                   |");
        System.out.print("| Digite a opção desejada: ");    
    }
}