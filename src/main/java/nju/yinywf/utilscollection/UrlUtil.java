package nju.yinywf.utilscollection;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yinywf
 * Created on 2019/4/19
 */
public class UrlUtil {
    private final static String prefix = "http:127.0.0.1";

    public static Map<String, String> splitQuery(String url) throws Exception {

        URL urlObj;
        try {
            urlObj = new URL(prefix + url.replaceAll("#",""));
        } catch (MalformedURLException e) {
            throw new Exception(e.getMessage());
        }

        Map<String, String> query_pairs = new LinkedHashMap<>();
        String query = urlObj.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

    public static String splitBasePath(String url) throws Exception {
        return url.split("\\?")[0];
    }

}
