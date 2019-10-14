package com.moon.systemapi.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统错误日志表
 * </p>
 *
 * @author xjl
 * @since 2019-09-26
 */
@TableName("sys_log_error")
public class SysLogError extends Model<SysLogError> {

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
     * 操作方式
     */
    private String method;

    /**
     * 请求URI
     */
    @TableField("request_uri")
    private String requestUri;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    private String userAgent;

    /**
     * 堆栈
     */
    @TableField("stack_trace")
    private String stackTrace;

    /**
     * 异常名
     */
    @TableField("exception_name")
    private String exceptionName;

    /**
     * 异常信息
     */
    private String message;

    /**
     * 错误行数
     */
    @TableField("line_number")
    private Integer lineNumber;

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
     * 文件名
     */
    @TableField("file_name")
    private String fileName;

    /**
     * 方法名
     */
    @TableField("method_name")
    private String methodName;

    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 执行时间
     */
    private String time;

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
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
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
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
        return "SysLogError{" +
        "id=" + id +
        ", tenantId=" + tenantId +
        ", serviceId=" + serviceId +
        ", serverHost=" + serverHost +
        ", serverIp=" + serverIp +
        ", env=" + env +
        ", method=" + method +
        ", requestUri=" + requestUri +
        ", userAgent=" + userAgent +
        ", stackTrace=" + stackTrace +
        ", exceptionName=" + exceptionName +
        ", message=" + message +
        ", lineNumber=" + lineNumber +
        ", remoteIp=" + remoteIp +
        ", methodClass=" + methodClass +
        ", fileName=" + fileName +
        ", methodName=" + methodName +
        ", params=" + params +
        ", time=" + time +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        "}";
    }
}
