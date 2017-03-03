package Chapter8;

/**
 * Created by bresai on 2017/2/28.
 */
public class PaintFill {

    enum ColorEnum{
        GREEN(0), RED(1), YELLOW(2);

        int color;

        ColorEnum(int color) {
            this.color = color;
        }

        static ColorEnum getColor(int x){
            for (ColorEnum value : ColorEnum.values()){
                if (value.color == x){
                    return value;
                }
            }
            return null;
        }
    }

    static class Point{
        int x;
        int y;
        ColorEnum color;

        public Point(int x, int y, ColorEnum color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public void paint(int[][] screen, int x, int y, int color){
        ColorEnum colorEnum = ColorEnum.getColor(color);
        recur(screen, new Point(x, y, colorEnum));
    }

    private void recur(int[][] screen, Point point){
        if (screen[point.x][point.y] == point.color.color) return;

        screen[point.x][point.y] = point.color.color;

        recur(screen, new Point(point.x + 1, point.y, point.color));
        recur(screen, new Point(point.x - 1, point.y, point.color));
        recur(screen, new Point(point.x, point.y + 1, point.color));
        recur(screen, new Point(point.x, point.y - 1, point.color));
    }
}




