import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {


    private final MiniMax m = new MiniMax();

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
        System.out.println("Output board: \n" + m.getNextMove(b5, Piece.X));
    }

    @Test
    public void testEmptyBoardMinimax() {
        System.out.println(m.getNextMove(Board.EMPTY_BOARD, Piece.X));
    }

    @Test
    public void testTimeTakenToScoreAnEmptyBoard() {

        Board b = Board.EMPTY_BOARD;
        double start = time();
        m.getNextMove(b, Piece.O);
        double end = time();

        System.out.println("Time taken: " + (end - start));

    }

    private double time() {
        return System.currentTimeMillis();
    }

    @Test
    public void testWinningBoards() {

        // row 0
        Board b1 = new Board(Piece.X, 0, 0);
        b1 = new Board(b1, Piece.X, 0, 1);
        b1 = new Board(b1, Piece.X, 0, 2);

        Assert.assertTrue(b1.hasWon(Piece.X));

        // row 1
        Board b2 = new Board(Piece.X, 1, 0);
        b2 = new Board(b2, Piece.X, 1, 1);
        b2 = new Board(b2, Piece.X, 1, 2);

        Assert.assertTrue(b2.hasWon(Piece.X));

        // row 2
        Board b3 = new Board(Piece.X, 2, 0);
        b3 = new Board(b3, Piece.X, 2, 1);
        b3 = new Board(b3, Piece.X, 2, 2);

        Assert.assertTrue(b3.hasWon(Piece.X));

        // col 0
        Board b4 = new Board(Piece.X, 0, 0);
        b4 = new Board(b4, Piece.X, 1, 0);
        b4 = new Board(b4, Piece.X, 2, 0);

        Assert.assertTrue(b4.hasWon(Piece.X));

        // col 1
        Board b5 = new Board(Piece.X, 0, 1);
        b5 = new Board(b5, Piece.X, 1, 1);
        b5 = new Board(b5, Piece.X, 2, 1);

        Assert.assertTrue(b5.hasWon(Piece.X));

        // col 3
        Board b6 = new Board(Piece.X, 0, 2);
        b6 = new Board(b6, Piece.X, 1, 2);
        b6 = new Board(b6, Piece.X, 2, 2);

        Assert.assertTrue(b6.hasWon(Piece.X));

        // diagonal top L -> bottom R
        Board b7 = new Board(Piece.X, 0, 0);
        b7 = new Board(b7, Piece.X, 1, 1);
        b7 = new Board(b7, Piece.X, 2, 2);

        Assert.assertTrue(b7.hasWon(Piece.X));

        // diagonal bottom L -> top Right
        Board b8 = new Board(Piece.X, 2, 0);
        b8 = new Board(b8, Piece.X, 1, 1);
        b8 = new Board(b8, Piece.X, 0, 2);

        Assert.assertTrue(b8.hasWon(Piece.X));
    }

    @Test
    public void speedTestString() {

        double start = time();

        for (int i = 0; i < 500000; i ++){
            String s1 = "" + i;
            String s2 = "" + i;
            String s3 = "" + i;
            String s4 = "" + i;
            String s5 = "" + i;
            String s6 = "" + i;
            String s7 = "" + i;
            String s8 = "" + i;
            String s9 = "" + i;
            String[][] array = new String[3][3];

        }

        double end = time();
        System.out.println("Time taken: " + (end - start));

    }

    @Test
    public void testTimeCheckBoard() {
        Board b = new Board(Piece.X, 0, 0);
        b = new Board(b, Piece.O, 0, 1);
        b = new Board(b, Piece.X, 0, 2);
        b = new Board(b, Piece.O, 1, 0);
        b = new Board(b, Piece.X, 1, 1);
        b = new Board(b, Piece.O, 1, 2);
        b = new Board(b, Piece.X, 2, 0);
        b = new Board(b, Piece.O, 2, 1);
        b = new Board(b, Piece.X, 2, 2);
        System.out.println(b);

        double start = time();
        for (int i = 0; i < 500000; i++) {
            b.isDraw();
        }
        double end = time();
        System.out.println("Time take: " + (end - start));
    }
}
