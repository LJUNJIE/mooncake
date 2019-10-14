package com.moon.systemapi.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@TableName("sys_log_info")
public class SysLogInfo extends Model<SysLogInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 服务ID
     */
    @TableField("service_id")
    private String serviceId;

    /**
     * 服务器名
     */
    @TableField("server_host")
    private String serverHost;

    /**
     * 服务器IP地址
     */
    @TableField("server_ip")
    private String serverIp;

    /**
     * 系统环境
     */
    private String env;

    /**
     * 日志级别
     */
    @TableField("log_level")
    private String logLevel;

    /**
     * 日志业务id
     */
    @TableField("log_id")
    private String logId;

    /**
     * 日志数据
     */
    @TableField("log_data")
    private String logData;

    /**
     * 操作方式
     */
    private String method;

    /**
     * 请求URI
     */
    @TableField("request_uri")
    private String requestUri;

    /**
     * 操作IP地址
     */
    @TableField("remote_ip")
    private String remoteIp;

    /**
     * 方法类
     */
    @TableField("method_class")
    private String methodClass;

    /**
     * 方法名
     */
    @TableField("method_name")
    private String methodName;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 执行时间
     */
    private Date time;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }
    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }
    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }
    public String getMethodClass() {
        return methodClass;
    }

    public void setMethodClass(String methodClass) {
        this.methodClass = methodClass;
    }
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysLogInfo{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", serviceId=" + serviceId +
        ", serverHost=" + serverHost +
        ", serverIp=" + serverIp +
        ", env=" + env +
        ", logLevel=" + logLevel +
        ", logId=" + logId +
        ", logData=" + logData +
        ", method=" + method +
        ", requestUri=" + requestUri +
        ", remoteIp=" + remoteIp +
        ", methodClass=" + methodClass +
        ", methodName=" + methodName +
        ", userAgent=" + userAgent +
        ", params=" + params +
        ", time=" + time +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        "}";
    }
}
