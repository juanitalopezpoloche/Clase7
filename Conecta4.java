import java.util.Scanner;

public class Conecta4 {
    // Tablero de 6 filas por 7 columnas
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] tablero = new char[6][7];
        inicializarTablero(tablero);
        mostrarTablero(tablero);
        
        char jugadorActual = 'X'; // El primer jugador es 'X'
        boolean juegoTerminado = false;
        
        while (!juegoTerminado) {
            System.out.println("Turno del jugador " + jugadorActual);
            System.out.print("Elige una columna (1-7): ");
            int columna = scanner.nextInt() - 1; // Resto 1 para ajustar al índice del arreglo
            
            if (columna >= 0 && columna < 7 && !columnaLlena(columna, tablero)) {
                // Si la columna no está llena, coloco la ficha
                colocarFicha(columna, jugadorActual, tablero);
                mostrarTablero(tablero);
                
                // Verifico si el jugador actual ha ganado
                if (verificarGanador(jugadorActual, tablero)) {
                    System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                    juegoTerminado = true;
                } else if (esEmpate(tablero)) {
                    // Verifico si hay empate
                    System.out.println("¡Empate! El tablero está lleno.");
                    juegoTerminado = true;
                } else {
                    // Cambio de turno
                    jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
                }
            } else {
                // Si la columna es inválida o está llena
                System.out.println("Columna inválida o llena. Intenta nuevamente.");
            }
        }
        
        scanner.close();
    }

    // Inicializo el tablero con espacios vacíos
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tablero[i][j] = ' '; // Espacio vacío
            }
        }
    }

    // Muestro el tablero en consola
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print("|" + tablero[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("---------------");
    }

    // Colocar la ficha en la columna seleccionada
    public static void colocarFicha(int columna, char jugador, char[][] tablero) {
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][columna] == ' ') {
                tablero[i][columna] = jugador;
                break;
            }
        }
    }

    // Verificar si la columna está llena
    public static boolean columnaLlena(int columna, char[][] tablero) {
        return tablero[0][columna] != ' ';
    }

    // Verifico si hay un ganador
    public static boolean verificarGanador(char jugador, char[][] tablero) {
        // Compruebo en todas las direcciones posibles: Horizontal, Vertical, Diagonal (de arriba a abajo y de abajo a arriba)
        
        // Horizontal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j] == jugador && tablero[i][j + 1] == jugador && tablero[i][j + 2] == jugador && tablero[i][j + 3] == jugador) {
                    return true;
                }
            }
        }
        
        // Vertical
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j] == jugador && tablero[i + 2][j] == jugador && tablero[i + 3][j] == jugador) {
                    return true;
                }
            }
        }
        
        // Diagonal hacia abajo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j] == jugador && tablero[i + 1][j + 1] == jugador && tablero[i + 2][j + 2] == jugador && tablero[i + 3][j + 3] == jugador) {
                    return true;
                }
            }
        }
        
        // Diagonal hacia arriba
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j] == jugador && tablero[i - 1][j + 1] == jugador && tablero[i - 2][j + 2] == jugador && tablero[i - 3][j + 3] == jugador) {
                    return true;
                }
            }
        }
        
        return false;
    }

    // Verifico si es empate (el tablero está lleno)
    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 7; i++) {
            if (tablero[0][i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
