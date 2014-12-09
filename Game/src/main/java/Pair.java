public class Pair {

    public final int score;
    public final Board board;

    public Pair(int score, Board board) {
        this.score = score;
        this.board = board;
    }

    @Override
    public String toString() {
        return "Score: " + score + "\n, Board: \n" + board.toString();
    }
}
