package com.wancheli.init.generate.ro;

import lombok.Data;

import java.util.List;

@Data
public class GeneratorRO {

    // 指定生成的表名
    private List<String> tables;


    // 指定模块名
    private String moduleName;
}
