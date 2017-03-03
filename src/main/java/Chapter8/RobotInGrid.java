package Chapter8;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by bresai on 2017/2/27.
 */
public class RobotInGrid {
    List<Grid> res;

    public List<Grid> solution(int r, int c){
        res = new LinkedList<>();
        recur(r , c, 1, 1);

        return res;
    }

    private boolean recur(int r, int c, int x, int y){
        if ( x > r || y > r) return false;

        if (x == r && y == c) {
            res.add(new Grid(x, y));
            return true;
        }

        boolean tmp;
        tmp = recur(r, c, x, y + 1) || recur(r, c, x + 1, y);

        if (tmp) res.add(new Grid(x, y));

        return tmp;
    }

    public static void main(String[] args) {
        RobotInGrid grid = new RobotInGrid();
        System.out.print(grid.solution(5,5));
    }
}

class Grid {
    int r;
    int c;

    public Grid(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Grid{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}
