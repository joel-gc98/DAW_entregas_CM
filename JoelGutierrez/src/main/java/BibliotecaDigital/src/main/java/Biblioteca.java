package BibliotecaDigital.src.main.java;

import BibliotecaDigital.src.main.java.clases.Libro;
import BibliotecaDigital.src.main.java.clases.Material;
import BibliotecaDigital.src.main.java.clases.Revista;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Biblioteca {

    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Material> listaMateriales = new ArrayList<>();
    private static Map<Material, Integer> stockMateriales = new LinkedHashMap<>();

    public static void main(String[] args) {

        int opcion;
        do {
            opcion = sc.pedirNumero("===== GESTIÓN DE BIBLIOTECA DIGITAL =====\n" +
                    "1. Registrar Material\n" +
                    "2. Mostrar Stock\n" +
                    "3. Prestar Material\n" +
                    "4. Mostrar Material disponible\n" +
                    "5. Salir");
            switch (opcion) {
                case 1 -> agregarMaterial();
                case 2 -> consultarStock();
                case 3 -> prestarMaterial();
                case 4 -> mostraMateriales();
                case 5 -> System.out.println("Registro finalizado.");
            }
        } while (opcion!=5)   ;
    }

    public static boolean agregarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            System.out.println("MATERIAL REGISTRADO (+1 STOCK)");
            stockMateriales.put(m, stockMateriales.get(m)+1);
            return false;
        } else {
            String titulo = sc.pideTexto("Introduce el titulo del Material: ");
            String autor = sc.pideTexto("Introduce el autor del material: ");
            int anioPublicacion = sc.pedirNumero("Introduce el año de publicacion del material: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                        "\n1. Libro" +
                        "\n2. Revista" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Material libro = new Libro(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el numero de paginas: "));
                        listaMateriales.add(libro);
                        stockMateriales.put(libro, 1);
                        break;
                    case 2:
                        Material revista = new Revista(codigo, titulo, autor, anioPublicacion,
                                sc.pedirNumero("Introduce el numero de edicion: "));
                        listaMateriales.add(revista);
                        stockMateriales.put(revista, 1);
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        }
    }

    public static void consultarStock() {
        for (Map.Entry<Material, Integer> mapa : stockMateriales.entrySet()) {
            Material m = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(m + " Stock: " + valor);
        }
    }

    public static void mostraMateriales() {
        for (Material m : listaMateriales) {
            System.out.println(m.mostrarDetalle());
        }
    }

    public static boolean prestarMaterial() {
        String codigo = getCodigo();
        Material m = getMaterial(codigo);
        if (m != null) {
            int nuevoStock = stockMateriales.get(m);
            //Si el stock llega a 0, lo elimina de lal map y arrayList
            if (nuevoStock - 1 == 0) {
                stockMateriales.remove(m);
                listaMateriales.remove(m);
            } else {
                stockMateriales.put(m, stockMateriales.get(m)-1);
            }
            return true;
        }
        return false;
    }

    private static Material getMaterial(String codigo) {
        for (Material vehiculo : listaMateriales){
            if (vehiculo.getCodigo().equals(codigo)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static String getCodigo() {
        String regex = "^[A-Z]{3}[0-9]{2}$";
        String codigo;

        do {
            System.out.println("EL CODIGO DEBE SEGUIR ESTE PATRON: AAA00");
            codigo = sc.pideTexto("Introduce el codigo: ").toUpperCase();
        } while (!codigo.matches(regex));

        return codigo;
    }
}
