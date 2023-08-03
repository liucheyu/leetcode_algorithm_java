package easy;

/**
 * https://leetcode.com/problems/sqrtx/
 */

public class SqrtX {
    public static void main(String[] args) {
        int x = 2147395600;
        System.out.println(new SqrtX().mySqrt2(x));
    }

    //2分法
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 1;
        for(int i=1;i<=x/2;i++) {
            if(i*i ==x) {
                result = i;
            }

            if(i*i < x && (i+1)*(i+1) > x) {
                result= half(x, i, i+1);
                break;
            }
        }

        return result;
    }

    public int half(int x, int i, int j) {

        int half = (i+j)/2;

        int res = half*half;
        if(res*res == x) {
            return x;
        }


        if(res < x) {
            return half(x, res, j);
        } else {
            return half(x, i, res);
        }
    }

    /**
     * 巴比倫算法  算近似值
     */

    public int mySqrt2(int x) {
        long r = x;
        //條件式這樣應該也可 r>x/r
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}
