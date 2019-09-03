package com.jcohy.scis.common;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiac on 2017/10/18 10:22.
 * ClassName  : JsonResult
 * Description  :
 */
public class JsonResult extends HashMap{
    private static final String STATUS_OK = "isOk";
    private static final String STATUS_FAIL = "isFail";

    public JsonResult() {
    }

    public static JsonResult ok() {
        return new JsonResult().setOk();
    }
    public static JsonResult ok(String msg) {
        return new JsonResult().setOk().set("msg", msg);
    }

    public static JsonResult ok(Object key, Object value) {
        return ok().set(key, value);
    }

    public static JsonResult fail() {
        return new JsonResult().setFail();
    }

    public static JsonResult fail(String msg) {
        return new JsonResult().setFail().set("msg", msg);
    }

    public static JsonResult fail(Object key, Object value) {
        return fail().set(key, value);
    }

    public static JsonResult create() {
        return new JsonResult();
    }

    public static JsonResult create(Object key, Object value) {
        return new JsonResult().set(key, value);
    }

    public JsonResult setOk() {
        super.put(STATUS_OK, Boolean.TRUE);
        super.put(STATUS_FAIL, Boolean.FALSE);
        return this;
    }

    public JsonResult setFail() {
        super.put(STATUS_OK, Boolean.FALSE);
        super.put(STATUS_FAIL, Boolean.TRUE);
        return this;
    }

    public boolean isOk() {
        Boolean isOk = (Boolean)get(STATUS_OK);
        return isOk != null && isOk;
    }

    public boolean isFail() {
        Boolean isFail = (Boolean)get(STATUS_FAIL);
        return isFail != null && isFail;
    }

    public JsonResult set(Object key, Object value) {
        super.put(key, value);
        return this;
    }

    public JsonResult set(Map map) {
        super.putAll(map);
        return this;
    }

    public JsonResult set(JsonResult ret) {
        super.putAll(ret);
        return this;
    }

    public JsonResult delete(Object key) {
        super.remove(key);
        return this;
    }

    public <T> T getAs(Object key) {
        return (T)get(key);
    }

    public String getStr(Object key) {
        return (String)get(key);
    }

    public Integer getInt(Object key) {
        return (Integer)get(key);
    }

    public Long getLong(Object key) {
        return (Long)get(key);
    }

    public Boolean getBoolean(Object key) {
        return (Boolean)get(key);
    }

    /**
     * key 存在，并且 value 不为 null
     */
    public boolean notNull(Object key) {
        return get(key) != null;
    }

    /**
     * key 不存在，或者 key 存在但 value 为null
     */
    public boolean isNull(Object key) {
        return get(key) == null;
    }

    /**
     * key 存在，并且 value 为 true，则返回 true
     */
    public boolean isTrue(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == true));
    }

    /**
     * key 存在，并且 value 为 false，则返回 true
     */
    public boolean isFalse(Object key) {
        Object value = get(key);
        return (value instanceof Boolean && ((Boolean)value == false));
    }

    public boolean equals(Object ret) {
        return ret instanceof JsonResult && super.equals(ret);
    }

}
