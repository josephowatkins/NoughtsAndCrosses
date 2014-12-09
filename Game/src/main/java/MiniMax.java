import java.util.*;

public class MiniMax {

    public Board getNextMove(Board board, Piece player) {

        List<Board> boards = board.getPossibleNextMoves(player);

        List<Pair> results = new ArrayList<>();

        // could make parallel?
        for (Board b : boards) {
            results.add(new Pair(minimax(b, player), b));
        }

        Collections.sort(results, Comparator.comparing(t -> t.score));

        return results.get(results.size() -1).board;
    }

    private int minimax(Board board, Piece player) {

        // if game is over return score: 1 for win, -1 for loss, 0 for draw.
        if (board.hasWon(player)) {
            return 1;
        } else if (board.hasWon(Piece.getOpposition(player))) {
            return -1;
        } else if (board.isDraw()) {
            return 0;
        }

        // get all legal moves for opponent - minimising stage
        List<Board> nextBoards = board.getPossibleNextMoves(Piece.getOpposition(player));

        int bestScore = -1;
        return minimaxHelper(bestScore, nextBoards, Piece.getOpposition(player));
    }

    private int minimaxHelper(int bestScore, List<Board> boards, Piece current) {
        if (boards.isEmpty()) {
            return (-1 * bestScore);
        } else {
            return minimaxHelper(
                    max(bestScore, minimax(boards.remove(0), current)),
                    boards,
                    current
            );
        }
    }

    private int max(int a, int b){
        if (a > b) {
            return a;
        }
        return b;
    }
}
