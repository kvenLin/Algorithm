/**
 * @Author: clf
 * @Date: 18-11-27
 * @Description:
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 考察点：边界考虑，和double的误差比较
 */
public class Power {
    public double Power(double base, int exponent) throws Exception {
        if (equals(base,0.0)){
            return 0;
        }
        if (base == 1 || exponent == 0){
            return 1;
        }
        if (exponent < 0){
            return power(1.0 / base, -exponent);
        }else {
            return power(base, exponent);
        }

    }

    //double比较存在误差，比较double的误差范围在+-0.0000001之间
    private boolean equals(double num1, double num2){
        if ((num1 > num2 - 0.0000001) && (num1 < num2 + 0.0000001)) {
            return true;
        }else {
            return false;
        }
    }

    private double power(double base, int exponent){
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new Power().Power(3,-1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
