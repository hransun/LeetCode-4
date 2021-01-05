class Solution {
    public int countArrangement(int n) {
        //在第i位的数字，要么能被i整除，要么能整除i
        int[] res = new int[1];
        int[] array = new int[n];
        for(int i = 0;i < n; i++){
            array[i] = i+1;
        }
        dfs(array,res,0);
        return res[0];
    }
    private void dfs(int[] array, int[] res, int index){
        if(index == array.length){
            res[0]++;
            return;
        }
        for(int i = index; i < array.length; i++){
            // 符合条件，swap，进入下一步
            if((index+1)%array[i] == 0 || array[i]%(index+1) == 0){
                swap(i,index, array);
                dfs(array, res,index+1);
                swap(i,index, array);
            }
        }
    }
    private void swap(int i , int j, int[] array){
        int temp  = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
