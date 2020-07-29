class Solution {
    public int findMin(int[] array) {
     if(array == null || array.length == 0) {
      return -1;
    }
    int i = 0;
    int j = array.length - 1;
    while(i < j) {
      int m = i + (j-i)/2;
      if(array[m] < array[j]) {
        j = m;
      }else if(array[m] > array[j]) {
        i = m +1;
      }else{
          j--;
      }
    }
    return array[i];
  }
}
