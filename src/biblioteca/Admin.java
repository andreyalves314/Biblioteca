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
    
    public Admin(String nome, int idade, String sexo) {
        super(nome, idade, sexo);
    }
    
}

/*
Deve:
- Herdar de Usuario
- Cadastrar os livros
- Ter uma verificação por senha para acesso
*/