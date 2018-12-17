public class NQueens {

	public static void main(String[] args) {
		int N = 8;
        placeQueen(new Board(N), 1, N);
	}


	public static boolean placeQueen(Board b, int row, int numQ) {
		if (numQ == 0) return true;
		if (row > b.N) return false;

		Pair pos = findPosition(b, row);
		if (pos == null) {
			return false;
		}

		do {
			Board b2 = b.copy();
			updateBoard(b2, pos);
			if (placeQueen(b2, row + 1, numQ - 1)) return true;
		} while (next(pos) != null);

		//TODO
		return false;
	}

	private static Object next(Pair pos) {
		//TODO
		return null;
	}

	private static void updateBoard(Board b2, Pair pos) {
		//TODO
	}

	private static Pair findPosition(Board b, int row) {
		for (int i = 1; i <= b.N; i++) {
			if (b.get(row,i) == 0) return new Pair(row, i);
		}
		return null;
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Board {
		int[][] board;
		int N;

		public Board(int n) {
			board = new int[n][n];
			this.N = n;
		}

		public int get(int row, int col) {
			assert row >= 1 && row <= N;
			assert col >= 1 && col <= N;
			return board[row][col];
		}

		public Board copy() {
			Board board2 = new Board(N);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					board2.board[i][j] = board[i][j];
				}
			}
			return board2;
		}
	}
}