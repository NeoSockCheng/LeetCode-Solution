package Problems.Q0074_Search_a_2D_Matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bot = matrix.length - 1;

        while (top <= bot) {
            int mid = (top + bot) / 2;

            if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] > target) {
                break;
            } else if (matrix[mid][0] > target) {
                bot = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        int row = (top + bot) / 2;

        int left = 0;
        int right = matrix[row].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;        
    }
}

// Question: search a number in incresing-order 2d matrix
// solution: use double binary serach, serach row first and then column