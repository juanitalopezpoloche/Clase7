import java.util.Scanner;

public class Triqui {

    public static void main(String[] args) {
        char[][] tablero = new char[3][3];
        char jugadorActual = 'X';

        // Llamo al método para inicializar el tablero
        inicializarTablero(tablero);

        // Inicio el juego y finaliza hasta que haya un ganador o empate
        while (true) {

            mostrarTablero(tablero);
            realizarMovimiento(tablero, jugadorActual);

            // Verifico si el jugador actual ha ganado
            if (verificarGanador(tablero, jugadorActual)) {
                mostrarTablero(tablero);
                System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                break;
            }

            // Verifico si el juego terminó en empate
            if (esEmpate(tablero)) {
                mostrarTablero(tablero);
                System.out.println("¡Es un empate!");
                break;
            }

            // Alterno el turno entre jugadores
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';

        }
    }

    // Inicializo el tablero con espacios vacíos
    private static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';  // Espacios vacíos
            }
        }
    }

    // Muestro el estado actual del tablero
    private static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero de juego:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("---|---|---");
        }
    }

    // Permito a un jugador realizar su movimiento
    private static void realizarMovimiento(char[][] tablero, char jugadorActual) {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;

        while (true) {
            System.out.println("Jugador " + jugadorActual + ", ingresa tu movimiento.");
            System.out.print("Fila (0, 1, 2): ");
            fila = scanner.nextInt();
            System.out.print("Columna (0, 1, 2): ");
            columna = scanner.nextInt();

            // Verifico si la celda está vacía y es una posición válida
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;
                break;
            } else {
                System.out.println("Movimiento inválido. La celda está ocupada o fuera del rango.");
            }
        }
    }

    // Verifico si el jugador actual ha ganado
    private static boolean verificarGanador(char[][] tablero, char jugadorActual) {

        // Verifico filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
                return true;  // Fila ganadora
            }
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual) {
                return true;  // Columna ganadora
            }
        }

        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
            return true;  // Diagonal principal
        }

        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
            return true;  // Diagonal secundaria
        }

        return false;

    }

    // Verifico si el tablero está lleno y no hay ganador, lo que resultaría en un empate
    private static boolean esEmpate(char[][] tablero) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;  // Hay al menos una casilla vacía
                }
            }
        }

        return true;  // No hay más casillas vacías
        
    }
}
