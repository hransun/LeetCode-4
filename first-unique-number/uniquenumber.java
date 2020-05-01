class FirstUnique {
    Set<Integer> all = null;
    Set<Integer> unique = null;
    //T: O(n) S: O(n)
    public FirstUnique(int[] nums) {
        all = new HashSet<>();
        unique = new LinkedHashSet<>();
        for(int i = 0; i < nums.length ; i++) {
            if(!all.contains(nums[i])) {
                all.add(nums[i]);
                unique.add(nums[i]);
            }else if(unique.contains(nums[i])) {//only keep the unique number
                unique.remove(nums[i]);
            }
        }
    }
    //T: O(n)， iterator是O(n), .next()是O(1)
    public int showFirstUnique() {
        if(unique.size() == 0) { // null.size() 不会NPE
            return -1;
        }
        return unique.iterator().next(); //take the first order element of set

    }
    //T: O(1)
    public void add(int value) {
        if(!all.contains(value)) {
            all.add(value);
            unique.add(value);
        }else if(unique.contains(value)) { // only keep the unique number
            unique.remove(value);
        }
    }
}
