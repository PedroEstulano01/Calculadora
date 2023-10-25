import java.util.Stack;

public class NotacaoConverter {
    public static String converterInfixaParaPosfixa(String expressao) {
        StringBuilder posfixa = new StringBuilder();
        Stack<Character> pilha = new Stack<>();

        for (char c : expressao.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                posfixa.append(c).append(" ");
            } else if (c == '(') {
                pilha.push(c);
            } else if (c == ')') {
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    posfixa.append(pilha.pop()).append(" ");
                }
                pilha.pop(); // Remover o '(' da pilha
            } else {
                while (!pilha.isEmpty() && precedencia(c) <= precedencia(pilha.peek())) {
                    posfixa.append(pilha.pop()).append(" ");
                }
                pilha.push(c);
            }
        }

        while (!pilha.isEmpty()) {
            posfixa.append(pilha.pop()).append(" ");
        }

        return posfixa.toString().trim();
    }

    private static int precedencia(char operador) {
        if (operador == '+' || operador == '-') {
            return 1;
        } else if (operador == '*' || operador == '/') {
            return 2;
        }
        return 0;
    }
    
    public static String converterPrefixaParaPosfixa(String expressao) {
        StringBuilder posfixa = new StringBuilder();
        Stack<String> pilha = new Stack<>();

        for (int i = expressao.length() - 1; i >= 0; i--) {
            char c = expressao.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                pilha.push(Character.toString(c));
            } else {
                String operando1 = pilha.pop();
                String operando2 = pilha.pop();
                String resultado = operando1 + " " + operando2 + " " + c;
                pilha.push(resultado);
            }
        }

        if (!pilha.isEmpty()) {
            posfixa.append(pilha.pop());
        }

        return posfixa.toString().trim();
    }
}



