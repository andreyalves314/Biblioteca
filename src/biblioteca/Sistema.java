/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 *
 * @author andrey
 */
public class Sistema {
    
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    ArrayList<Livro> listaLivros = new ArrayList<>();
    Usuario usuarioLogado;
    private static final String SENHA_ADMIN = "1234";
    
    
    public void cadastrarUsuario(Usuario usuario) {
    listaUsuarios.add(usuario);
}

    public void cadastrarLivro(Livro livro) {
    listaLivros.add(livro);
}
    
    public Usuario buscarUsuarioPorNome(String nome) {
    for (Usuario u : listaUsuarios) {
        if (u.getNome().equals(nome)) {
            return u;
        }
    }
    return null;
}

public Livro buscarLivroPorTitulo(String titulo) {
    for (Livro l : listaLivros) {
        if (l.getNome().equals(titulo)) {
            return l;
        }
    }
    return null;
}
    
public void salvarUsuarios() {
    try {
        FileWriter arquivo = new FileWriter("usuarios.txt");
        
        for (Usuario usuario : listaUsuarios) {
            arquivo.write(usuario.getNome() + ";" + usuario.getIdade() + "\n");
        }
        
        arquivo.close();
    } catch (IOException e) {
        System.out.println("Erro ao salvar usuários: " + e.getMessage());
    }
}

public void carregarUsuarios() {
    try {
        BufferedReader leitor = new BufferedReader(new FileReader("usuarios.txt"));
        String linha;
        
        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");
            String nome = dados[0];
            int idade = Integer.parseInt(dados[1]);
            
            listaUsuarios.add(new Usuario(nome, idade));
        }
        
        leitor.close();
    } catch (IOException e) {
        System.out.println("Nenhum arquivo de usuários encontrado. Iniciando lista vazia.");
    }
}

public void salvarLivros() {
    try {
        FileWriter arquivo = new FileWriter("livros.txt");
        
        for (Livro livro : listaLivros) {
            arquivo.write(livro.getNome() + ";" + livro.getAutor() + ";" 
                         + livro.isEmprestado() + ";" + livro.isParaMaiores() + "\n");
        }
        
        arquivo.close();
    } catch (IOException e) {
        System.out.println("Erro ao salvar livros: " + e.getMessage());
    }
}

