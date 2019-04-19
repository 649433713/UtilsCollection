package nju.yinywf.utilscollection;

/**
 * @author yinywf
 * Created on 2019/4/19
 * 将只含bool类型的JavaBean转义成唯一数字，属性按字典序排序
 */

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
public class BitMapUtil {
    public BitMapUtil() {
    }

    public static <T> Integer intBitMap(T dto) {
        if (dto == null) {
            return null;
        } else {
            List<Field> fields = new ArrayList<>(Arrays.asList(dto.getClass().getDeclaredFields()));
            fields.sort(Comparator.comparing(Field::getName));
            int i = 1;
            int res = 0;

            for(Iterator var4 = fields.iterator(); var4.hasNext(); i *= 2) {
                Field field = (Field)var4.next();
                field.setAccessible(true);

                try {
                    boolean rs = (Boolean)field.get(dto);
                    if (rs) {
                        res += i;
                    }
                } catch (IllegalAccessException var7) {
                    var7.printStackTrace();
                }
            }

            return res;
        }
    }

    public static <T> T fillDTO(int bitMap, Class<T> clazz) {
        try {
            T dto = clazz.newInstance();
            List<Field> fields = Arrays.stream(clazz.getDeclaredFields()).sorted(Comparator.comparing(Field::getName)).collect(Collectors.toList());
            int i = 1;

            for(Iterator var5 = fields.iterator(); var5.hasNext(); i *= 2) {
                Field field = (Field)var5.next();
                field.setAccessible(true);
                field.set(dto, (bitMap & i) != 0);
            }

            return dto;
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}