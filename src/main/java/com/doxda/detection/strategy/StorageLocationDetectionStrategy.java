package com.doxda.detection.strategy;

import com.doxda.detection.metadate.StorageLocation;
import com.doxda.detection.result.Result;

/**
 * @author zgq
 */
public class StorageLocationDetectionStrategy implements IDetectionStrategy{
    private StorageLocation storageLocation;
    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        String[] keys = new String[]{"offlineMediumIdentifier"};
        String[] values = getFieldsByFieldName(storageLocation,keys);
        return arrayDetection(values);
    }
}
