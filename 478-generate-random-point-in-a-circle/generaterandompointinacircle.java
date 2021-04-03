class Solution {
    //generate在x+-radius范围内的数字
    //计算x，ypoint是否在圆圈内
    double x;
    double y;
    double r;
    public Solution(double radius, double x_center, double y_center) {
        x = x_center;
        y = y_center;
        r = radius;
    }

    public double[] randPoint() {
        double xMin = x-r;
        double yMin = y-r;
        while(true){
           double xRan = Math.random()*(r*2) + xMin;
           double yRan = Math.random()*(r*2) + yMin;
            //check whether x,y point is inside the circule
           if(Math.pow((xRan- x),2) + Math.pow((yRan-y),2) <= r*r) {
               return new double[]{xRan, yRan};
           }
        }
    }
}
