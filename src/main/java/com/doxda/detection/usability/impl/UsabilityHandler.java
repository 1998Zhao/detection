package com.doxda.detection.usability.impl;

import com.doxda.detection.usability.UsabilityHandle;
/**
 * 电子文件元数据可用性检测,电子文件内容可用性检测,电子文件软硬件环境检测,归档信息包可用性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class UsabilityHandler implements UsabilityHandle {
    /**
     * 电子文件元数据可用性检测
     *
     * @return 是否通过
     */
    public boolean metadataUsabilityDetection() {
        return false;
    }

    /**
     * 电子文件内容可用性检测
     *
     * @return 是否通过
     */
    public boolean contentUsabilityDetection() {
        return false;
    }

    /**
     * 电子文件软硬件环境检测
     *
     * @return 是否通过
     */
    public boolean softwareAndHardwareEnvironmentDetection() {
        return false;
    }

    /**
     * 归档信息包可用性检测
     *
     * @return 是否通过
     */
    public boolean archivePacketDetection() {
        return false;
    }
}
