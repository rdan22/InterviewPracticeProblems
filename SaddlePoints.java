import java.util.*;
import java.util.stream.Collectors;

class Matrix {
    List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        if (this.values.isEmpty())
            return Collections.EMPTY_SET;

        Set<MatrixCoordinate> set;

        List<MatrixCoordinate> colMaxCollection = new ArrayList<>();
        List<MatrixCoordinate> rowMaxCollection = new ArrayList<>();

        for (int r = 0; r < this.values.size(); r++) {
            List<Integer> row = this.values.get(r);
            int maxValue = Integer.MIN_VALUE;
            List<MatrixCoordinate> rowMax = new ArrayList<>();
            for (int c = 0; c < row.size(); c++) {
                int curVal = row.get(c);
                if (curVal == maxValue) {
                    rowMax.add(new MatrixCoordinate(r + 1, c + 1));
                } else if (curVal > maxValue) {
                    maxValue = curVal;
                    rowMax = new ArrayList<>();
                    rowMax.add(new MatrixCoordinate(r + 1, c + 1));
                }
            }

            rowMaxCollection.addAll(rowMax);
        }
        for (int c = 0; c < this.values.get(0).size(); c++) {
            int minValue = Integer.MAX_VALUE;
            List<MatrixCoordinate> colMax = new ArrayList<>();
            for (int r = 0; r < this.values.size(); r++) {
                int curVal = this.values.get(r).get(c);
                if (curVal == minValue) {
                    colMax.add(new MatrixCoordinate(r + 1, c + 1));
                } else if (curVal < minValue) {
                    minValue = curVal;
                    colMax = new ArrayList<>();
                    colMax.add(new MatrixCoordinate(r + 1, c + 1));
                }
            }
            colMaxCollection.addAll(colMax);
        }

        set = rowMaxCollection.stream().filter(colMaxCollection::contains).collect(Collectors.toSet());

        return set;
    }
}