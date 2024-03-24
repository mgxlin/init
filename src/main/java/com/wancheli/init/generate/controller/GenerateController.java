package com.wancheli.init.generate.controller;

import com.mgxlin.module.generator.Generator;
import com.wancheli.init.generate.ro.GeneratorRO;
import com.wancheli.init.generate.service.GenerateService;
import com.wancheli.init.util.ZipUtil;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class GenerateController {

    @Resource
    private GenerateService generateService;

    @Resource
    private Generator generator;

    @GetMapping("/")
    private ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @GetMapping("tables")
    private List<String> getTables() {
        return generateService.getTables();
    }

    @PostMapping("generator")
    public ResponseEntity<ByteArrayResource> generator(@RequestBody GeneratorRO ro) throws IOException {

        List<String> tables = ro.getTables();
        String moduleName = ro.getModuleName();
        if (CollectionUtils.isEmpty(tables) || !StringUtils.hasLength(moduleName)) {
            return null;
        }

        String path = generator.generator(ro.getTables(), ro.getModuleName());

        File file = new File(path);
        byte[] zip = ZipUtil.zipFolder(file);

        if (file.exists()) {
            deleteFolder(file);
            System.out.println("文件夹已成功删除。");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attchement;filename=" + file.getName()+".zip");

        //设置响应状态
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(zip));
    }

    public static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        folder.delete();
    }

}
