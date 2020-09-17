class Solution {
    public String getHint(String secret, String guess) {
       //map<character, time of appears>
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for(char c: guess.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int a = 0;
        int b = 0;
        char[] array = secret.toCharArray();
        for(int i = 0; i < array.length;i++) {
            char c = array[i];
            if(map.containsKey(c)) {
                //A: 查是否match
                // 如果match，看下之前是否已经扣完
                //扣完的话b要还1回去
                if(c == guess.charAt(i)){
                    a++;
                    if(map.get(c) <= 0) {
                        b--;
                    }else{
                        map.put(c, map.get(c)-1);
                    }
                //B：先看是否扣完
                //如果已经扣完，b就需要再扣来
                }else if(map.get(c) > 0){
                    b++;
                    map.put(c, map.get(c)-1);
                }
            }
        }
        return a+"A"+b+"B";
    }
}
