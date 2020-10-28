package com.doxda.detection.strategy;

import com.doxda.detection.metadate.Source;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgq
 */
public class SourceDetectionStrategy implements IDetectionStrategy{
    private final Source source;

    public SourceDetectionStrategy(Source source) {
        this.source = source;
    }

    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        boolean check = false;
        Map<String,String> map = new HashMap<String, String>();
        try {
            Source s = this.source;
            String archivesName = s.getArchivesName();
            String archivesIdentifier = s.getArchivesIdentifier();
            String fondsName = s.getFondsName();
            String fondsConstitutingUnitName = s.getFondsConstitutingUnitName();
            String [] array = new String[]{archivesName,archivesIdentifier,fondsName,fondsConstitutingUnitName};
            int j =0;
            for (String value : array) {
                if (StringUtils.isNotBlank(value)) {
                    j++;
                } else {
                    map.put(value, value + "的值不能为空");
                }
            }
            if (j==4){
                check = true;
            }
            return new Result(check,map);
        }
        catch (Exception e){
            return new Result(check,map);
        }
    }

}
