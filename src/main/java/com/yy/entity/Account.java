package com.yy.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: com.yy.entity
 * @ClassName: Account
 * @Author: Created By Yy
 * @Date: 2019-07-03 16:16
 */
@ConfigurationProperties(prefix = "ai")
@Component
public class Account {

    private Integer appId;

    private String appKey;

    public Account() {
    }

    public Integer getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Account)) return false;
        final Account other = (Account) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$appId = this.getAppId();
        final Object other$appId = other.getAppId();
        if (this$appId == null ? other$appId != null : !this$appId.equals(other$appId)) return false;
        final Object this$appKey = this.getAppKey();
        final Object other$appKey = other.getAppKey();
        if (this$appKey == null ? other$appKey != null : !this$appKey.equals(other$appKey)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Account;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $appId = this.getAppId();
        result = result * PRIME + ($appId == null ? 43 : $appId.hashCode());
        final Object $appKey = this.getAppKey();
        result = result * PRIME + ($appKey == null ? 43 : $appKey.hashCode());
        return result;
    }

    public String toString() {
        return "Account(appId=" + this.getAppId() + ", appKey=" + this.getAppKey() + ")";
    }
}
