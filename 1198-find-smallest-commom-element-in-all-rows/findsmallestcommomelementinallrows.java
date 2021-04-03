class Solution {
    public int smallestCommonElement(int[][] mat) {
        Set<Integer> set = new HashSet<>();
        for(int i: mat[0]){
            set.add(i);
        }
        int min = mat[0][0];
        int max = mat[0][mat[0].length-1];
        for(int i = 1; i < mat.length; i++){
            int start = getStartIndex(min, mat[i]);
            int end = getEndIndex(max, mat[i]);
            if(start == -1 || end == -1){
                return -1;
            }
            Set<Integer> next = new HashSet<>();
            boolean first = false;
            for(int j = start; j <= end; j++){
                int val = mat[i][j];

                if(set.contains(val)){
                    next.add(val);
                    if(!first){
                        min = val;
                        first = true;
                    }
                    max = val;
                }

            }
                if(!first){
                    return -1;
                }
                set = next;
            }
        return min;
    }
    //the first element >= min
    private int getStartIndex(int target, int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right -1){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(array[left] >= target){
            return left;
        }
        if(array[right] >= target){
            return right;
        }
        return -1;
    }
    //the last element <= max
    private int getEndIndex(int target, int[] array){
        int left = 0;
        int right = array.length-1;
        while(left < right -1){
            int mid = left + (right-left)/2;
            if(array[mid] == target){
                return mid;
            }else if(array[mid] < target){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        if(array[right] <= target){
            return right;
        }
         if(array[left] <= target){
            return left;
        }
        return -1;
    }
}
