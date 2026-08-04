import java.util.Stack;

public class CaixaDeLivros {
    
    private Stack<Livro> pilha;

    public CaixaDeLivros(){
        this.pilha = new Stack<>();
    }
    //adicionar no topo
    public void empilhar(Livro livro){
        this.pilha.push(livro);
        System.out.println("Livro colocado na caixa");
    }
    //remove e retorna o do topo
    public Livro desempilhar(){
        return this.pilha.pop();
        
    }
    //mostra o topo sem remover
    public Livro topo(){
        return this.pilha.peek();
    }
    //verificar se está vazio
    public boolean isEmpty(){
        return this.pilha.isEmpty();
    }




}
