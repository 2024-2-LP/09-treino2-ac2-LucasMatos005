package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Livro() {}

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas)
            throws ArgumentoInvalidoException {
        Avaliacao novaAvaliacao = new Avaliacao(descricao, qtdEstrelas);

        if(descricao == null || descricao.isEmpty() || descricao.isBlank() || qtdEstrelas > 5 || qtdEstrelas < 0){
            throw new ArgumentoInvalidoException("Descrição ou qtdEstrelas está fora do padrão");
        } else {
            avaliacoes.add(novaAvaliacao);
        }


    }

    public Double calcularMediaAvaliacoes(){
        if(!avaliacoes.isEmpty()){
            Double somaAvaliacoes = 0.0;
            for (int i = 0; i < avaliacoes.size(); i++) {
                somaAvaliacoes += avaliacoes.get(i).getQtdEstrelas();
            }
            return somaAvaliacoes / avaliacoes.size();
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
