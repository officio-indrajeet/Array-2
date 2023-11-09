// Time complexity : O(m*n)
// Space complexity : O(1)
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] dirs;

    private static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = countAlive(board, i, j, m, n);
                if (board[i][j] == 1) {
                    if (countAlive < 2 || countAlive > 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (countAlive == 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static int countAlive(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && c >= 0 && r < m && c < n && (board[r][c] == 1 || board[r][c] == 2)) {
                count++;
            }
        }
        return count;
    }

}