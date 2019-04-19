package nju.yinywf.utilscollection;

import nju.yinywf.utilscollection.enums.CodeEnum;

/**
 * @author yinywf
 * Created on 2019/04/12
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {

        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }

        return null;

    }
}
