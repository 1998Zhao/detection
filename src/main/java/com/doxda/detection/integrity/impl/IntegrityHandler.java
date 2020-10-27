package com.doxda.detection.integrity.impl;

import com.doxda.detection.integrity.IntegrityHandle;
/**
 * 电子文件数据总量检测 电子文件数据总量检测 电子文件内容完整性检测 归档信息包完整性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class IntegrityHandler implements IntegrityHandle {
    /**
     * 电子文件数据总量检测
     *
     * @return 是否通过
     */
    public boolean electronicDocumentQuantityDetection() {
        return false;
    }

    /**
     * 电子文件元数据完整性检测
     *
     * @return 是否通过
     */
    public boolean metadataIntegrityDetection() {
        return false;
    }

    /**
     * 电子文件内容完整性检测
     *
     * @return 是否通过
     */
    public boolean contentIntegrityDetection() {
        return false;
    }

    /**
     * 归档信息包完整性检测
     *
     * @return 是否通过
     */
    public boolean archivePacketDetection() {
        return false;
    }
}
