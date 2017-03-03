package Chapter8;

import java.util.List;

/**
 * Created by bresai on 2017/2/28.
 */
public class StackOfBoxes {
    public int solution(List<Box> list){
        return recur(list,0,0,0);
    }

    private int recur(List<Box> list, int maxWidth, int maxDepth, int maxHeight){
        int totalHeight = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).w > maxWidth ||
                list.get(i).d > maxDepth ||
                list.get(i).h > maxHeight)
                continue;
            totalHeight = Math.max(totalHeight, recur(list,
                    Math.max(maxWidth, list.get(i).w),
                    Math.max(maxDepth, list.get(i).d),
                    Math.max(maxHeight, list.get(i).h)
                    ));
        }
        return totalHeight;
    }
}

class Box{
    int w;
    int h;
    int d;

    public Box(int w, int h, int d) {
        this.w = w;
        this.h = h;
        this.d = d;
    }
}
