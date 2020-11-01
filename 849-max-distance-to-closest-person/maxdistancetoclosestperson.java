
//sliding window
//case 1: continuse 0 appears in the left side or right side
//case 2: in the middle
//a. odd Distance
//b. even Distance
//T: O(n) S: O(1)
public int maxDistToClosest(int[] seats) {
    int left = -1;
    int right = -1;
    int i = 0;
    int max = 0;
    while(i < seats.length){
        while(i < seats.length && seats[i] == 1){
            i++;
        }
        left = i;
        //right = i;
        while(i < seats.length && seats[i] == 0){
            i++;
        }
        right = i;
        if(left == 0 || right == seats.length){
            max = Math.max(max, right-left);
        }else{
            int diff = right - left;
            if(diff% 2 == 0){
                max = Math.max(max, diff/2);
            }else{
               max = Math.max(max, diff/2+1);
            }

        }
    }
    return max;
}
