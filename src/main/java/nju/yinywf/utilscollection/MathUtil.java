package nju.yinywf.utilscollection;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * function:比较两个金额是否相等
     * parameters:
     * throw:
     * Created by IMS
     */
    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }else {
            return false;
        }
    }
}
