/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class Usuario {
    private String nome;
    private int idade;
    private ArrayList<String> livrosEmprestados = new ArrayList<>();

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    

    public ArrayList<String> getLivrosEmprestados() {
        return livrosEmprestados;
    }
    
    public void adicionarLivroEmprestado(String nomeLivro) {
        livrosEmprestados.add(nomeLivro);
    }
    
    public void removerLivroEmprestado(String nomeLivro) {
        livrosEmprestados.remove(nomeLivro);
    }
    
    public boolean temLivroEmprestado(String nomeLivro) {
        return livrosEmprestados.contains(nomeLivro);
    }
    
    public boolean podeGerenciarLivros() {
        return false; // usuário comum nunca pode
    }    
    
    
}

/*
Deve conter:
- Nome
- Idade
- Getters e Setters
- Construtor?
- Metodos(Pegar livro, devolver livro)
*/