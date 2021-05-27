class Solution {
    public String toLowerCase(String s) {
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            char c = array[i];
            if(Character.isUpperCase(c)){
               array[i] -= ('A' - 'a');
            }
        }
        return new String(array);
    }
}
