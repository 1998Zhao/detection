package com.doxda.detection.strategy;

import com.doxda.detection.metadate.Provenance;
import com.doxda.detection.result.Result;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgq
 */
public class SourceDetectionStrategy implements IDetectionStrategy{
    private final Provenance provenance;

    public SourceDetectionStrategy(Provenance provenance) {
        this.provenance = provenance;
    }

    /**
     * 对元数据进行校验
     * @return 校验结果
     */
    @Override
    public Result detection() {
        Map<String,String> map = new HashMap<String, String>();
        try {
            Provenance s = this.provenance;
            String provenance =s.getProvenance();
            String archivesName = s.getArchivesName();
            String archivesIdentifier = s.getArchivesIdentifier();
            String fondsName = s.getFondsName();
            String fondsConstitutingUnitName = s.getFondsConstitutingUnitName();
            String [] array = new String[]{provenance,archivesName,archivesIdentifier,fondsName,fondsConstitutingUnitName};
            return arrayDetection(array);
        }
        catch (Exception e){
            return new Result(false,map);
        }
    }

}
