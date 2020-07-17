class Solution {
    public double angleClock(int hour, int minutes) {
        int hourangle = 30; //每一个hour的角度是30 ==>360/12, 12小时制
        int minangle = 6;//每一个min的角度是6 == 》 360 /60
        double hourA = (hour%12 + minutes/60.0)*hourangle;
        double minA = minangle*minutes;
        double diff = Math.abs(hourA-minA);// 时分针可能一前一后的顺序可能不一样，只要算出差值即可
        return Math.min(360-diff, diff); //return角度较小的那一个即可

    }
}
