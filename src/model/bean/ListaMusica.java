package model.bean;

/**
 *
 * @author Marina Savitzki
 */
public class ListaMusica {
    private int idDisco;
    private int idMusica;

    public ListaMusica() {
    }

    public ListaMusica(int idDisco, int idMusica) {
        this.idDisco = idDisco;
        this.idMusica = idMusica;
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }
    
    
}
