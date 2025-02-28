import java.util.Scanner;

public class Proyecto {
	    // Arrays para guardar datos
	    static String[] nombres = new String[100];
	    static String[] usuarios = new String[100];
	    static String[] claves = new String[100];
	    static int contUsuarios = 0;

	    // Arrays de eventos
	    static String[] nombresEventos = new String[100];
	    static String[] fechasEventos = new String[100];
	    static String[] ubicacionesEventos = new String[100];
	    static int contEventos = 0;

	    // Array de inscripciones
	    static int[][] inscripciones = new int[100][2]; // [usuario, evento]
	    static int contInscripciones = 0;

	    static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        int opcion;
	        do {
	            opcion = mostrarMenu();
	            sc.nextLine(); // Limpia  el buffer

	            switch (opcion) {
	                case 1:
	                    if (!registrarUsuario()) {
	                        System.out.println("No se pudo completar el registro del usuario");
	                    }
	                    break;
	                case 2:
	                    if (!registrarEvento()) {
	                        System.out.println("No se pudo completar el registro del evento");
	                    }
	                    break;
	                case 3:
	                    if (!realizarInscripcion()) {
	                        System.out.println("No se pudo completar la inscripción");
	                    }
	                    break;
	                case 4:
	                    int totalUsuarios = mostrarUsuarios();
	                    System.out.println("Total de usuarios: " + totalUsuarios);
	                    break;
	                case 5:
	                    int totalEventos = mostrarEventos();
	                    System.out.println("Total de eventos: " + totalEventos);
	                    break;
	                case 6:
	                    int totalInscripciones = mostrarInscripciones();
	                    System.out.println("Total de inscripciones: " + totalInscripciones);
	                    break;
	                case 0:
	                    System.out.println("Adios");
	                    break;
	                default:
	                    System.out.println("Opcion no valida");
	            }
	        } while (opcion != 0);
	    }

	    public static int buscarUsuario(String usuario) {
	        for (int i = 0; i < contUsuarios; i++) {
	            if (usuarios[i].equals(usuario)) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public static boolean verificarInscripcionExistente(int indiceUsuario, int indiceEvento) {
	        for (int i = 0; i < contInscripciones; i++) {
	            if (inscripciones[i][0] == indiceUsuario && inscripciones[i][1] == indiceEvento) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public static int mostrarMenu() {
	        System.out.println("\n=== GESTION DE EVENTOS SOSTENIBLES ===");
	        System.out.println("0. Salir");
	        System.out.println("1. Registrar usuario");
	        System.out.println("2. Registrar evento");
	        System.out.println("3. Realizar inscripcion");
	        System.out.println("4. Mostrar usuarios");
	        System.out.println("5. Mostrar eventos");
	        System.out.println("6. Mostrar inscripciones");
	        System.out.print("Seleccione una opcion: ");
	        return sc.nextInt();
	    }

	    public static int mostrarUsuarios() {
	        System.out.println("\n=== USUARIOS REGISTRADOS ===");
	        for (int i = 0; i < contUsuarios; i++) {
	            System.out.println("Usuario " + i + ": " + nombres[i] + " (" + usuarios[i] + ")");
	        }
	        return contUsuarios;
	    }

	    public static int mostrarEventos() {
	        System.out.println("\n=== EVENTOS REGISTRADOS ===");
	        for (int i = 0; i < contEventos; i++) {
	            System.out.println("Evento " + i + ": " + nombresEventos[i]);
	            System.out.println("  Fecha: " + fechasEventos[i]);
	            System.out.println("  Ubicacion: " + ubicacionesEventos[i]);
	        }
	        return contEventos;
	    }

	    public static int mostrarInscripciones() {
	        System.out.println("\n=== INSCRIPCIONES REALIZADAS ===");
	        for (int i = 0; i < contInscripciones; i++) {
	            int indiceUsuario = inscripciones[i][0];
	            int indiceEvento = inscripciones[i][1];
	            System.out.println("Inscripcion " + i + ":");
	            System.out.println("  Usuario: " + nombres[indiceUsuario]);
	            System.out.println("  Evento: " + nombresEventos[indiceEvento]);
	        }
	        return contInscripciones;
	    }

	    public static boolean registrarUsuario() {
	        if (contUsuarios >= 100) {
	            System.out.println("Error. No hay espacio para mas usuarios");
	            return false;
	        }

	        System.out.println("\n=== REGISTRO DE USUARIO ===");
	        System.out.print("Nombre completo: ");
	        String nombre = sc.nextLine();
	        System.out.print("Nombre de usuario: ");
	        String usuario = sc.nextLine();
	        System.out.print("Contrasena: ");
	        String password = sc.nextLine();

	        if (buscarUsuario(usuario) != -1) {
	            System.out.println("Error. El usuario ya existe");
	            return false;
	        }

	        nombres[contUsuarios] = nombre;
	        usuarios[contUsuarios] = usuario;
	        claves[contUsuarios] = password;
	        contUsuarios++;
	        System.out.println("Usuario registrado correctamente");
	        return true;
	    }

	    public static boolean registrarEvento() {
	        if (contEventos >= 100) {
	            System.out.println("Error. No hay espacio para mas eventos");
	            return false;
	        }

	        System.out.println("\n=== REGISTRO DE EVENTO ===");
	        System.out.print("Nombre del evento: ");
	        String nombre = sc.nextLine();
	        System.out.print("Fecha del evento: ");
	        String fecha = sc.nextLine();
	        System.out.print("Ubicacion: ");
	        String ubicacion = sc.nextLine();

	        nombresEventos[contEventos] = nombre;
	        fechasEventos[contEventos] = fecha;
	        ubicacionesEventos[contEventos] = ubicacion;
	        contEventos++;
	        System.out.println("Evento registrado correctamente");
	        return true;
	    }

	    public static boolean realizarInscripcion() {
	        if (contInscripciones >= 100) {
	            System.out.println("Error. No hay espacio para mas inscripciones");
	            return false;
	        }

	        System.out.println("\n=== REALIZAR INSCRIPCION ===");
	        System.out.print("Nombre de usuario: ");
	        String usuario = sc.nextLine();
	        
	        int indiceUsuario = buscarUsuario(usuario);
	        if (indiceUsuario == -1) {
	            System.out.println("Error. Usuario no encontrado");
	            return false;
	        }

	        System.out.println("\nEventos disponibles:");
	        for (int i = 0; i < contEventos; i++) {
	            System.out.println(i + ". " + nombresEventos[i] + " - " + fechasEventos[i]);
	        }

	        System.out.print("Seleccione el numero del evento: ");
	        int indiceEvento = sc.nextInt();

	        if (indiceEvento >= contEventos || indiceEvento < 0) {
	            System.out.println("Error. Evento no valido");
	            return false;
	        }

	        if (verificarInscripcionExistente(indiceUsuario, indiceEvento)) {
	            System.out.println("Error. Ya estas inscrito en este evento");
	            return false;
	        }

	        inscripciones[contInscripciones][0] = indiceUsuario;
	        inscripciones[contInscripciones][1] = indiceEvento;
	        contInscripciones++;
	        System.out.println("Inscripcion realizada correctamente");
	        return true;
	    }
	}

