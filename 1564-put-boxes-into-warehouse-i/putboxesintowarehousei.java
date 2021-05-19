class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        //greedy: try to fill from the biggest boxes(left -> right)
        Arrays.sort(boxes);
        int index = 0;
        int res = 0;
        for(int i = boxes.length -1; i >= 0; i--){
            if(index == warehouse.length){
                break;
            }
            if(warehouse[index] >= boxes[i]){
                res++;
                index++;
            }
        }
        return res;
    }
}
