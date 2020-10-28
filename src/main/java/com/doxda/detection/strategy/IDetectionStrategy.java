package com.doxda.detection.strategy;

import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;

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
}
