import java.util.Stack;

public class Pilha {
    private Stack<Double> pilha;

    public Pilha() {
        pilha = new Stack<>();
    }

    public void empilhar(double valor) {
        pilha.push(valor);
    }

    public double desempilhar() {
        if (!pilha.isEmpty()) {
            return pilha.pop();
        }
        throw new UnsupportedOperationException("A pilha está vazia.");
    }

    public boolean vazia() {
        return pilha.isEmpty();
    }
}
