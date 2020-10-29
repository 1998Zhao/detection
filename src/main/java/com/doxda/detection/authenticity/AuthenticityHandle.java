package com.doxda.detection.authenticity;

import com.doxda.detection.metadate.IMetadata;
import com.doxda.detection.metadate.Metadata;
import com.doxda.detection.result.Result;

import java.lang.reflect.Field;

/**
 * 来源真实性检测 元数据真实性检测 电子文件真实 元数据与内容关联真实性检测 归档信息包真实性检测
 * @author zgq
 * createTime 2020-10-27
 */
public interface AuthenticityHandle {
    /**
     * 来源真实性检测 检测项目为固化信息有效性检测
     * @param filename 文件路径
     * @return 是否通过
     */
    Result sourceAuthenticity(String filename);

    /**
     * 元数据真实性检测
     * @param metadata 元数据
     * @return 是否通过
     */
    Result metadataAuthenticity(Metadata metadata);

    /**
     * 电子文件真实
     * @return 是否通过
     */
    boolean electronicDocumentAuthenticity();

    /**
     * 元数据与内容关联真实性检测
     * @return 是否通过
     */
    boolean metadataRelevanceDocumentAuthenticity();

    /**
     *  asd
     * @return 是否通过
     */
    boolean archivePacketAuthenticity();

    /**
     * 获取元数据的子元素
     * @param metadata 元数据
     * @return 子元素数组
     */
    default IMetadata[] getAllIMetadata(Metadata metadata){
        try{
            Class c = metadata.getClass();
            Field[] fields = c.getDeclaredFields();
            IMetadata [] array= new IMetadata[fields.length];
            for (int i=0;i<fields.length;i++) {
                fields[i].setAccessible(true);
                array[i]= (IMetadata) fields[i].get(metadata);
            }
            return array;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
