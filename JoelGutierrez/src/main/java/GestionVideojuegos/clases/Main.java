package GestionVideojuegos.clases;

import GestionVideojuegos.recursos.MyScanner;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static final InventarioVideojuegos inventario = new InventarioVideojuegos();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== GESTION CLIENTES ===" +
                    "\n1. Registrar videojuego" +
                    "\n2. Mostrar Inventario" +
                    "\n3. Mostrar datos videojuego por ID" +
                    "\n4. Guardar inventario en fichero" +
                    "\n5. Cargar inventario en fichero" +
                    "\n6. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    inventario.aggregarVideojuego();
                    break;
                case 2:
                    inventario.mostrarVideojuego();
                    break;
                case 3:
                    gestion.guardarClientes();
                    break;
                case 4:
                    inventario.guardarVideojuego();
                    break;
                case 5:
                    inventario.cargarVideojuego();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 6);
    }
}
