package model.bean;

/**
 *
 * @author Marina Savitzki
 */
public class Musica {
    
    private int id;
    private String titulo;
    private String duracao;

    public Musica() {
    }

    public Musica(int id, String titulo, String duracao) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    
}
