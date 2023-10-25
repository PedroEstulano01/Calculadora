
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a notação da expressão:");
        System.out.println("1 - Pós-fixa");
        int opcao = scanner.nextInt();

        System.out.println("Digite a expressão:");
        String expressao = scanner.nextLine();

        double resultado;

        switch (opcao) {
            case 1:
                resultado = Calculadora.calcularExpressaoPosfixa(expressao);
                break;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }

        System.out.println("Resultado: " + resultado);
    }
}