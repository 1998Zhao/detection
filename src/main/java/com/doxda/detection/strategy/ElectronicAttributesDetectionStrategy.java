package com.doxda.detection.strategy;

import com.doxda.detection.metadate.AggregationLevel;
import com.doxda.detection.metadate.ElectronicAttributes;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

/**
 * @author zgq
 */
public class ElectronicAttributesDetectionStrategy implements IDetectionStrategy{
    private final ElectronicAttributes electronicAttributes;
    private final AggregationLevel aggregationLevel;

    public ElectronicAttributesDetectionStrategy(ElectronicAttributes electronicAttributes, AggregationLevel aggregationLevel) {
        this.electronicAttributes = electronicAttributes;
        this.aggregationLevel = aggregationLevel;
    }

    /**
     * 对元数据进行校验
     *
     * @return 校验结果
     */
    @Override
    public Result detection() {
        String aggrLevel = aggregationLevel.getAggregationLevel();
        String[]array ;
        String []keys;
        if ("文件".equals(aggrLevel)){
             keys = new String[]{"computerFileName","computerFileSize"};
        }
        else {
            keys = new String[0];
        }
        array  = getFieldsByFieldName(electronicAttributes,keys);
       return arrayDetection(array);
    }


}
