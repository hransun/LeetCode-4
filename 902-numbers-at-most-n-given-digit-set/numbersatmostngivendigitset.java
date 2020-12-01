class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        //ex: target： 5387 , digit: 1,2,5
        //step 1: 计算比当前target number 位数少的数字一共多少种， ex: X,XX,XXX
        //step2: 计算比当前target number第一位数字小的同样位数的数字有多少种 1XXX,2XXX
        //step3:计算和当前位数的数字相等的情况有多少种，ex： 5XXX
        String target = String.valueOf(n);
        int ans = 0;
        ans += getLess(digits, target);
        ans += getSmaller(digits, 0, target);
        ans += getEqual(digits, target);
        return ans;
    }
    private int getLess(String[] digits, String target){
        int ans = 0;
        int length = target.length();
        //the num of digits
        int num = digits.length;
        for(int i = 1; i < length; i++){
            ans += (int)(Math.pow(num*1.0, i*1.0));
        }
        return ans;
    }
    private int getSmaller(String[] digits, int start, String target){
        if(start >= target.length()){
            return 1;
        }
        //how many number that smaller then the start figure
        int num = 0;
        int first = target.charAt(start)- '0';
        for(int i = 0; i < digits.length; i++){
            int cur = Integer.valueOf(digits[i]);
            if(cur < first){
                num++;
            }else {
                break;
            }
        }
        return (int)(Math.pow((digits.length)*1.0, (target.length()-start-1)*1.0))*num;
    }
    private int getEqual(String[] digits, String target){
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for(String i: digits){
            list.add(Integer.valueOf(i));
        }
        for(int i = 0; i < target.length(); i++){
            int cur = target.charAt(i) - '0';
            if(list.contains(cur)){
                ans += getSmaller(digits,i+1,target);
            }else{
                break;
            }
        }
        return ans;
    }
}
