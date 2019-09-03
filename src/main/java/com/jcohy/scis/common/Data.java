package com.jcohy.scis.common;

/**
 * Created by jiac on 2018/5/26.
 * ClassName  : com.jcohy.scis.common
 * Description  :
 */
public class Data {

    private String label;
    private Integer value;

    public Data() {
    }

    public Data(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
}
