public class App {

    static final int N = 8;

    static int[][] tablero = new int[N][N];

    static int soluciones = 0;



    public static void main(String[] args) throws Exception {
        System.out.println("Problema de las 8 Reinas"); 
        resolver(0);
        System.out.println("Número de soluciones: " + soluciones);
    }

    static void resolver(int fila) {
        if (fila == N) {
            soluciones++;
            System.out.println("Solución " + soluciones + ":");
            mostrarTablero();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (esSeguro(fila, col)) {
                tablero[fila][col] = 1;
                resolver(fila + 1);
                tablero[fila][col] = 0; // backtrack
            }
        }
    }

    static boolean esSeguro(int fila, int col) {
        // Verificar la columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 1) {
                return false;
            }
        }
// Verificar la diagonal superior izquierda
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }
// Verificar la diagonal superior derecha
        for (int i = fila, j = col; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    static void mostrarTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
