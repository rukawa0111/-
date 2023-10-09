import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//题型：每次迭代相应的更新x，再下一轮x与之比较。。，再迭代。。。


public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);  //soet的comparable排序认识，记住现在的二维排序模式；
       List<int []> list=new ArrayList<>();
       int [] term =intervals[0];     //
       for(int i=1;i< intervals.length;i++)
       {
           if(term[1]>=intervals[i][0])   //①
           {
               term[1]=Math.max(intervals[i][1],term[1]);     //②
               //这里max很关键,         *******虽然我还没有完全摸透这种 x=max(x,..)的 使用情况******
           }
           else
           {
               list.add(term);
               term=intervals[i];           //③
           }

           //①②③
       }
       list.add(term);
       return list.toArray(new int[list.size()][2]);      //注意返回时用的toArray和其参数
    }

}
