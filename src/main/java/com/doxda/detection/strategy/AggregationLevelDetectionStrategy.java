package com.doxda.detection.strategy;

import cn.hutool.core.util.ArrayUtil;
import com.doxda.detection.metadate.AggregationLevel;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.MetadataRange;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 聚合层次处理策略
 * @author zgq
 */
public class AggregationLevelDetectionStrategy implements IDetectionStrategy{
    AggregationLevel aggregationLevel;
    public AggregationLevelDetectionStrategy(AggregationLevel aggregationLevel) {
    }
    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        boolean check = false;
        Map<String,String> map = new HashMap<String, String>();
        String al = aggregationLevel.getAggregationLevel();
        if (StringUtils.isNotBlank(al)){
            String[] m = MetadataRange.aggregationLevelMap.get("aggregationLevel");
            if (ArrayUtil.contains(m,al)){
                check = true;
            }
            else {
                map.put("aggregationLevel","聚合层次必须为文件或案卷");
            }
        }
        else {
            map.put("aggregationLevel","值为空值");
        }
        return new Result(check,map);
    }
}
