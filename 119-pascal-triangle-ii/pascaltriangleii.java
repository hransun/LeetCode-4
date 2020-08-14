class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if(rowIndex < 0) {
            return list;
        }
        list.add(1);
        if(rowIndex == 0) {
            return list;
        }
        while(rowIndex > 0) {
            List<Integer> cur = new ArrayList<>();
            for(int i = -1; i < list.size(); i++){
               int sum = 0;
                if(i == -1) {
                   sum= list.get(i+1)+0;
                } else if(i == list.size()-1 ) {
                    sum = list.get(i)+0;
                }else{
                    sum = list.get(i)+list.get(i+1);
                }
                cur.add(sum);
            }
            list = cur;
            rowIndex--;
        }
        return list;
    }
}
