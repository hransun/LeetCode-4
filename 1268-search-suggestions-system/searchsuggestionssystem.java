class Solution {
    //Two pointer
    // T: O(n.logn) S:O(1)
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int start = 0;
        int end = products.length - 1;
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            List<String> cur = new ArrayList<>();
            while(start <= end &&
                  // start 指向的words比prefix短，或者不符合prefix当前新增的字母
                  //start往后移动
                  //这里不需要看之前的prefix是否符合，因为上一轮已经看过了
                  (products[start].length() <= i || products[start].charAt(i) != searchWord.charAt(i))){
                start++;
            }
            while(start <= end &&
                  (products[end].length() <= i || products[end].charAt(i)!= searchWord.charAt(i))){
                end--;
            }
            //从这里开始，start和end的区间是符合目前prefix的要求
            for(int k = start; k < start+ 3 && k <= end; k++){
                cur.add(products[k]);
            }
            list.add(cur);
        }
        return list;
    }
}
