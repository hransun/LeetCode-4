/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int res = 0;
        char[] buf4 = new char[4];
        int cur = 0;
        for(int i = 0; i < n ; i += 4) {
            cur = read4(buf4);
            if(cur + res > n) {
                cur = n -res;
            }
            for(int j = 0; j < cur; j++){
                buf[res++]=buf4[j];
            }
        }
        return res;

    }
}
