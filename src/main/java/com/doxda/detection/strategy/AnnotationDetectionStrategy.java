package com.doxda.detection.strategy;

import com.doxda.detection.result.Result;

import java.util.HashMap;

/**
 * @author zgq
 */
public class AnnotationDetectionStrategy implements IDetectionStrategy{
    /**
     * 对元数据进行校验
     *
     * @return 校验结果
     */
    @Override
    public Result detection() {
        return new Result(true,new HashMap<>());
    }
}
