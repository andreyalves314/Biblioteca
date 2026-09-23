/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author andre
 */
public class Sistema {
    
    
    
    
    public void iniciar(){
        
    }
    
    public void emprestarLivro(Usuario usuario, Livro livro){
    if(usuario.getIdade() <18 && livro.isParaMaiores() == true){
        System.out.println("Este livro não está disponivel para a sua faixa etária. Desculpe.");
    } else if(usuario.getIdade()>18){
        if(livro.isEmprestado() == false){
            usuario.setLivroEmprestado(livro.getNome());
            livro.setEmprestado(true);
        }else if(livro.isEmprestado()){
            System.out.println("O livro não está disponivel no momento. Desculpe.");
        }
    }   
    }
    
    public void devolverLivro(Usuario usuario, Livro livro){
        if(usuario.getLivroEmprestado() != null && usuario.getLivroEmprestado().equals(livro.getNome())){
            usuario.setLivroEmprestado(""); //Obs: é possivel tambem usar "null", mas dá erro ao chaamr o metodo "getLivroEmprestado" na classe principal.
            livro.setEmprestado(false);
        }
        
        
        
    }
    
    
}

/*
Deve:
- Fazer a ligação entre os usuarios e os livros, permitindo os emprestimos
- Diferenciar os usuarios comuns do Admin
*/