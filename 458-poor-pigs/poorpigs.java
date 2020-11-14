class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //把bucket化成N 维矩阵
        //每一维矩阵的长度是 minutesToTest/minutesToDie+1
        //ex:一个有5个buckets，每一个实验是15min，一个猪在一个小时内喝4个bucket，如果没有死，我们就知道最后一个有毒
        //所以每一纬度最多可以试(int)Math.ceil(minutesToTest*1.0/minutesToDie)+1
        //n个猪==n个纬度，把所有的纬度得到的交叉部分就可以推算出有有毒的bucket在哪里
        // logbuckets/log maxBucket
      int maxBucket = (int)Math.ceil(minutesToTest*1.0/minutesToDie)+1;
        return (int)(Math.ceil(Math.log(buckets*1.0)/Math.log(maxBucket*1.0)));
    }
}
