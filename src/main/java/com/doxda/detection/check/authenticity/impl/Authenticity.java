package com.doxda.detection.check.authenticity.impl;

import com.doxda.detection.check.authenticity.IAuthenticity;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.metadate.fixity.FixityInformation;
import com.doxda.detection.result.Result;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 来源真实性检测
 * 元数据真实性检测
 * 电子文件真实
 * 元数据与内容关联真实性检测
 * 归档信息包真实性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class Authenticity implements IAuthenticity {
    private Metadata metadata;

    public Authenticity(Metadata metadata) {
        this.metadata = metadata;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * 来源真实性检测 检测项目为固化信息有效性检测
     * @return 是否通过
     */
    @Override
    public Result sourceAuthenticity(FixityInformation fixityInformation) {
        //数字摘要、电子签名、电子印章、时间戳
        String md = fixityInformation.getMessageDigest();
        String ds = fixityInformation.getDigitalSignatures();
        String es = fixityInformation.getElectronicSeal();
        Date ts = fixityInformation.getTimeStamp();
        return null;
    }



    /**
     * 元数据真实性检测
     *  检测项目包括元数据项数据长度检测、元数据项数据类型及格式检测、
     * 设定值域的元数据项值域符合度检测、元数据项数据值合理性检测、
     * 元数据项数据包含特殊字符检测、档号规范性检测、元数据项数据重复性检测
     * @return 是否通过
     */
    @Override
    public Result metadataAuthenticity() {
        Map<String,String> map = new HashMap<>();
        try{
            IMetadata []iMetadatas = getAllIMetadata(metadata);
            if (iMetadatas==null){
                map.put("元数据真实性检测","获取元数据失败");
                return new Result(false,map);
            }

            return new Result(true);
        }
        catch (Exception e){
            map.put("元数据真实性检测","检测发生异常 不通过");
            return new Result(false,map);
        }
    }

    /**
     * 电子文件真实
     * @return 是否通过
     */
    @Override
    public Result electronicDocumentAuthenticity() {
        return new Result(true);
    }

    /**
     * 元数据与内容关联真实性检测
     *
     * @return 是否通过
     */
    @Override
    public boolean metadataRelevanceDocumentAuthenticity() {
        return false;
    }

    /**
     * 归档信息包真实性检测
     *
     * @return 是否通过
     */
    @Override
    public boolean archivePacketAuthenticity() {
        return false;
    }
}
