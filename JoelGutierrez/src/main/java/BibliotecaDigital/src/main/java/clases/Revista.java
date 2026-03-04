package BibliotecaDigital.src.main.java.clases;

public class Revista extends clases.Material {
    private int numeroEdicion;

    public Revista(String codigo, String titulo, String autor, int anioPublicacion, int numeroEdicion) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Moto: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                this.getNumeroEdicion());
    }
}
