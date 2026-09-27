/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

/**
 *
 * @author andre
 */
public class Admin extends Usuario{
    private String senha;
    
    public Admin(String nome, int idade) {
        super(nome, idade);
        this.senha = senha;
    }
    
    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }
    
    @Override
    public boolean podeGerenciarLivros() {
        return true; // admin sempre pode
    }
    
    
}


/*
Deve:
- Herdar de Usuario
- Cadastrar os livros
- Ter uma verificação por senha para acesso
*/