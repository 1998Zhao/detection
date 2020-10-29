package com.doxda.detection.strategy;

import cn.hutool.core.util.ArrayUtil;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 校验策略
 * @author zgq
 */
public interface IDetectionStrategy {
    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    Result detection();
    /**
     * 对定义的数组 进行非空校验
     * @param array 数组对象
     * @return 校验结果
     */
    default Result arrayDetection(String []array){
        boolean check = false;
        Map<String,String> map = new HashMap<>();
        int j=0;
        for (String s : array) {
            if (StringUtils.isNotBlank(s)){
                j++;
                continue;
            }
            map.put(s,s+" 's value can't be null");
        }
        if (j==array.length){
            check = true;
        }
        return new Result(check,map);
    }

    /**
     * according to Imetadate get their fields value
     * @param metadata
     * @param array
     * @return fields value
     */
    default String []getFieldsByFieldName(IMetadata metadata,String []array){
        Class c = metadata.getClass();
        Field[] fields = c.getDeclaredFields();
        List<String> values = new ArrayList<>();
        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);
            if (ArrayUtil.contains(array,field.getName())){
                try {
                    values.add((String) field.get(metadata));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        String[] res = new String[values.size()];
        return values.toArray(res);
    }
}
