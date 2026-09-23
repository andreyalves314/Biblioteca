/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

/**
 *
 * @author andre
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    Usuario fulano = new Usuario("Amanda",24, "F");
    Livro l = new Livro("Meu pé de Laranja Lima", "José Mauro de Vasconcelos", true);
    
}

/*
O programa deve:
- Cadastrar o usuario(Nome, idade[posso adicionar uma verificação de idade para livros improprios],
, sexo, genero favorito)
- Cadastrar os livros(Nome, autor, se é improprio para menores)
- Exibir os livros disponiveis
- Realizar o emprestimo do livro(Ligar o usuario ao livro)
- Talvez ter um cadastro para o admin(Para cadstrar os novos livros, diretamente pelo terminal)
- Garantir que um livro já emprestado não seja emprestado de novo
*/
