import java.util.*;
import java.util.stream.Collectors;

public final class Board {

    //TODO REMOVE
    public static int getNextBoards = 0;

    /**
     * Representation of the noughts and crosses board. Accessed by board[row][col]:
     *
     * Columns:     0     1     2
     * Row 0:    [[0,0] [0,1] [0,2]
     * Row 1:     [1,0] [1,1] [1,2]
     * Row 2:     [2,0] [2,1] [2,2]]
     */
    private final Piece[][] board;
    private final List<Coordinate> spaces;

    public static final Board EMPTY_BOARD =  new Board();

    public Board(Piece piece, int row, int column) {
        board = new Piece[3][3];

        board[row][column] = piece;
        spaces = getSpacesHelper(board);
    }


    /**
     * Build a board by adding a new piece to an existing board.
     * @param oldBoard Previous board.
     * @param piece Piece: "X" or "O".
     * @param row Row to place new piece.
     * @param column Column to place new piece.
     */
    public Board(Board oldBoard, Piece piece, int row, int column) {

        board = new Piece[3][3];
        Piece[][] base = oldBoard.getBoard();

        for (int r = 0; r < 3; r++) {
            System.arraycopy(base[r], 0, board[r], 0, base[r].length);
        }

        board[row][column] = piece;
        spaces = getSpacesHelper(board);

    }

    // private constructor to make empty board.
    private Board() {
        board = new Piece[3][3];
        spaces = getSpacesHelper(board);
    }


    public List<Board> getPossibleNextMoves(Piece player) {
        getNextBoards++;
        return spaces
                .stream()
                .map(c -> new Board(this, player, c.ROW, c.COLUMN))
                .collect(Collectors.toList());
    }



    public boolean hasWon(Piece player) {
        if (areEqual(board[0][0], board[0][1], board[0][2], player)){
            return true;
        } else if (areEqual(board[1][0], board[1][1], board[1][2], player)) {
            return true;
        } else if (areEqual(board[2][0], board[2][1], board[2][2], player)) {
            return true;
        } else if (areEqual(board[0][0], board[1][0], board[2][0], player)) {
            return true;
        } else if (areEqual(board[0][1], board[1][1], board[2][1], player)) {
            return true;
        } else if (areEqual(board[0][2], board[1][2], board[2][2], player)) {
            return true;
        } else if (areEqual(board[0][0], board[1][1], board[2][2], player)) {
            return true;
        } else if (areEqual(board[0][2], board[1][1], board[2][0], player)) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        return (spaces.size() == 0);
    }

    @Override
    public String toString() {

        return " " + getCell(board[0][0]) + " | " + getCell(board[0][1]) + " | " + getCell(board[0][2]) + " \n"
                + " " + getCell(board[1][0]) + " | " + getCell(board[1][1]) + " | " + getCell(board[1][2]) + " \n"
                + " " + getCell(board[2][0]) + " | " + getCell(board[2][1]) + " | " + getCell(board[2][2]) + " \n";
    }

    /**
     * Private helper methods.
     */
    private Piece[][] getBoard() {
        return board;
    }

    private boolean spaceEmpty(int row, int column) {
        return (board[row][column] != Piece.X) && (board[row][column] != Piece.O);
    }

    private List<Coordinate> getSpacesHelper(Piece[][] board) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (spaceEmpty(r, c)) {
                    Coordinate coordinate = new Coordinate(r, c);
                    coordinates.add(coordinate);
                }
            }
        }
        return coordinates;
    }

    private boolean areEqual(Piece a, Piece b, Piece c, Piece player) {
        return (a == b && b == c && c == player);
    }

    private String getCell(Piece cell) {
        if (cell == null) {
            return "-";
        } else {
            return cell.toString();
        }
    }
}