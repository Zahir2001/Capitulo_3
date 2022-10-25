package Ej3_4;

public class TicTacToe {
    
    // Puedes añadir una nueva variable de instancia para saber si el juego se ha completado.

    public static final int X = 1, O = -1; // jugadores
    public static final int EMPTY = 0; // celda vacía
    private int board[ ][ ] = new int[3][3]; // tablero de juego
    private int player; // jugador actual

    /* Constructor */
    public TicTacToe( ) { clearBoard( ); }
    /* Despeja el tablero */
    public void clearBoard( ) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = EMPTY; // todas las celdas deben estar vacías
        player = X; // el primer jugador es 'X'
    }

    /*Pone una marca X o O en la posición i,j.*/
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2))
            throw new IllegalArgumentException("Posición del tablero no válida");
        if (board[i][j] != EMPTY)
            throw new IllegalArgumentException("Posición del tablero ocupada");
        board[i][j] = player; // colocar la marca para el jugador actual
        player = - player; // cambiar de jugador (utiliza el hecho de que O = - X)
        //if (i || j = winner())
        //   throw new IllegalStateException("Ya esta un ganador");
    }

    /*Comprueba si la configuración del tablero es una victoria para el jugador dado.*/
    public boolean isWin(int mark) {
    return ((board[0][0] + board[0][1] + board[0][2] == mark*3) // fila 0
            || (board[1][0] + board[1][1] + board[1][2] == mark*3) // fila 1
            || (board[2][0] + board[2][1] + board[2][2] == mark*3) // fila 2
            || (board[0][0] + board[1][0] + board[2][0] == mark*3) // columna 0
            || (board[0][1] + board[1][1] + board[2][1] == mark*3) // columna 1
            || (board[0][2] + board[1][2] + board[2][2] == mark*3) // columna 2
            || (board[0][0] + board[1][1] + board[2][2] == mark*3) // diagonal
            || (board[2][0] + board[1][1] + board[0][2] == mark*3)); // rev diag
    }
    
    /*Devuelve el código del jugador ganador, o 0 para indicar un empate (o una partida inacabada).*/
    public int winner( ) {
        if (isWin(X))
            return(X);
        else if (isWin(O))
            return(O);
        else
            return(0);
    }

    /*Devuelve una cadena de caracteres simple que muestra el tablero actual.*/
    public String toString( ) {
        StringBuilder sb = new StringBuilder( );
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                switch (board[i][j]) {
                case X: sb.append("X"); break;
                case O: sb.append("O"); break;
                case EMPTY: sb.append(" "); break;
                }
                if (j < 2) sb.append("|"); // límite de la columna
            }
            if (i < 2) sb.append("\n-----\n"); // límite de la fila
        }
        return sb.toString( );
    }

    /*Prueba de un juego sencillo*/
    public static void main(String[ ] args) {
        TicTacToe game = new TicTacToe( );
        /*X moves: */           /*O moves:*/
        game.putMark(1,1); game.putMark(0,2);
        game.putMark(2,2); game.putMark(0,0);
        game.putMark(0,1); game.putMark(2,1);
        game.putMark(1,2); game.putMark(1,0);
        game.putMark(2,0);
        System.out.println(game);
        int winningPlayer = game.winner( );
        String[ ] outcome = {"O gana", "Empate", "X gana"}; // dependen de la ordenación
        System.out.println(outcome[1 + winningPlayer]);
    }
}
