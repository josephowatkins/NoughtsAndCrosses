public enum Piece {

    X, O;

    public static Piece getOpposition(Piece player) {
        if (player == Piece.X) {
            return Piece.O;
        } else {
            return Piece.X;
        }
    }

    @Override
    public String toString() {
        return this.name();
    }
}
