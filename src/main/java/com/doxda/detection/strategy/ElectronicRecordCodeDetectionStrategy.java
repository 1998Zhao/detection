package com.doxda.detection.strategy;

import com.doxda.detection.metadate.ElectronicRecordCode;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgq
 */
public class ElectronicRecordCodeDetectionStrategy implements IDetectionStrategy{
    private ElectronicRecordCode electronicRecordCode;
    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        boolean check = false;
        Map<String,String> map = new HashMap<String, String>();
        String code = this.electronicRecordCode.getElectronicRecordCode();
        if (StringUtils.isNotBlank(code)){
            check = true;
        }
        else{
            map.put("electronicRecordCode","electronicRecordCode不能为空");
        }
        return new Result(check,map);
    }
}
