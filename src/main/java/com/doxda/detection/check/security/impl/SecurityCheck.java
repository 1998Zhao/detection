package com.doxda.detection.check.security.impl;

import com.doxda.detection.check.security.ISecurityCheck;
/**
 * 归档信息包病毒检测,归档载体安全性检测,归档过程安全性检测
 * @author zgq
 * createTime 2020-10-27
 */
public class SecurityCheck implements ISecurityCheck {
    /**
     * 归档信息包病毒检测
     *
     * @return 是否通过
     */
    @Override
    public boolean virusOfArchivePackageDetection() {
        return false;
    }

    /**
     * 归档载体安全性检测
     *
     * @return 是否通过
     */
    @Override
    public boolean vectorSecurityDetection() {
        return false;
    }

    /**
     * 归档过程安全性检测
     *
     * @return 是否通过
     */
    @Override
    public boolean processSecurityDetection() {
        return false;
    }
}
