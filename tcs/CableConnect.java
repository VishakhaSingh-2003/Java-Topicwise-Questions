import java.util.*;

public class CableConnect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt(), cols = scanner.nextInt();

        char[][] layout = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            layout[i] = scanner.next().toCharArray();
        }

        List<Integer> filledRows = new ArrayList<>();
        List<Integer> filledCols = new ArrayList<>();

        // ✅ Identify rows completely filled with 'C'
        for (int i = 0; i < rows; i++) {
            boolean fullRow = true;
            for (int j = 0; j < cols; j++) {
                if (layout[i][j] == '.') {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) filledRows.add(i);
        }

        // ✅ Identify columns completely filled with 'C'
        for (int j = 0; j < cols; j++) {
            boolean fullCol = true;
            for (int i = 0; i < rows; i++) {
                if (layout[i][j] == '.') {
                    fullCol = false;
                    break;
                }
            }
            if (fullCol) filledCols.add(j);
        }

        boolean[][] intersection = new boolean[rows][cols];

        // ✅ Mark column intersections
        for (int col : filledCols) {
            for (int i = 0; i < rows; i++) {
                int left = col - 1, right = col + 1;
                if (left >= 0 && right < cols && layout[i][left] == 'C' && layout[i][right] == 'C') {
                    intersection[i][col] = true;
                }
            }
        }

        // ✅ Mark row intersections
        for (int row : filledRows) {
            for (int j = 0; j < cols; j++) {
                int up = row - 1, down = row + 1;
                if (up >= 0 && down < rows && layout[up][j] == 'C' && layout[down][j] == 'C') {
                    intersection[row][j] = true;
                }
            }
        }

        boolean[][] isCable = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (layout[i][j] == 'C' || intersection[i][j])
                    isCable[i][j] = true;

        // ✅ Build graph connections
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < rows * cols; i++) graph.add(new ArrayList<>());

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isCable[i][j]) continue;
                int nodeId = i * cols + j;

                for (int k = 0; k < 4; k++) {
                    int ni = i + dRow[k], nj = j + dCol[k];
                    if (ni >= 0 && nj >= 0 && ni < rows && nj < cols && isCable[ni][nj]) {
                        graph.get(nodeId).add(ni * cols + nj);
                    }
                }
            }
        }

        // ✅ Find cable starting point
        int startNode = -1;
        for (int i = 0; i < rows && startNode == -1; i++) {
            for (int j = 0; j < cols; j++) {
                if (isCable[i][j] && graph.get(i * cols + j).size() == 1) {
                    startNode = i * cols + j;
                    break;
                }
            }
        }

        boolean[] visited = new boolean[rows * cols];
        int[] rowLoad = new int[rows];
        int[] colLoad = new int[cols];

        int current = startNode, previous = -1;
        visited[current] = true;

        // ✅ Traverse the cable path
        while (true) {
            int x = current / cols, y = current % cols;
            int next = -1;

            for (int neighbor : graph.get(current)) {
                if (neighbor != previous && !visited[neighbor]) {
                    next = neighbor;
                    break;
                }
            }

            if (intersection[x][y] && previous != -1) {
                int px = previous / cols, py = previous % cols;
                int direction = (layout[x][y] == 'C') ? 1 : -1;

                if (px == x) {
                    colLoad[y] += (py < y ? 1 : -1) * direction;
                } else {
                    rowLoad[x] += (px < x ? 1 : -1) * direction;
                }
            }

            if (next == -1) break;

            previous = current;
            current = next;
            visited[current] = true;
        }

        long total = 0;
        for (int row : filledRows) total += Math.abs(rowLoad[row]) / 2;
        for (int col : filledCols) total += Math.abs(colLoad[col]) / 2;

        System.out.println(total);
        scanner.close();
    }
}