public void carregarLivros() {
    try {
        BufferedReader leitor = new BufferedReader(new FileReader("livros.txt"));
        String linha;
        
        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");
            String nome = dados[0];
            String autor = dados[1];
            boolean emprestado = Boolean.parseBoolean(dados[2]);
            boolean paraMaiores = Boolean.parseBoolean(dados[3]);
            
            Livro livro = new Livro(nome, autor, paraMaiores);
            livro.setEmprestado(emprestado);
            
            listaLivros.add(livro);
        }
        
        leitor.close();
    } catch (IOException e) {
        System.out.println("Nenhum arquivo de livros encontrado. Iniciando lista vazia.");
    }
}


    public void iniciar(){
   
        carregarUsuarios();
        carregarLivros();        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1 - Entrar como usuário");
    System.out.println("2 - Entrar como administrador");
    int tipoAcesso = scanner.nextInt();
    scanner.nextLine();
    
    if (tipoAcesso == 2) {
        System.out.println("Digite a senha de administrador:");
        String senhaDigitada = scanner.nextLine();
        
        
        if (senhaDigitada.equals(SENHA_ADMIN)) {
            usuarioLogado = new Admin("Admin", 30);
            System.out.println("Acesso de administrador liberado!");
        } else {
            System.out.println("Senha incorreta. Entrando como usuário comum.");
            usuarioLogado = new Usuario("Visitante", 0);
        }
    } else {
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        usuarioLogado = buscarUsuarioPorNome(nome);
        
        if (usuarioLogado == null) {
            System.out.println("Usuário não encontrado.");
        }
    }
        
        boolean continuar = true;
        while(continuar){
            scanner.nextLine();
            System.out.println("Bem vindo ao sistema da Biblioteca Online");
            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Emprestar livro");
            System.out.println("2 - Devolver livro");
            System.out.println("3 - Listar livros disponiveis");
            if(usuarioLogado.podeGerenciarLivros()){
                System.out.println("4 - Cadastrar livros");
                System.out.println("5 - Cadastrar usuario");
            }
            System.out.println("0 - Sair");
            
           int opcao;
    
    try {//código para evitar erros ao digitar uma opção invalida no menu
        opcao = scanner.nextInt();
        scanner.nextLine();
    } catch (InputMismatchException e) {
        System.out.println("Entrada inválida. Digite apenas números.");
        scanner.nextLine();
        continue; // volta para o topo do while, mostrando o menu de novo
    }
            switch(opcao){
                case 1://emprestimo de livros
                scanner.nextLine();
    
            System.out.println("Escolha o livro que voce deseja pegar emprestado:");
    String tituloEmprestimo = scanner.nextLine();
    Livro livroEmprestimo = buscarLivroPorTitulo(tituloEmprestimo);
    
    if (livroEmprestimo == null) {
        System.out.println("Livro não encontrado.");
    } else {
        boolean sucesso = emprestarLivro(usuarioLogado, livroEmprestimo);
        if (sucesso) {
            System.out.println("Aproveite sua leitura!");
            salvarLivros();
        }
        // se não teve sucesso, a mensagem de erro já foi exibida dentro do método
    }
      
                    break;
                    
                case 2://devolução de livros
                   
    System.out.println("Digite o titulo do livro que deseja devolver:");
    String tituloDevolucao = scanner.nextLine();
    Livro livroDevolucao = buscarLivroPorTitulo(tituloDevolucao);
    
   if (livroDevolucao == null) {
    System.out.println("Livro não encontrado.");
} else {
    boolean sucesso = devolverLivro(usuarioLogado, livroDevolucao);
    if (sucesso) {
        System.out.println("Livro devolvido. Obrigado!");
        salvarLivros();
    } else {
        System.out.println("Você não possui esse livro emprestado.");
    }
}
    
                       
                    break;
                    
                case 3://listar livros disponiveis
                    System.out.println("Livros disponiveis no momento:");
                    
                     boolean encontrouAlgum = false;
    
    for (Livro livro : listaLivros) {
        if (!livro.isEmprestado()) {
            System.out.println("- " + livro.getNome());
            encontrouAlgum = true;
        }
    }
    
    if (!encontrouAlgum) {
        System.out.println("Nenhum livro disponível no momento.");
    }
    
                    
                    break;
                    
                case 4://cadstrar livros(opção dispinivel apenas para o admin)
               
        if (usuarioLogado.podeGerenciarLivros()) {
            System.out.println("Digite o nome do livro:");
            String nomeLivro = scanner.nextLine();
            System.out.println("Digite o nome do Autor:");
            String nomeAutor = scanner.nextLine();
            System.out.println("Este livro é para maiores de idade? (S/N)");
            String respostaFaixaEtaria = scanner.nextLine();
            boolean paraMaiores = respostaFaixaEtaria.equalsIgnoreCase("S");
            cadastrarLivro(new Livro(nomeLivro, nomeAutor, paraMaiores));
            salvarLivros();
            System.out.println("Livro cadastrado com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
        break;
        
                case 5://cadastrar usuarios(tambem só o admin)
            
                   if (usuarioLogado.podeGerenciarLivros()) {
                       
            System.out.println("Digite o nome do novo usuario:");
            String nomeNovoUsuario = scanner.nextLine();
            System.out.println("Digite a idade:");
            int idadeNovoUsuario;
            try {//aplicando o try/catch no cadastro de idade
    idadeNovoUsuario = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Idade inválida. Cadastro cancelado.");
    break; // sai do case sem continuar o cadastro
}
            Usuario novoUsuario = new Usuario(nomeNovoUsuario, idadeNovoUsuario);
            cadastrarUsuario(novoUsuario);
            salvarUsuarios();
                       System.out.println("Usuario cadastrado com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
        break; 
                    
                case 0:// fecha a estrutura while e encerra o programa
                    System.out.println("Ate a proxima!");
                    continuar = false;
                    scanner.close();
            }
        }
        
        
    }
    
    public boolean emprestarLivro(Usuario usuario, Livro livro){
    if(usuario.getIdade() < 18 && livro.isParaMaiores()){
        System.out.println("Este livro não está disponivel para a sua faixa etária. Desculpe.");
        return false;
    } else if(livro.isEmprestado()){
        System.out.println("O livro não está disponivel no momento. Desculpe.");
        return false;
    } else {
        usuario.setLivroEmprestado(livro.getNome());
        livro.setEmprestado(true);
        return true;
    }
}
    
    public boolean devolverLivro(Usuario usuario, Livro livro){
    if(usuario.getLivroEmprestado() != null && usuario.getLivroEmprestado().equals(livro.getNome())){
        usuario.setLivroEmprestado("");
        livro.setEmprestado(false);
        return true;
    }
    return false;
}
    
    
}

/*
Deve:
- Fazer a ligação entre os usuarios e os livros, permitindo os emprestimos
- Diferenciar os usuarios comuns do Admin
*/