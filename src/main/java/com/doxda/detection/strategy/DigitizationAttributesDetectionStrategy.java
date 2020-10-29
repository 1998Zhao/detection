package com.doxda.detection.strategy;

import com.doxda.detection.metadate.AggregationLevel;
import com.doxda.detection.metadate.DigitizationAttributes;
import com.doxda.detection.result.Result;

import java.util.HashMap;

/**
 * @author zgq
 */
public class DigitizationAttributesDetectionStrategy implements IDetectionStrategy{

    private final DigitizationAttributes digitizationAttributes;

    public DigitizationAttributesDetectionStrategy(DigitizationAttributes digitizationAttributes) {
        this.digitizationAttributes = digitizationAttributes;
    }

    /**
     * 对元数据进行校验
     *
     * @return 校验结果
     */
    @Override
    public Result detection() {
        if (digitizationAttributes==null){
            return new Result(true,new HashMap<>());
        }
        String[] keys = new String[]{"scanningResolution","scanningColorModel"};
        String[] values = getFieldsByFieldName(digitizationAttributes,keys);
        return arrayDetection(values);
    }
}
