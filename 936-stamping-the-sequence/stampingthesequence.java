class Solution {
    public int[] movesToStamp(String stamp, String target) {
        // Stamp = "abc", Target = "ababcbc"
        // Target = ab???bc
        // Target = ?????bc
        // Target = ???????

        //list<index> => reverse the list as the result
        List<Integer> list = new ArrayList<>();
        // the number of "*"
        int count = 0;
        // for replace the character to '*'
        char[] array = target.toCharArray();
        while(count < array.length){
            boolean replace = false;
            for(int i  = 0; i <= array.length - stamp.length(); i++){
                if(canReplace(i, array, stamp)){
                    count += replace(i, array, stamp);
                    list.add(i);
                    replace = true;
                }
                //exit the for loop in advnace
                if(count == array.length){
                    break;
                }
            }
            //did not find can replaceone in the round
            if(!replace){
                return new int[0];
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(list.size()-i-1);
        }
        return res;
    }
    private boolean canReplace(int start, char[] array, String t){
        int count = 0;
        int index = 0;
        while(index < t.length()){
            if(array[start] == '*'){
                count++;
            }else if(array[start] != t.charAt(index)){
                return false;
            }
            index++;
            start++;
        }
        // match all "*" => means can not replaced
        if(count == t.length()){
            return false;
        }
        return true;
    }
    private int replace(int start, char[] array, String t){
        //how many '*' get
        int count = 0;
        int index = 0;
        while(index < t.length()){
            if(array[start] != '*'){
                array[start] = '*';
                count++;
            }
            index++;
            start++;
        }
        return count;
    }
}
