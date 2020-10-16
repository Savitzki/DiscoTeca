package model.bean;

/**
 *
 * @author Marina Savitzki
 */
public class Disco {
    
    private int id;
    private String nome;
    private int ano_lancamento;
    private String artista_banda;
    private ListaMusica musicas;

    public Disco() {
    }

    public Disco(int id, String nome, int ano_lancamento, String artista_banda, ListaMusica musicas) {
        this.id = id;
        this.nome = nome;
        this.ano_lancamento = ano_lancamento;
        this.artista_banda = artista_banda;
        this.musicas = musicas;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    public String getArtista_banda() {
        return artista_banda;
    }

    public void setArtista_banda(String artista_banda) {
        this.artista_banda = artista_banda;
    }

    public ListaMusica getMusicas() {
        return musicas;
    }

    public void setMusicas(ListaMusica musicas) {
        this.musicas = musicas;
    }


    
}
