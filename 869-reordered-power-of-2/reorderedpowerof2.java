class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] num = String.valueOf(N).toCharArray();
        return dfs(num,0);
    }
    private boolean dfs(char[] array, int index){
        if(index == array.length){
            if(array[0] == '0'){
                return false;
            }
            int num = Integer.valueOf(new String(array));
            return (num&(num-1)) == 0;
        }
        for(int i = index; i < array.length; i++){
            swap(i, index, array);
            if(dfs(array,index+1)){
                return true;
            };
            swap(i,index,array);
        }
        return false;
    }
    private void swap(int i, int j, char[] array){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
