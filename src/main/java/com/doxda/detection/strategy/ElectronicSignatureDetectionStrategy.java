package com.doxda.detection.strategy;

import com.doxda.detection.result.Result;

import java.util.HashMap;

public class ElectronicSignatureDetectionStrategy implements IDetectionStrategy{
    /**
     * 对元数据进行校验
     * 电子签名不用校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        return new Result(true,new HashMap<>());
    }
}
