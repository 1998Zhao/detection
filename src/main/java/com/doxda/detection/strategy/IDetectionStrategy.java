package com.doxda.detection.strategy;

import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

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
}
