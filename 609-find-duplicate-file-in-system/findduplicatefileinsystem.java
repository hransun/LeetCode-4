class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String s: paths){
            String[] array = s.split(" ");
            String root = array[0];
            for(int i = 1; i <array.length; i++){
                    String cur = array[i];
                    int index = 0;
                    StringBuilder num = new StringBuilder();
                    while(index < cur.length() && cur.charAt(index)!= '(') {
                        num.append(cur.charAt(index++));
                    }
                    String value = root + "/" + num.toString();
                    StringBuilder context = new StringBuilder();
                    index++;
                    while(index < cur.length() && cur.charAt(index)!= ')'){
                        context.append(cur.charAt(index++));
                    }
                    String key = context.toString();
                    if(!map.containsKey(key)){
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);
            }
        }
        for(Map.Entry entry: map.entrySet()){
            List<String> value = (List<String>)(entry.getValue());
            if(value.size() >= 2) {
                res.add(value);
            }
        }
        return res;
    }
}
