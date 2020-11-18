class Solution {
    public void nextPermutation(int[] A) {
        //T: O(n)
        //下一个permuatation
        //XXXY DES -> XXXZ ACS 其中z比y大一号
        //step1: 找到DES range， i停在Y上
        //step2: 在DES中找到the smallest element that bigger than Y，这里是j
        //step3: swap i，j， 此时DES的部分仍旧是des
        //step 4: 把DES变成ASC

        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        //step1
        while(i >= 0 && A[i] >= A[i + 1]) i--;
        //if i < 0 => the whole array is DES
        if(i >= 0) {
            //step 2
            int j = A.length - 1;
            while(A[j] <= A[i]) j--;
            //step 3
            swap(A, i, j);
        }
        //step 4
        reverse(A, i + 1, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
