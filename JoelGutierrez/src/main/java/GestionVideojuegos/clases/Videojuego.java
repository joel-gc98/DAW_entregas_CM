package GestionVideojuegos.clases;

/**
 * Clase Videojuego
 * @author Joel Gutierrez
 * @version 1.0
 */

public class Videojuego {
    private String id;
    private String titulo;
    private Plataforma plataforma;
    private double precio;

    /**
     * @param id
     * @param titulo
     * @param plataforma
     * @param precio
     */
    public Videojuego(String id, String titulo, Plataforma plataforma, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    /**
     * Getter del atributo id
     * @return el id del videojuego
     */
    public String getId() {return id;}

    public String getTitulo() {return titulo;}

    public Plataforma getPlataforma() {return plataforma;}

    public double getPrecio() {
        return precio;
    }

    public void setId(String id) {this.id = id;}

    public void setTitulo(String titulo) {this.titulo = titulo;}

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return String.format("Videojuego: %s - Titulo: %s - Plataforma: %s - Precio: %.2f",
                getId(),
                getTitulo(),
                getPlataforma(),
                getPrecio());
    }
}

