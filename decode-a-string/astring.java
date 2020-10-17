public String solution(String input){
        Deque<Integer> num = new ArrayDeque<>();
        Deque<String> chars = new ArrayDeque<>();

        return helper(input, new int[]{0});
  }
  private String helper(String s, int[] index){
      StringBuilder cur = new StringBuilder();
        int count = 0;
        while (index[0] < s.length()){
            char text = s.charAt(index[0]);
            if(Character.isLetter(s.charAt(index[0]))){
                cur.append(s.charAt(index[0]++));
            }else if(Character.isDigit(s.charAt(index[0]))){
                StringBuilder temp = new StringBuilder();
                while(index[0] < s.length() && s.charAt(index[0]) != '|'){
                    temp.append(s.charAt(index[0]++));
                }
                count = Integer.valueOf(temp.toString());
            }else if(s.charAt(index[0]) == '|'){
                index[0]++;
            }else if(s.charAt(index[0]) == '['){
                index[0]++;
                cur.append(helper(s, index));
            }else if(s.charAt(index[0]) == ']'){
                StringBuilder temp = new StringBuilder();
                while(count > 0){
                    temp.append(cur);
                    count--;
                }
                index[0]++;
                return temp.toString();
            }
        }
      return cur.toString();
  }
