package com.doxda.detection.strategy;

import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;

import java.util.Map;

/**
 * 校验策略
 * @author zgq
 */
public interface DetectionStrategy {
    /**
     * 对元数据进行校验
     * @param iMetadata 元数据子元素
     * @return 校验结果
     */
    Result detection(IMetadata iMetadata);
}
