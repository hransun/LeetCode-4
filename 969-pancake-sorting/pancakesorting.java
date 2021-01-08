class Solution {
    public List<Integer> pancakeSort(int[] A) {
        //从最大的element开始找对应的index
        //如果位置不对，先和0位个swap
        //在从0位置和indexswap
        List<Integer> list  = new ArrayList<>();
        for(int i = A.length; i >0;i--) {
            //找到cur应该对应的index
            int index = getIndex(A, i);
            //已经在对的index
            if(index+1 == i) {
               continue;
            }
            swap(A,index);
            list.add(index+1);
            swap(A,i-1);
            list.add(i);
        }
        return list;
    }
        private int getIndex(int[] A, int target){
          for(int i = 0; i < A.length; i++) {
              if(A[i] == target) {
                  return i;
              }

        }
             return -1; //没有找到就return -1
    }

    private void swap(int[] A, int i) {
            int j = 0;
            while(j < i) {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                j++;
                i--;
            }
    }

}
