package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    private Integer moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
    }

    public ChessPosition getChessPosition() throws ChessException {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) throws BoardException {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;

    }
}
