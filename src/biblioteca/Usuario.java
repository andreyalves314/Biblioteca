/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author andre
 */
public class Usuario {
    protected String nome;
    protected int idade;
    
    protected String livroEmprestado;

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

    

    public String getLivroEmprestado() {
        return livroEmprestado;
    }

    public void setLivroEmprestado(String livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
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