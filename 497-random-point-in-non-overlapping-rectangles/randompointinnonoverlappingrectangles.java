class Solution {
int[][] rects;
    int[] prefixSum;//每一个rectangle的点数和累计
    int sum;
    public Solution(int[][] rects) {
        this.rects = rects;
        prefixSum = new int[rects.length];
        int i =0;
        for(int[] cur: rects){
            sum += (cur[2]-cur[0]+1) * (cur[3]-cur[1]+1);//计算每一个rectangle的点数
            prefixSum[i++] = sum;
        }
    }

    public int[] pick() {
        //随机产生一个数
         int target = (int)(Math.random() *sum);
        //找到这一个数所在的rectangle
        int temp = binary(prefixSum, target);
        int[] t = rects[temp];
        //找到在这个rectangle里的地prefixSum[index] -target 的坐标
        int y = t[3]-t[1]+1;
        int x = t[2]-t[0]+1;
        int size = x* y;
        int index = target-(prefixSum[temp]-size);
        return new int[]{t[0]+index%x, t[1]+index/x };

    }
    private int binary(int[] array, int target) {
    //找到第一个数 >= target
        int i = 0;
        int j = prefixSum.length-1;
        while(i < j-1){
            int m = i+(j-i)/2;
            if(prefixSum[m] <= target){
                i = m+1;
            }else{
                j = m;
            }
        }
        return array[i]>target? i:j;
    }
}
