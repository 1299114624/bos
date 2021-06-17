package com.archforce.bos.identity.shiro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "identity")
public class IdentityConfig {
    private Integer cluster;
    private Integer errLoginNum;
    private Long expireTime;
    private Integer lockTime;
    private List<String> anno;
    private List<String> authc;
    private List<String> external;
    private String kaptcha;
    private String dataPermissionConfig;
    /**
     * SSO校验的白名单配置
     */
    private List<String> sso;
    /**
     * 权限配置
     */
    private String orgTypeConfig;
    /**
     * 白名单用户
     */
    private List<String> whiteUser = new ArrayList<>();

    public Integer getCluster() {
        return cluster;
    }

    public void setCluster(Integer cluster) {
        this.cluster = cluster;
    }

    public Integer getErrLoginNum() {
        return errLoginNum;
    }

    public void setErrLoginNum(Integer errLoginNum) {
        this.errLoginNum = errLoginNum;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getLockTime() {
        return lockTime;
    }

    public void setLockTime(Integer lockTime) {
        this.lockTime = lockTime;
    }

    public List<String> getAnno() {
        return anno;
    }

    public void setAnno(List<String> anno) {
        this.anno = anno;
    }

    public List<String> getAuthc() {
        return authc;
    }

    public void setAuthc(List<String> authc) {
        this.authc = authc;
    }

    public List<String> getExternal() {
        return external;
    }

    public void setExternal(List<String> external) {
        this.external = external;
    }

    public String getKaptcha() {
        return kaptcha;
    }

    public void setKaptcha(String kaptcha) {
        this.kaptcha = kaptcha;
    }

    public String getDataPermissionConfig() {
        return dataPermissionConfig;
    }

    public void setDataPermissionConfig(String dataPermissionConfig) {
        this.dataPermissionConfig = dataPermissionConfig;
    }

    public List<String> getSso() {
        return sso;
    }

    public void setSso(List<String> sso) {
        this.sso = sso;
    }

    public String getOrgTypeConfig() {
        return orgTypeConfig;
    }

    public void setOrgTypeConfig(String orgTypeConfig) {
        this.orgTypeConfig = orgTypeConfig;
    }

    public List<String> getWhiteUser() {
        return whiteUser;
    }

    public void setWhiteUser(List<String> whiteUser) {
        this.whiteUser = whiteUser;
    }
}
