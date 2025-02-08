import java.util.Random;

public class Utilitaria {
    
     public static final Random RANDOM = new Random();   

     public static String gerarCodigo() {
     String letras = "abcdefghijklmnopqrstuvwxyz";
     String numeros = "1234567890";
     StringBuilder codigo = new StringBuilder(2);

     for(int i = 0; i < 1; i++) { 
          int index = RANDOM.nextInt(letras.length()); 
          codigo.append(letras.charAt(index));
     }

     for(int i = 0; i < 1; i++) {
          int index = RANDOM.nextInt(numeros.length());
          codigo.append(numeros.charAt(index));
     }
     return codigo.toString();
    }

     public static int gerarPedido() {
        int pedido = RANDOM.nextInt(100);
        return pedido;
    }
}