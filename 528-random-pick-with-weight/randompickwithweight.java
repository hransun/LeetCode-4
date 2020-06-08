class Solution {
    //create the accumated sum
    // find the first  elememt that is larget or equal to the random value, return the index of element
    int[] sumArray = null;
    int sum = 0;
    public Solution(int[] w) {
        sumArray = new int[w.length];
        for(int i = 0; i < w.length; i++) {
            sum += w[i];
            sumArray[i] = sum;
        }
    }

    public int pickIndex() {
        //这里必须要double, 如果是int,可能会出现错解
        //for example, double = 1.2 答案应该是index 2，double 1.0 答案应该是 index 1
        //如果在第一步用int 会直接得到index =1的答案
        double random = Math.random()*sum;
        int i = 0;
        int j = sumArray.length - 1;
        // first element that larger than target
        while( i < j -1) {
            int mid = i + (j- i) / 2;
            if(sumArray[mid] >= random) {
                j = mid;
            }else {
                i = mid +1;
            }
        }
        // double == int ==> int 会casting成double
        if(sumArray[i] >= random) {
                return i;
        }
        if(sumArray[j] >= random) {
                 return j;
        }
        return -1;
    }

}
