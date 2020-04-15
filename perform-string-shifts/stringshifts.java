class Solution {
    //T: O(n) S: O(n)
    //整体revesr
    // 按index的位置reverse
    //right reverse (0, index) 和（index + 1， end）
    //left revser（0， length - index) 和（index，end）
    public String stringShift(String s, int[][] shifts) {
        if(s == null || shifts.length == 0 || shifts[0].length == 0) {
            return s;
        }
        int shift = 0;
        //把array一个个拿出来 s: int[][]
        for(int[] shi: shifts) {
            //left shfit shift++
            if (shi[0] == 0) {
               shift += shi[1];
            //right shift shift--
           } else {
               shift -= shi[1];
           }
        }
        if(shift == 0) {
            return s;
        }
        char[] array = s.toCharArray(); // O(n)
        int index = Math.abs(shift) % array.length;
        int n = array.length - 1;
        if(shift > 0) {
            return leftShift(array, index, n);
        }
        return rightShift(array,index, n);
    }
    private String leftShift(char[] array, int shift, int n) {
        reverse(array, 0, n);
        reverse(array,0, n - shift);
        reverse(array,n-shift+1,n);
        return new String(array);
    }
    private String rightShift(char[] array, int shift, int n) {
        reverse(array, 0, n);
        reverse(array,0, shift-1);
        reverse(array, shift, n);
        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while(i <= j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
