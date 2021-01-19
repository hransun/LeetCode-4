public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    int prev = array[0];
    List<Integer> list = new ArrayList<>();
    list.add(prev);
    int index = 1;
    int count = 1;
    while(index < array.length){
        int cur = array[index];
        if(cur == prev){
          if(count < 2){
            list.add(cur);
            count++;
            index++;
            continue;
          }
          while(index < array.length && array[index] == prev){
            index++;
          }
          if(index < array.length){
              count = 1;
              list.add(array[index]);
              prev = array[index];
              index++;
          }
        }else{
          count = 1;
          list.add(cur);
          prev = cur;
          index++;
        }
    }
    int[] res = new int[list.size()];
    for(int i = 0; i < list.size(); i++){
      res[i] = list.get(i);
    }
    return res;
    //return list.toArray(new int[list.size()]);
  }
}
