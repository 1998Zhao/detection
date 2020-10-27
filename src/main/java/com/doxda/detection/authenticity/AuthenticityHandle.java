package com.doxda.detection.authenticity;

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
    boolean sourceAuthenticity(String filename);

    /**
     * 元数据真实性检测
     * @return 是否通过
     */
    boolean metadataAuthenticity();
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
     *
     * @return 是否通过
     */
    boolean archivePacketAuthenticity();
}
