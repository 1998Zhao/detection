package com.doxda.detection.integrity;
/**
 * 电子文件数据总量检测 电子文件数据总量检测 电子文件内容完整性检测 归档信息包完整性检测
 * @author zgq
 * createTime 2020-10-27
 */
public interface IntegrityHandle {
    /**
     * 电子文件数据总量检测
     * @return 是否通过
     */
    boolean electronicDocumentQuantityDetection();

    /**
     * 电子文件数据总量检测
     * @return 是否通过
     */
    boolean metadataIntegrityDetection();
    /**
     * 电子文件内容完整性检测
     * @return 是否通过
     */
    boolean contentIntegrityDetection();
    /**
     * 归档信息包完整性检测
     * @return 是否通过
     */
    boolean archivePacketDetection();
}
