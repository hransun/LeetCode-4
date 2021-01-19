class Solution {
    public int numRescueBoats(int[] people, int limit) {
        //greedy:大小match
        //each boat carries max 2 people
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int count = 0;
        int sum = 0;
        while(i <= j){
            count++;
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
        }
        return count;
    }
}
