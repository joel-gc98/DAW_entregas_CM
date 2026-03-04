package BibliotecaDigital.src.main.java.clases;

public class Libro extends clases.Material {

    private int numeroPaginas;

    public Libro(String codigo, String titulo, String autor, int anioPublicacion, int numeroPaginas) {
        super(codigo, titulo, autor, anioPublicacion);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarDetalle() {
        return String.format("Libro: %s, %s, %s, %d, %d",
                super.getCodigo(),
                super.getTitulo(),
                super.getAutor(),
                super.getAnioPublicacion(),
                this.getNumeroPaginas());
    }
}
