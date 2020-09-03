public String largestTimeFromDigits(int[] A) {
       int[] time = new int[]{-1};
      helper(A,0,time);
       if(time[0] == -1) {
           return new String();
       }
       int hour = time[0]/60;
        String h = hour <=9 ? "0"+hour: ""+hour;
        int min = time[0]%60;
        String m = min<=9? "0"+min: ""+min;
        return h+":"+m;
       //"%02d:%02d:%02d",hour,minute,second
       //Format  Data   Result
        // %02d    1      01
        // %02d    11     11
      //return String.format("%02d:%02d", time[0]/60, time[0]%60);
   }

   private void helper(int[] A, int index, int[] time){
       if(index == A.length){
           int first = A[0]*10 + A[1];
           int second = A[2]*10 + A[3];
           if(first < 24 && second < 60 && time[0] < first*60+second ) {
               time[0] = first*60+second;
           }
           return;
       }
       for(int i = index; i < A.length; i++) {
           swap(A,i, index);
           helper(A,index+1,time);
           swap(A, i, index);
       }
   }
   private void swap(int[] array, int i, int j){
       int temp = array[i];
       array[i]= array[j];
       array[j] = temp;
   }
