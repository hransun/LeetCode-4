class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num <= 3999 && num >= 1000){
                sb.append(update(num, 1000, 'M'));
                num %= 1000;
            }else if(num < 1000 && num >= 900){
                sb.append("CM");
                num %= 900;
            }else if(num < 900 && num >= 500){
                sb.append('D');
                num %= 500;
            }else if(num < 500 && num >= 400){
                sb.append("CD");
                num %= 400;
            }else if(num < 400 && num >= 100){
                sb.append(update(num, 100, 'C'));
                num %= 100;
            }else if(num < 100 && num >= 90){
                sb.append("XC");
                num %= 90;
            }else if(num < 90 && num >= 50){
                sb.append('L');
                num %= 50;
            }else if(num < 50 && num >= 40){
                sb.append("XL");
                num %= 40;
            }else if(num < 40 && num >= 10){
                sb.append(update(num, 10, 'X'));
                num %= 10;
            }else if(num == 9){
                sb.append("IX");
                num = 0;
            }else if(num >= 5 && num < 9){
                sb.append('V');
                num %= 5;
            }else if(num == 4){
                sb.append("IV");
                num = 0;
            }else{
                sb.append(update(num, 1, 'I'));
                num = 0;
            }
        }
        return sb.toString();
    }
    private StringBuilder update(int num, int base, char c){
        StringBuilder sb = new StringBuilder();
            int count = num/base;
                while(count > 0){
                    sb.append(c);
                    count--;
                }
        return sb;
    }
}
