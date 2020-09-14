class Solution {
public int largestComponentSize(int[] A) {
         //union find: path compression 找到每一个元素的最终parent
         //最终parent有多少个children，就有多少个connected element

         //Map<element, parent>
        Map<Integer,Integer> parent = new HashMap<>();

        for (int num : A)
            //每一个元素的factor最多有跟号个num
            for (int fact = 2; fact*fact<=num; fact++)
                if (num % fact == 0){
                    //找到对应的factor的最终parent
                    union(num,fact,parent);
                    union(num,num/fact,parent);
                }

        int max = 1;
         //Map<parent,出现的次数>
        Map<Integer,Integer> freq = new HashMap<>();
        for (Integer v : A) {
            //找到每一个elment对应的终极parent
            int f = find(v,parent);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f)+1);
                //跟新最多出现的parent的次数
                max=Math.max(max,freq.get(f));
            }
            else freq.put(f,1);
        }
        return max;
    }

    public void union(int n, int m, Map<Integer,Integer> p) {
        int findN = find(n,p);
        int findM = find(m,p);
        //小的parent作为大的parent的parent，这个是path compression算法
        if (findN < findM) p.put(findM,findN);
        else p.put(findN,findM);
    }
//找到i对应的parent
    public int find(Integer i, Map<Integer,Integer> parent) {
        if (parent.get(i) == null) parent.put(i,i);
        while (i != parent.get(i)) i = parent.get(i);
        return i;
    }
}
