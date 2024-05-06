package com.yongyuan.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MpGenerator {



    //    private static final String rootPath = System.getProperty("user.dir");
//    private static final String rootPath = "F:\\Project-program\\IDEA_PROJECT_PSON\\device-serve";
    private static final String rootPath = "D:\\project\\order";

    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("commoditySort");


        FastAutoGenerator.create("jdbc:mysql://localhost:3306/order?serverTimezone=Asia/Shanghai&useSSL=false","root","123456")
                .globalConfig(builder -> {
                    builder.author("fengsheming")               //作者
                            .outputDir(rootPath+"\\src\\main\\java")    //输出路径(写到java目录)
                            .commentDate("yyyy-MM-dd")
//                            .fileOverride()   //开启则会覆盖之前生成的文件
                    ;

                })
                .packageConfig(builder -> {
                    builder.parent("com.yongyuan.order")
                            .moduleName("")
                            .entity("entity")
                            .service("service")
                            .serviceImpl("app.service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,rootPath+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .serviceBuilder()
                            .formatServiceFileName("I%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
//                            .superClass(BasicEntity.class)
//                            .addSuperEntityColumns("MODIFY_DATE","MODIFY_ID","CREATE_DATE","CREATEOR_ID")
                            .enableLombok()
//                            .logicDeleteColumnName("deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            // 映射路径使用连字符格式，而不是驼峰
                            .enableHyphenStyle()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            //生成通用的resultMap
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })

               // .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
