package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {}

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) throws ArgumentoInvalidoException {
        if(livro == null || livro.getTitulo() == null || livro.getTitulo().isBlank() || livro.getAutor() == null || livro.getAutor().isBlank() || livro.getDataPublicacao() == null){
            throw new ArgumentoInvalidoException("Livro inválido");
        } else {
            livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo) throws LivroNaoEncontradoException {
        for (int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getTitulo() != null && !livros.get(i).getTitulo().isEmpty() || livros.get(i).getTitulo().isBlank() || !livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                throw new LivroNaoEncontradoException("Livro inválido");
            } else {
                this.livros.remove(livros.get(i));
            }
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) throws LivroNaoEncontradoException{
            for (int i = 0; i < livros.size(); i++) {
                if(livros.get(i).getTitulo() == null || livros.get(i).getTitulo().isBlank() || livros.get(i).getTitulo().isEmpty()){
                    throw new LivroNaoEncontradoException("Livro não encontrado");
                } else if(livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                    return livros.get(i);
                }
            }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosAno = new ArrayList<>();
        for (int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getDataPublicacao().getYear() == ano){
                livrosAno.add(livros.get(i));
            }
        }
        return livrosAno;
    }

    public List<Livro> retornarTopCincoLivros(){
        return null;
    }
}
