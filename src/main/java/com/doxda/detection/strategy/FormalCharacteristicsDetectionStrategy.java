package com.doxda.detection.strategy;

import cn.hutool.core.util.StrUtil;
import com.doxda.detection.metadate.AggregationLevel;
import com.doxda.detection.metadate.FormalCharacteristics;
import com.doxda.detection.result.Result;

/**
 * @author zgq
 */
public class FormalCharacteristicsDetectionStrategy implements IDetectionStrategy{
    private AggregationLevel aggregationLevel;
    private FormalCharacteristics formalCharacteristics;

    public FormalCharacteristicsDetectionStrategy(AggregationLevel aggregationLevel, FormalCharacteristics formalCharacteristics) {
        this.aggregationLevel = aggregationLevel;
        this.formalCharacteristics = formalCharacteristics;
    }

    /**
     * 对元数据进行校验
     *
     * @return 校验结果
     */
    @Override
    public Result detection() {
        String[] array;
        if ("文件".equals(aggregationLevel.getAggregationLevel())){
            array = new String[]{"documentAggregationType","totalNumberOfPages"} ;
        }
        else {
            array = new String[]{"totalNumberOfItems","totalNumberOfPages"};
        }
        return arrayDetection(array);
    }
}
