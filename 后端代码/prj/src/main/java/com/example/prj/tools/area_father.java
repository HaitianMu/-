package com.example.prj.tools;

import java.io.Serializable;
import java.util.List;

public class area_father implements Serializable {
    public String name;
    public double value;
    public List<industryData> children;
}
