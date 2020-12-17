class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //扫描所有的s1，计算s2一共出现的次数，然后s2count/n2
        char[] a1 = s1.toCharArray(), a2 = s2.toCharArray();
        int i = 0;
        int j = 0;
        int s1count = 0;
        int s2count = 0;
        while(s1count != n1){
            //如果匹配,两个都移动，否则移动i
            if(a1[i] == a2[j]){
                i++;
                j++;
            }else{
                i++;
            }
            //检查i，j是否走到bound
            //走到了要重制i，j,更新count
            if(i == a1.length){
                i = 0;
                s1count++;
            }
            if(j == a2.length){
                j = 0;
                s2count++;
            }
        }
        return s2count/n2;
    }
}
