class Solution {
     String[] single= new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] ten = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        //write num
        // 分段：
        // > 10^9 billion => recusrion
        // 10^6 - 10^9 milllion => recusrion
        // 10^3 - 10^6 thousand  => recusrion
        // 10^3  hundred
        // 0-20

        //dictionary
        // 1 - 10
        //20,30,50,60,70,80,90,100
        // thousands
        // million
        //billion

         if(num == 0){
            return "Zero";
        }
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            //19
            if(num < 20){
                sb.append(single[num-1]);
                sb.append(" ");
                num -= num;
            // 23 -> 3
            }else if(num < 100){
                // 20
                sb.append(ten[num/10-2]);
                sb.append(" ");
                num = num%10;
            // 234 -> 34
            }else if(num < 1000){
                sb.append(single[num/100-1]); // module比自己小的量级数
                sb.append(" ");
                sb.append("Hundred ");
                num = num%100;
             //  2349 ->349;
            }else if(num < 1000000){
                sb.append(numberToWords(num/1000));
                sb.append(" ");
                sb.append("Thousand ");
                num = num%1000;
            }
            // one million: 用recusrion的方法求23 million
            // < 10^6
            else if(num < 1000000000){ // 10^9
                sb.append(numberToWords(num/1000000)); // 10^6
                sb.append(" ");
                sb.append("Million ");
                num = num%1000000;
            }else{ // 10^12
                sb.append(numberToWords(num/1000000000)); // 10^9
                sb.append(" ");
                sb.append("Billion ");
                num = num%1000000000;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
