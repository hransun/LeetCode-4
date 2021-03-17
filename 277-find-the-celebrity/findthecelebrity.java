public class Solution extends Relation {
    public int findCelebrity(int n) {
        //step 1: find the potential celebrate
        int cele = 0;
        for(int i = 1; i < n; i++){
            //if the potential cele knows i, then i becomes the potentials cele
            if(knows(cele, i)){
                cele = i;
            }
        }
        //step 2: check the celebrate is known by others, and the celebrate doesn't others
        for(int i = 0; i < n; i++){
            if(i == cele){
                continue;
            }
            //if the cele know others or others doesn't know this cele, return -1
            if(knows(cele, i) || !knows(i,cele)){
                return -1;
            }
        }
        return cele;
    }
}
