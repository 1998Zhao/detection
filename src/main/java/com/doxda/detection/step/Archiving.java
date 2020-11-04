package com.doxda.detection.step;

import com.doxda.detection.check.authenticity.impl.Authenticity;
import com.doxda.detection.check.integrity.impl.IntegrityCheck;
import com.doxda.detection.check.security.impl.SecurityCheck;
import com.doxda.detection.check.usability.impl.UsabilityCheck;

/**
 * 归档环节
 * @author zgq
 * @create time 2020-11-04
 */
public class Archiving {
    Authenticity authenticity;
    IntegrityCheck integrityCheck;
    UsabilityCheck usabilityCheck;
    SecurityCheck securityCheck;

    public Authenticity getAuthenticity() {
        return authenticity;
    }

    public void setAuthenticityHandler(Authenticity authenticityHandler) {
        this.authenticity = authenticityHandler;
    }

    public IntegrityCheck getIntegrityCheck() {
        return integrityCheck;
    }

    public void setIntegrityCheck(IntegrityCheck integrityCheck) {
        this.integrityCheck = integrityCheck;
    }

    public UsabilityCheck getUsabilityCheck() {
        return usabilityCheck;
    }

    public void setUsabilityCheck(UsabilityCheck usabilityCheck) {
        this.usabilityCheck = usabilityCheck;
    }

    public SecurityCheck getSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(SecurityCheck securityCheck) {
        this.securityCheck = securityCheck;
    }
}
