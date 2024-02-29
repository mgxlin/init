package com.wancheli.init.generate.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface GeneratorMapper {

    List<String> getTables();
}
