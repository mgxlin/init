package com.wancheli.init.generate.service;

import com.wancheli.init.generate.mapper.GeneratorMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class GenerateService {
    @Resource
    private GeneratorMapper generatorMapper;

    public List<String> getTables(){
        return generatorMapper.getTables();
    }

}
