package nju.yinywf.utilscollection;

import java.util.Random;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public class KeyUtil {
    /**
     * function:生成唯一主键 （时间+随机数）
     * parameters:
     * throw:
     * Created by IMS
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();

        Integer a = random.nextInt(900000)+100000;

        return   System.currentTimeMillis()+String.valueOf(a);

    }
}