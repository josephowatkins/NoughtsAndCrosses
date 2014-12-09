import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {


    @Test
    public void testPrint() {
        Board b = new Board(Piece.X, 0, 0);
        System.out.println(b);

        Board b1 = new Board(b, Piece.O, 1, 1);
        System.out.println(b1);

    }

    @Test
    public void testGetNextBoards() {
        Board b = new Board(Piece.X, 0, 0);
        // should generate 8 possible moves.
        assertEquals(8, b.getPossibleNextMoves(Piece.O).size());

    }

    @Test
    public void testKnownResultsMinimax() {
        Board b0 = new Board(    Piece.X, 0, 0);
        Board b1 = new Board(b0, Piece.O, 1, 1);
        Board b2 = new Board(b1, Piece.X, 0, 1);
        Board b3 = new Board(b2, Piece.O, 0, 2);
        Board b4 = new Board(b3, Piece.X, 1, 2);
        Board b5 = new Board(b4, Piece.O, 2, 1);
        //Board b6 = new Board(b5, Piece.X, 1, 0);

        System.out.println("Input board: \n" + b5);
        MiniMax m = new MiniMax();
        System.out.println("Output board: \n" + m.getNextMove(b5, Piece.X));
    }

    @Test
    public void testEmptyBoardMinimax() {
        MiniMax m = new MiniMax();
        System.out.println(m.getNextMove(Board.EMPTY_BOARD, Piece.X));
    }
}
