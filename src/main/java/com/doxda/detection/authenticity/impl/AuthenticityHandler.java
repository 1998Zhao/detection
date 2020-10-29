package com.doxda.detection.authenticity.impl;

import com.doxda.detection.authenticity.AuthenticityHandle;
import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 来源真实性检测 元数据真实性检测 电子文件真实 元数据与内容关联真实性检测 归档信息包真实性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class AuthenticityHandler implements AuthenticityHandle {
    /**
     * 来源真实性检测 检测项目为固化信息有效性检测
     * @return 是否通过
     */
    @Override
    public Result sourceAuthenticity(String filename) {
        FileInputStream in =null;
        Map<String,String> map = new HashMap<>();
        try{
            in = new FileInputStream(filename);
            byte[] buffer = new byte[5];
            int c=in.read(buffer,0,5);
            if ("%PDF-".equals(new String(buffer))){
                return new Result(true);
            }
        }
        catch (Exception e){
            //e.printStackTrace();
            map.put("来源真实性检测",e.getMessage());
            return new Result(false,map);
        }
        finally {
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new Result(false,map);
    }

    public static void main(String[] args) {
        AuthenticityHandler a= new AuthenticityHandler();
        a.sourceAuthenticity("C:\\Users\\admin\\Desktop\\(样本)人事档案目录.pdf");
    }

    /**
     * 元数据真实性检测
     *  检测项目包括元数据项数据长度检测、元数据项数据类型及格式检测、
     * 设定值域的元数据项值域符合度检测、元数据项数据值合理性检测、
     * 元数据项数据包含特殊字符检测、档号规范性检测、元数据项数据重复性检测
     * @return 是否通过
     */
    @Override
    public Result metadataAuthenticity(Metadata metadata) {
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
     *
     * @return 是否通过
     */
    @Override
    public boolean electronicDocumentAuthenticity() {
        return false;
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
