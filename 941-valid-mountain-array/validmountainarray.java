class Solution {
    public boolean validMountainArray(int[] arr) {
        boolean inc = false;
        boolean dec = false;
        int prev = arr[0];
        int index = 1;
        while(index < arr.length && arr[index] > prev){
            inc = true;
            prev = arr[index];
            index++;
        }
        while(index < arr.length && arr[index] < prev){
             prev = arr[index];
             index++;
             dec = true;
        }
        return index == arr.length && inc&&dec;
    }
}
