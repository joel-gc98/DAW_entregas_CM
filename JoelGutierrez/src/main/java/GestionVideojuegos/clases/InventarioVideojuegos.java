package GestionVideojuegos.clases;

import GestionVideojuegos.recursos.MyScanner;
import GestionVideojuegos.recursos.Utilidades;

import java.io.*;
import java.util.ArrayList;

public class InventarioVideojuegos {
    private ArrayList<Videojuego> videojuegos;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.dir") + "/Desktop/DAW/Proyectos/";

    public InventarioVideojuegos() {
        this.videojuegos = new ArrayList<>();
        if (!Utilidades.existeArchivo(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void aggregarVideojuego(){
        String id = getId();
        for (Videojuego v: videojuegos){
            if (v.getId().equals(id)){
                System.out.println("El videojuego ya esta registrado");
                return;
            }
        }
        String titulo = sc.pideTexto("Introduce el titulo del juego: ");
        Plataforma plataforma = Plataforma.valueOf(sc.pideTexto("Introduce la plataforma: "));
        double precio = sc.pedirDecimal("Introduce el precio del juego: ");
        videojuegos.add(new Videojuego(id,titulo,plataforma,precio));
        System.out.println("El videojuego ya esta registrado");
    }

    public void mostrarVideojuego(){
        for (Videojuego v: videojuegos){
            System.out.println(v);
        }
    }

    public void guardarVideojuego(){
        File file = new File(RUTA, "inventario.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){

            for (Videojuego v: videojuegos){
                String linea = v.getId() + ";" + v.getTitulo() + ";" + v.getPlataforma() + ";" + v.getPrecio();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("El videojuegos guardados exitosamente");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void cargarVideojuego(){
        File file = new File(RUTA, "inventario.txt");

        if (!file.exists()){
            System.out.println("El archivo no existe");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            String linea;
            while ((linea = br.readLine()) !=null){
                String[] datos = linea.split(";");
                String id = datos[0];
                String titulo = datos[1];
                Plataforma plataforma = Plataforma.valueOf(datos[2]);
                double precio = Double.parseDouble(datos[3]);
                videojuegos.add(new Videojuego(id, titulo, plataforma, precio));
            }

            System.out.println("Videojuegos cargados exitosamente");

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String getId () {
        String regex = "^[A-Z]{2}[0-9]{2}$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 1 número): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }



}
