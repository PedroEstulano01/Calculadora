
import java.util.Stack;

public class Calculadora {
    public static double calcular(double operando1, double operando2, char operador) {
        switch (operador) {
            case '+':
                return operando1 + operando2;
            case '-':
                return operando1 - operando2;
            case '*':
                return operando1 * operando2;
            case '/':
                if (operando2 != 0) {
                    return operando1 / operando2;
                } else {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
            default:
                throw new UnsupportedOperationException("Operador inválido.");
        }
    }
    
      public static double calcularExpressaoPosfixa(String expressao) {
        String[] elementos = expressao.split(" ");
        Stack<Double> pilha = new Stack<>();

        for (String elemento : elementos) {
            if (elemento.matches("-?\\d+(\\.\\d+)?")) {
                pilha.push(Double.parseDouble(elemento));
            } else {
                if (pilha.size() < 2) {
                    throw new UnsupportedOperationException("Faltam operandos para a operação.");
                }
                double operando2 = pilha.pop();
                double operando1 = pilha.pop();
                double resultado = calcular(operando1, operando2, elemento.charAt(0));
                pilha.push(resultado);
            }
        }

        if (pilha.size() != 1) {
            throw new UnsupportedOperationException("A expressão está mal formada.");
        }

        return pilha.pop();
    }
}



