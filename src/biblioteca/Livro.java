/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author andre
 */
public class Livro {
    private String nome;
    private String autor;
    private boolean emprestado;
    private boolean paraMaiores;

    public Livro(String nome, String autor, boolean paraMaiores) {
        this.nome = nome;
        this.autor = autor;
        this.paraMaiores = paraMaiores;
        this.emprestado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public boolean isParaMaiores() {
        return paraMaiores;
    }

    public void setParaMaiores(boolean paraMaiores) {
        this.paraMaiores = paraMaiores;
    }
    
    
    
}

/*
Deve conter:
- Nome
- Autor
- Se é improprio para menores
- Se ja está emprestado
- Getters e Setters
- Construtor

*/