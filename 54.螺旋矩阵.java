import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> newOrder = new ArrayList<>(); 
        int m = matrix.length;//纵向长度
        int n = matrix[0].length;//横向长度
        //当前坐标
        int x = 0, y = 0;
        // 四个移动方向
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//右, 下, 左, 上
        int curDirec = 0;//初始向右

        int left = 0;
        int right = n - 1;
        int top= 0;
        int bottom = m - 1;

        while(newOrder.size() != m * n){
            newOrder.add(matrix[x][y]);

            if(curDirec == 0 && y == right){ 
                top++;//向右移动, 即上面一行遍历完成, top下移
                curDirec++;
            }
            if(curDirec == 1 && x == bottom){
                right--;//向下移动, 即右面一行遍历完成, right左移
                curDirec++;
            }
            if(curDirec == 2 && y == left){
                bottom--;//向做移动, 即下面一行遍历完成, bottom上移
                curDirec++;
            }
            if(curDirec == 3 && x == top){
                left++;//向上移动, 即左面一行遍历完成, left右移
                curDirec++;
            }
            curDirec %= 4;
            x += direction[curDirec][0];
            y += direction[curDirec][1];

        }

        return newOrder;

    }
}
// @lc code=end

