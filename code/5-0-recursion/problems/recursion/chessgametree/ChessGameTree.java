package recursion.chessgametree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;


/**
 *
 */
public class ChessGameTree {

	private static int uniqueIdCounter = 1000;
	public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
		int games = Integer.parseInt(in.nextLine());
		for (int i = 0; i < games; i++) {
            uniqueIdCounter = 1000;
            ChessGameTree tree = new ChessGameTree();
			tree.process(in);
		}
	}

	private void process(Scanner in) throws Exception {
		int noOfWhitePieces = 0;
		int noOfBlackPieces = 0;
		int maxMoves = 0;
		String[] wbm = in.nextLine().split(" ");
		noOfWhitePieces = Integer.parseInt(wbm[0]);
		noOfBlackPieces = Integer.parseInt(wbm[1]);
		maxMoves = Integer.parseInt(wbm[2]);
		Map<String, Position> initialState = new HashMap<String, Position>(noOfWhitePieces + noOfBlackPieces);

		int knightId = 1, rookIdId = 1, bishopId = 1;
		for (int j = 0; j < noOfWhitePieces; j++) {
			String[] whitePiecePos =in.nextLine().split(" ");
			Position position = new Position(whitePiecePos[2].charAt(0), whitePiecePos[1].charAt(0));

			Piece piece = null;
			if (whitePiecePos[0].charAt(0) == 'B')
				piece = new Piece(true, whitePiecePos[0], (bishopId++));
			else if (whitePiecePos[0].charAt(0) == 'N') {
				piece = new Piece(true, whitePiecePos[0], (knightId++));
			} else if (whitePiecePos[0].charAt(0) == 'R')
				piece = new Piece(true, whitePiecePos[0], (rookIdId++));
			else
				piece = new Piece(true, whitePiecePos[0], (1));

			initialState.put(piece.getRepresentation(), position);
		}

		/**
		 * t c r, where is a character denoting the type of piece (where is
		 * Queen, is Knight, is Bishop, and is Rook), and and denote the
		 * respective column and row on the board
		 **/
		knightId = 1;
		rookIdId = 1;
		bishopId = 1;
		for (int j = 0; j < noOfBlackPieces; j++) {
			String[] blackPiecePos = in.nextLine().split(" ");
			Position position = new Position(blackPiecePos[2].charAt(0), blackPiecePos[1].charAt(0));

			Piece piece = null;
			if (blackPiecePos[0].charAt(0) == 'B')
				piece = new Piece(false, blackPiecePos[0], (bishopId++));
			else if (blackPiecePos[0].charAt(0) == 'N')
				piece = new Piece(false, blackPiecePos[0], (knightId++));
			else if (blackPiecePos[0].charAt(0) == 'R')
				piece = new Piece(false, blackPiecePos[0], (rookIdId++));
			else
				piece = new Piece(false, blackPiecePos[0], (1));

			initialState.put(piece.getRepresentation(), position);
		}

		solveMinMax(initialState, noOfWhitePieces, noOfBlackPieces, maxMoves);

	}

	private void solveMinMax(Map<String, Position> initialState, int noOfWhitePieces, int noOfBlackPieces,
			int maxMoves) {

		Node rootNode = new Node(0, false, initialState);
		recursiveCalcMoves(rootNode, maxMoves, 0);
		recursiveMinMax(rootNode);
		
		if(100-rootNode.score <=maxMoves)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

	private void recursiveMinMax(Node node) {
		// System.out.println("Min Max" + node.toString());
		if (node.isLeaf)
			return;

		if (node.children == null) {
			node.score = calcLeafNodeScore(node.isWhite, node.level);
			return;
		}

		Node[] children = node.children;
		for (Node child : children) {
			recursiveMinMax(child);
		}

		if (node.isWhite || node.level == 0)
			node.score = findMaxScore(children);
		else
			node.score = findMinScore(children);
	}

	private int findMaxScore(Node[] children) {
		int max = Integer.MIN_VALUE;
		if (children != null) {
			max = children[0].score;
			for (Node childNode : children) {
				if (childNode.score > max)
					max = childNode.score;
			}
		}
		return max;
	}

	private int findMinScore(Node[] children) {
		int min = Integer.MAX_VALUE;
		if (children != null) {
			min = children[0].score;
			for (Node childNode : children) {
				if (childNode.score < min)
					min = childNode.score;
			}
		}
		return min;
	}

	private void recursiveCalcMoves(Node node, int maxMoves, int level) {

		if (node.isLeaf)
			return;

		if (level > maxMoves) {
			return;
		}

		Map<String, Position> currentState = node.state;
		List<Map<String, Position>> totalPossibleSates = new ArrayList<>();
		for (String pieceRep : currentState.keySet()) {
			Piece piece = new Piece(pieceRep);
			if (piece.isWhite != node.isWhite) {
				List<Map<String, Position>> possibleSates = calculateAllPossiblePositionsOfPiece(piece, currentState);
				totalPossibleSates.addAll(possibleSates);
			}
		}

		Node[] children = new Node[totalPossibleSates.size()];
		for (int i = 0; i < totalPossibleSates.size(); i++) {
			Map<String, Position> aPosibleState = totalPossibleSates.get(i);
			Node childNode = null;
			if (isOpponentQueenCaptured(!node.isWhite, aPosibleState))
				childNode = new Node(level + 1, !node.isWhite, aPosibleState,
						calcLeafNodeScore(!node.isWhite, level + 1));
			else
				childNode = new Node(level + 1, !node.isWhite, aPosibleState);

			childNode.parent = node;
			childNode.parentId = node.uniqueId;
			recursiveCalcMoves(childNode, maxMoves, level + 1);
			children[i] = childNode;
		}
		node.children = children;
	}

	public int calcLeafNodeScore(boolean isWhite, int level) {
		if (isWhite)
			return (100 - level);
		else
			return (level - 100);
	}

	public boolean isOpponentQueenCaptured(boolean isWhite, Map<String, Position> state) {
		Piece opponentQueen = new Piece(!isWhite, "Q", 1);

		Position opponentQueenPos = state.get(opponentQueen.getRepresentation());
		if (opponentQueenPos != null)
			return false;
		else
			return true;
	}

	/**
	 * Multi Child tree to represent Minimax game tree
	 *
	 */
	class Node {

		Node[] children = null;
		Node parent;

		int uniqueId;
		int parentId;

		int level;
		/**
		 * isWhite represents MAX & !isWhite represents MIN in Minimax game tree
		 **/
		boolean isWhite;
		Map<String, Position> state;
		boolean isLeaf;
		int score;

		/**
		 * Node representing the Terminal node in Minimax game tree.Doesnt need
		 * a score
		 **/
		public Node(int level, boolean isWhite, Map<String, Position> state) {
			this.uniqueId = uniqueIdCounter++;
			this.level = level;
			this.isWhite = isWhite;
			this.state = state;
			this.isLeaf = false;
		}

		/**
		 * Node representing the Terminal node in Minimax game tree. Needs a
		 * score
		 **/
		public Node(int level, boolean isWhite, Map<String, Position> state, int score) {
			this.uniqueId = uniqueIdCounter++;
			this.level = level;
			this.isWhite = isWhite;
			this.state = state;
			this.isLeaf = true;
			this.score = score;
		}

		@Override
		public String toString() {
			int noOfChildren = 0;
			if (children != null)
				noOfChildren = children.length;

			return "Node [uniqueId=" + uniqueId + ", parentId=" + parentId + ", level=" + level + ", isWhite=" + isWhite
					+ ", isLeaf=" + isLeaf + ", score=" + score + ", noOfChildren=" + noOfChildren + "]";
		}

	}

	public List<Map<String, Position>> calculateAllPossiblePositionsOfPiece(Piece piece,
			Map<String, Position> currentState) {
		int m = 4, n = 4;
		Map<String, Position> duplicateState = deepClone(currentState);
		Position currentPos = duplicateState.get(piece.getRepresentation());

		List<Position> possiblePosList = new ArrayList<>();
		String[][] currentBoard = createBoard(duplicateState);
		if (piece.type.equalsIgnoreCase("R")) {
			estimateParallelMove(currentPos, possiblePosList, piece, currentBoard);
		} else if (piece.type.equalsIgnoreCase("B")) {
			estimateDiagonalMove(currentPos, possiblePosList, piece, currentBoard);
		} else if (piece.type.equalsIgnoreCase("N")) {
			estimateKnightMove(currentPos, possiblePosList, piece, currentBoard);
		} else if (piece.type.equalsIgnoreCase("Q")) {
			estimateParallelMove(currentPos, possiblePosList, piece, currentBoard);
			estimateDiagonalMove(currentPos, possiblePosList, piece, currentBoard);
		}


		List<Map<String, Position>> possibleSates = new ArrayList<>(possiblePosList.size());

		for (Position updatedPosition : possiblePosList) {
			Map<String, Position> clonedState = deepClone(duplicateState);
			clonedState.remove(piece.getRepresentation());
			clonedState.put(piece.getRepresentation(), updatedPosition);
			captureIfNecessary(piece, clonedState, currentBoard, updatedPosition);
			possibleSates.add(clonedState);
		}
		return possibleSates;
	}

	/**
	 * Does the updatedPosition is a capture of an item of opposite color & the
	 * same position
	 * 
	 * @param piece
	 * @param currentState
	 * @param updatedPosition
	 * @return
	 */
	public void captureIfNecessary(Piece piece, Map<String, Position> currentState, String[][] currentBoard,
			Position updatedPosition) {
		Piece currentPieceInPos = currentPieceInPosition(currentBoard, updatedPosition);
		if ((currentPieceInPos != null) && piece.isWhite != currentPieceInPos.isWhite) {
			currentState.remove(currentPieceInPos.getRepresentation());
		}
	}

	public void estimateKnightMove(Position currentPos, List<Position> possiblePosList, Piece piece,
			String[][] currentBoard) {
		
		// default => p < m && p >= 0 && q < n && q >= 0
		int m = 4, n = 4;

		// down - right
		int p = currentPos.x;
		int q = currentPos.y;

		if (p < m - 2 && p >= 0 && q < n - 1 && q >= 0) {
			Position updatedPosition = new Position(p + 2, q + 1);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		if (p < m - 1 && p >= 0 && q < n - 2 && q >= 0) {
			Position updatedPosition = new Position(p + 1, q + 2);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		// down - left
		if (p < m - 2 && p >= 0 && q < n && q >= 1) {
			Position updatedPosition = new Position(p + 2, q - 1);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		if (p < m - 1 && p >= 0 && q < n && q >= 2) {
			Position updatedPosition = new Position(p + 1, q - 2);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		// up - right
		if (p < m && p >= 1 && q < n - 2 && q >= 0) {
			Position updatedPosition = new Position(p - 1, q + 2);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		if (p < m && p >= 2 && q < n - 1 && q >= 0) {
			Position updatedPosition = new Position(p - 2, q + 1);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		// up - left
		if (p < m && p >= 1 && q < n && q >= 2) {
			Position updatedPosition = new Position(p - 1, q - 2);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

		if (p < m && p >= 2 && q < n && q >= 1) {
			Position updatedPosition = new Position(p - 2, q - 1);
			if (!conflict(piece, currentBoard, updatedPosition)) {
				possiblePosList.add(updatedPosition);
			}
		}

	}

	public void estimateDiagonalMove(Position currentPos, List<Position> possiblePosList, Piece piece,
			String[][] currentBoard) {
		int m = 4, n = 4;
		// down - right
		int p = currentPos.x;
		int q = currentPos.y;
		while (p < m - 1 && p >= 0 && q < n - 1 && q >= 0) {
			Position updatedPosition = new Position(++p, ++q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}

		// down - left
		p = currentPos.x;
		q = currentPos.y;
		while (p < m - 1 && p >= 0 && q < n && q > 0) {
			Position updatedPosition = new Position(++p, --q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}

		// up - right
		p = currentPos.x;
		q = currentPos.y;
		while (p < m && p > 0 && q < n - 1 && q >= 0) {
			Position updatedPosition = new Position(--p, ++q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}

		// up - left
		p = currentPos.x;
		q = currentPos.y;
		while (p < m && p > 0 && q < n && q > 0) {
			Position updatedPosition = new Position(--p, --q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}
	}

	public void estimateParallelMove(Position currentPos, List<Position> possiblePosList, Piece piece,
			String[][] currentBoard) {
		int m = 4, n = 4;
		// down
		int p = currentPos.x;
		int q = currentPos.y;
		while (p < m - 1 && p >= 0 && q < n && q >= 0) {
			Position updatedPosition = new Position(++p, q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}
		// up
		p = currentPos.x;
		q = currentPos.y;
		while (p < m && p > 0 && q < n && q >= 0) {
			Position updatedPosition = new Position(--p, q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}

		// right
		p = currentPos.x;
		q = currentPos.y;
		while (p < m && p >= 0 && q < n - 1 && q >= 0) {
			Position updatedPosition = new Position(p, ++q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}

		// left
		p = currentPos.x;
		q = currentPos.y;
		while (p < m && p >= 0 && q < n && q > 0) {
			Position updatedPosition = new Position(p, --q);
			if (conflict(piece, currentBoard, updatedPosition)) {
				break;
			}
			possiblePosList.add(updatedPosition);
		}
	}

	/**
	 * Provide a deep clone of the current state Otherwise in recursion the
	 * references will get messed up
	 * 
	 * @param state
	 * @return
	 */
	public Map<String, Position> deepClone(Map<String, Position> state) {
		Map<String, Position> clonedState = new HashMap<String, Position>(state.size());
		for (Entry<String, Position> entry : state.entrySet()) {
			clonedState.put(entry.getKey(), new Position(entry.getValue()));
		}
		return clonedState;
	}

	/**
	 * Does the updatedPosition have Conflict with same color & position
	 * 
	 * @param piece
	 * @param currentState
	 * @param updatedPosition
	 * @return
	 */
	public boolean conflict(Piece piece, String[][] currentBoard, Position updatedPosition) {
		Piece currentPieceInPos = currentPieceInPosition(currentBoard, updatedPosition);
		if ((currentPieceInPos != null) && (piece.isWhite == currentPieceInPos.isWhite))
			return true;
		return false;
	}

	public Piece currentPieceInPosition(String[][] currentBoard, Position updatedPosition) {
		String boardEntry = currentBoard[updatedPosition.x][updatedPosition.y];
		if (!boardEntry.equalsIgnoreCase("xxx"))
			return new Piece(boardEntry.trim());
		else
			return null;
	}

	class Piece {
		boolean isWhite;
		String type;
		boolean isQueen;
		int id;

		public Piece(Piece source) {
			this.isWhite = source.isWhite;
			this.type = source.type;
		}

		public Piece(boolean isWhite, String type, int id) {
			super();
			this.isWhite = isWhite;
			this.type = type;
			this.id = id;
		}

		public Piece(String representation) {
			if (representation.substring(0, 1).equalsIgnoreCase("W"))
				this.isWhite = true;
			else
				this.isWhite = false;
			this.type = representation.substring(1, 2);
			if (this.type.equalsIgnoreCase("Q"))
				this.isQueen = true;
			else
				this.isQueen = false;

			this.id = Integer.parseInt(representation.substring(2, 3));
		}

		public String getRepresentation() {
			if (isWhite)
				return "W" + type + id;
			else
				return "B" + type + id;
		}
	}

	class Position {
		int x;
		int y;

		// only used for input
		public Position(char x, char y) {
			switch (y) {
			case 'A':
				this.y = 0;
				break;
			case 'B':
				this.y = 1;
				break;
			case 'C':
				this.y = 2;
				break;
			case 'D':
				this.y = 3;
				break;
			}

			this.x = 4 - Integer.parseInt(String.valueOf(x));
		}

		/** Copy Constructor **/
		public Position(Position source) {
			this.x = source.x;
			this.y = source.y;
		}

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}

	private String[][] createBoard(Map<String, Position> state) {
		int m = 4, n = 4;
		String[][] board = new String[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = "xxx";
			}
		}

		for (Entry<String, Position> entry : state.entrySet()) {
			board[entry.getValue().x][entry.getValue().y] = entry.getKey();
		}
		return board;
	}

	private void printBoard(Map<String, Position> state, String suffix) {
		int m = 4, n = 4;
		String[][] board = createBoard(state);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String element = board[i][j];
				System.out.print(element + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


}
