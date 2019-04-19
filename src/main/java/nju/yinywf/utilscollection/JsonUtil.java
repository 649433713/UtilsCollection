package nju.yinywf.utilscollection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * @author yinywf
 * Created on 2019/04/12
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
