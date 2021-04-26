package binarySearch;

public class LeetCode74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row * column - 1;
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (matrix[mid / column][mid % column] == target) {
                return true;
            } else if (matrix[mid / column][mid % column] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return false;
    }

}
