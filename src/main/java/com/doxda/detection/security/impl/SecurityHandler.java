package com.doxda.detection.security.impl;

import com.doxda.detection.security.SecurityHandle;
/**
 * 归档信息包病毒检测,归档载体安全性检测,归档过程安全性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class SecurityHandler implements SecurityHandle {
    /**
     * 归档信息包病毒检测
     *
     * @return 是否通过
     */
    public boolean virusOfArchivePackageDetection() {
        return false;
    }

    /**
     * 归档载体安全性检测
     *
     * @return 是否通过
     */
    public boolean vectorSecurityDetection() {
        return false;
    }

    /**
     * 归档过程安全性检测
     *
     * @return 是否通过
     */
    public boolean processSecurityDetection() {
        return false;
    }
}
