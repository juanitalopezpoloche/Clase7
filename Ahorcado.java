import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

    // Lista de palabras secretas
    private static String[] palabras = {"java", "desarrollo", "programacion", "computadora", "ahorcado", "codigo", "varibles", "metodos"};

    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = seleccionarPalabra(); // Seleccciona de manera aleatoria de una palabra secreta

        //Creo un array para mostrar las letras adivinadas
        char[] progreso = new char[palabraSecreta.length()];
        for (int i = 0; i < palabraSecreta.length(); i++) {
            progreso[i] = '_'; // Inicializa con guiones bajos
        }

        int intentosFallidos = 0; 
        int maxIntentos      = 6; // Máximo de intentos fallidos (se puede cambiar)

        System.out.println("¡BIENVENIDO AL AHORCADO!\n");
        mostrarEstado(progreso);

        // Inicia el juego del ahorcado
        while (intentosFallidos < maxIntentos) {
            System.out.print("Adivina una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0); // Captura la letra y la convierte a minúsculas

            if (yaFueAdivinada(letra, progreso)) {
                System.out.println("\nYa adivinaste esa letra. Intenta con otra.");
                continue;
            }

            boolean acierto = procesarAdivinanza(letra, palabraSecreta, progreso);

            if (!acierto) {
                intentosFallidos++;
                System.out.println("\n¡Letra incorrecta! Intentos fallidos: " + intentosFallidos + "/" + maxIntentos);
            }

            // Muestro  el estado actual del progreso y la figura del ahorcado
            mostrarEstado(progreso);
            dibujarAhorcado(intentosFallidos);

            if (esPalabraCompleta(progreso)) { // Verifica si el usuario ha adivinado la palabra
                System.out.println("\n¡Felicidades, has ganado! La palabra era: " + palabraSecreta);
                break;
            }
        }

        if (intentosFallidos == maxIntentos) { // El usuario pierde
            System.out.println("\n¡Has perdido! La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }


    public static String seleccionarPalabra() { // Selecciona una palabra aleatoria
        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    public static void mostrarEstado(char[] progreso) { // Muestra el estado actual de la adivinanza
        System.out.print("Palabra: ");
        for (char c : progreso) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean yaFueAdivinada(char letra, char[] progreso) { // Verifica si una letra ya fue adivinada por el usuario
        for (char c : progreso) {
            if (c == letra) {
                return true;
            }
        }
        return false;
    }

    public static boolean procesarAdivinanza(char letra, String palabraSecreta, char[] progreso) {
        boolean acierto = false;
        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                progreso[i] = letra; // Actualiza la letra adivinada en la posición correspondiente
                acierto = true;
            }
        }
        return acierto;
    }

    public static boolean esPalabraCompleta(char[] progreso) { // Verifica si la palabra fue adivinada completamente
        for (char c : progreso) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void dibujarAhorcado(int intentosFallidos) { // Dibuja la figura del ahorcado según los intentos fallidos
        switch (intentosFallidos) {
            case 0:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 1:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 2:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |       |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 3:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 4:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 5:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |      /");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
            case 6:
                System.out.println("   _______");
                System.out.println("  |       |");
                System.out.println("  |       O");
                System.out.println("  |      /|\\");
                System.out.println("  |      / \\");
                System.out.println("  |");
                System.out.println(" _|_");
                break;
        }
    }
}
