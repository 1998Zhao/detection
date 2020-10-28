package com.doxda.detection.strategy;

import com.doxda.detection.metadate.AggregationLevel;
import com.doxda.detection.metadate.ArchivalCode;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgq
 */
public class ArchivalCodeDetectionStrategy implements IDetectionStrategy{
    private ArchivalCode archivalCode;
    private AggregationLevel aggregationLevel;

    public ArchivalCode getArchivalCode() {
        return archivalCode;
    }

    public void setArchivalCode(ArchivalCode archivalCode) {
        this.archivalCode = archivalCode;
    }

    /**
     * 对元数据进行校验
     *
     * @return 校验结果
     */
    @Override
    public Result detection() {
        boolean check = false;
        Map<String ,String> map = new HashMap<String, String>();
        ArchivalCode archivalCode = this.archivalCode;
        String archivalCode1 = archivalCode.getArchivalCode();
        String retentionPeriod = archivalCode.getRetentionPeriod();
        String year = archivalCode.getYear();
        String [] array = new String[]{archivalCode1,retentionPeriod,year};
        int j =0;
        for (String s : array) {
            if (StringUtils.isNotBlank(s)){
                j++;
            }
            else {
                map.put(s,s+"值不能为空");
            }
        }
        if (j==array.length){
            check = true;
        }
        return new Result(check,map);
    }
}
