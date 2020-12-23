class Solution {
    public int nextGreaterElement(int n) {
        //从最后一位开始找第一个小的数字,2是第一个小的数字
        //ex: XXXX24321
        //从第一个小的数字之后开始找一个比小的数字大的最小数字，ex 3，然后swap
        // ex：XXXX34221
        //最后对最后的几位从小大到sort,ie 4221 -> sort 成1224
        String s = String.valueOf(n);
        char prev = s.charAt(s.length()-1);
        int i = s.length()-2;
        for(; i >= 0; i--){
            if(s.charAt(i) >= prev){
                prev = s.charAt(i);
            }else{
                break;
            }
        }
        //整个字符串都是decreasing
        if(i < 0){
            return -1;
        }
        //从第一个小的数字之后开始找一个比小的数字大的最小数字
        int next = binary(s,i);
        s = swap(s, i, next);
        String part = s.substring(i+1);
        char[] array = part.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j <= i; j++) {
            sb.append(s.charAt(j));
        }
        for(char c: array){
            sb.append(c);
        }
        long res = Long.valueOf(sb.toString());
        if(res > Integer.MAX_VALUE){
            return -1;
        }
        return (int)res;
    }
    private int binary(String s, int index){
        char target = s.charAt(index);
        int left = index+1;
        int right = s.length()-1;
        while(left < right -1){
            int mid = left + (right-left)/2;
            if(s.charAt(mid) > target){
                left = mid;
            }else{
                right = mid -1;
            }
        }
        if(s.charAt(right) > target){
            return right;
        }
        return left;
    }
    private String swap(String s, int i, int j){
        char[] array = s.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}
