package com.jcohy.scis.common;

import java.util.List;
import java.util.Map;

/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:51 2018/5/30
 * Email: jia_chao23@126.com
 * ClassName: Graph
 * Description:
 **/
public class Graph {

    private List<Data> type;

    private List<Data> deptMap;

    private List<Data> year;

    public List<Data> getType() {
        return type;
    }

    public void setType(List<Data> type) {
        this.type = type;
    }

    public List<Data> getDeptMap() {
        return deptMap;
    }

    public void setDeptMap(List<Data> deptMap) {
        this.deptMap = deptMap;
    }

    public List<Data> getYear() {
        return year;
    }

    public void setYear(List<Data> year) {
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("type=").append(type);
        sb.append(", deptMap=").append(deptMap);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}
