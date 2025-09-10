public class searchTwoDMatrix {
    public static boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int r = mid / cols;
            int c = mid % cols;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        int target = 3;
        System.out.println("Searching " + target + ": " + search(matrix, target));

        target = 13;
        System.out.println("Searching " + target + ": " + search(matrix, target));
    }
}
