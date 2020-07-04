class Solution {
    public int[] prisonAfterNDays(int[] array, int n) {
        //check the circular
        //if there is a circular appear
        //don't update array
        // use module to find out the corresponding array
        if(array == null || array.length == 0 || n <= 0) {
            return array;
        }
        Set<String> set = new HashSet<>();
        int count = 0;
        boolean hasCycle = false;
        for(int i = 0; i < n; i++) {
           int[] temp = nextDay(array);
            if(set.add(Arrays.toString(temp))) {
                count++;
            }else {
                // circular appear
                //stop the loop and don't update the array
                hasCycle = true;
                break;
            }
            array = temp;
        }
        if(hasCycle == true) {
            for(int i = 0; i < (n % count); i++) {
            array = nextDay(array);
            }
        }

        return array;
    }

    private int[] nextDay(int[] array) {
       int[] temp = new int[8];
        for(int j = 1; j < array.length -1; j++) {
         if(array[j-1] == array[j+1]) {
             temp[j] = 1;
         }
        }
        return temp;
    }
}
