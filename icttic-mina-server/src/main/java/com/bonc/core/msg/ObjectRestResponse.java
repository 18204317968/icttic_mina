package com.bonc.core.msg;

/**
 * Created by wyx on 2017/12/26.
 */
public class ObjectRestResponse<T> {
    String code;
    String message;
    T data;

    //返回状态码
    private static final String SUCCESS = "0000"; //成功
    private static final String FAILED = "0001";  //失败
    private static final String NORECORDS = "0002"; //查询无记录
    private static final String NOSYSINFO = "0003"; //系统信息不存在或已经失效!
    private static final String NOAPIINFO = "0004"; //API信息不存在或已经失效!
    private static final String NOTOKENINFO = "0005"; //Token信息不存在或已经失效！
    private static final String TOKENUNEFFECTIVE = "0006"; //Token已失效!
    private static final String OBJECTTRANEXCEPTION = "0007"; //对象转换异常
    private static final String NULLPARA = "0012"; //必传参数不能为空
    private static final String OTHERREASON = "9999"; //其他原因

    public ObjectRestResponse success() {
        this.setCode(SUCCESS);
        return this;
    }

    public ObjectRestResponse failed() {
        this.setCode(FAILED);
        return this;
    }

    public ObjectRestResponse noRecords(){
        this.setCode(NORECORDS);
        return this;
    }

    public ObjectRestResponse noSysInfo(){
        this.setCode(NOSYSINFO);
        return this;
    }

    public ObjectRestResponse noApiInfo(){
        this.setCode(NOAPIINFO);
        return this;
    }

    public ObjectRestResponse noTokenInfo(){
        this.setCode(NOTOKENINFO);
        return this;
    }

    public ObjectRestResponse tokenUneffective(){
        this.setCode(TOKENUNEFFECTIVE);
        return this;
    }

    public ObjectRestResponse objectTranException(){
        this.setCode(OBJECTTRANEXCEPTION);
        return this;
    }

    public ObjectRestResponse nullPara(){
        this.setCode(NULLPARA);
        return this;
    }

    public ObjectRestResponse otherReason(){
        this.setCode(OTHERREASON);
        return this;
    }

    public ObjectRestResponse msg(String message) {
        this.setMessage(message);
        return this;
    }

    public ObjectRestResponse data(T data) {
        this.setData(data);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
