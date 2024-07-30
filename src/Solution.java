import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<String, Integer> cache = new HashMap<String, Integer>();
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 1 ; i <= rowIndex ; i++) {
            row.add(findNode(rowIndex, i));
        }
        System.out.println(cache.toString());
        return row;
    }
    private int findNode(int row, int column) {
        
        if (column == 1 || column == row) return 1;
        if (cache.containsKey(String.valueOf(row ) + String.valueOf(column ))) {
            return cache.get(String.valueOf(row  ) + String.valueOf(column ));
        }
        cache.put(String.valueOf(row - 1) + "," + String.valueOf(column),findNode(row - 1, column));
        cache.put(String.valueOf(row - 1) + "," + String.valueOf(column - 1),findNode(row - 1, column - 1));
        return findNode(row - 1, column) + findNode(row - 1, column - 1);
    }
}
class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getRow(5));
        System.out.println();
    }
}