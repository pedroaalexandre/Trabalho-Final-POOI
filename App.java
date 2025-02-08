import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        String usuario = "usuario";
        String senha = "123";
        boolean entrada = false;
        int opcao = 0;

        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Produto> pedidoCliente = new ArrayList<>();

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
                    
                    pedidoCliente.add(produtos.get(indice - 1));

                    do {
                        System.out.println("Os itens do pedido são:");
                        for (Produto produto : pedidoCliente) {
                            System.out.println(produto);
                        }
                        System.out.println("Deseja adionar mais? s / n");
                        continuar = s.next().charAt(0);
                        if (continuar == 's') {
                            indice = s.nextInt();
                            pedidoCliente.add(produtos.get(indice - 1));
                        }
                    } while (continuar == 's');
                break;
                case 3:
                    menuCartao();
                    int opcaoCartao = s.nextInt();
                    

                    // if(opcaoCartao == 1) {
                    //     Cliente cliente = new Cliente(usuario, senha, pedidoCliente);
                    // }
                break;
                default:
                    break;
            }
            
        } while (opcao != 4);

    }
    
    public static void menuCartao() {
        Scanner s = new Scanner(System.in);

        System.out.println("------ MENU CARTÃO------");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        System.out.println("Digite a opção desejada: ");        
    }   

    public static void menuFuncoes() {
    Scanner s = new Scanner(System.in);
    
        System.out.println();
        System.out.println("----------- MENU ----------");
        System.out.println("| 1. Listar produtos      |");
        System.out.println("| 2. Fazer pedido         |");
        System.out.println("| 3. Total do pedido      |");
        System.out.println("| 4. Sair                 |");
        System.out.print("| Digite a opção desejada:   ");    
    }
}