package nju.yinywf.utilscollection.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yinywf
 * 2017-06-19 00:29
 *
 * 将毫秒级时间转换成秒级时间
 * 用法：
 *  @JsonSerialize(using = Date2LongSerializer.class)//本来是毫秒级的，转换成秒级
 *  private Date createTime;
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
