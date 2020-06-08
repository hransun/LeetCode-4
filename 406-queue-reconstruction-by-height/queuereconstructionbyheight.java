class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //sort from the highest height and lower position
        // insert the elemenet based on index k（except the hightest element)
        //T: nlogn S: O(n)
        if(people == null || people.length == 0 || people[0].length <= 1){
            return people;
        }
        Arrays.sort(people, new MyCompare());
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < people.length;i++){
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][2]);
    }
    private static class MyCompare implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0] && a[1] == b[1]){
                return 0;
            }
            if(a[0] == b[0] && a[1] < b[1]) {
                return -1;
            }else if(a[0] == b[0] && a[1] > b[1]) {
                return 1;
            }
            return a[0] > b[0]? -1 : 1;

        }
    }
}
