package com.issue1.dependence.common.generator;


import com.issue1.dependence.common.generator.entity.*;
import com.issue1.dependence.common.generator.helper.GeneratorHelper;

import com.issue1.dependence.common.properties.SysProperties;
import com.issue1.dependence.common.utils.StringUtil;
import com.issue1.dependence.common.generator.entity.Column;
import com.issue1.dependence.common.generator.entity.GeneratorConfig;
import com.issue1.dependence.common.generator.entity.Table;
import com.issue1.dependence.common.generator.mapper.GeneratorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author helit747@gmail.com
 * @date 2020/9/18 上午11:09
 * 自动生成处理
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class Handle {
    @Autowired
    private GeneratorHelper generatorHelper;
    @Autowired
    private GeneratorMapper generatorMapper;

    @Autowired
    private SysProperties sysProperties;
    /**
     * 通过表名来自动生成
     * @param schemaName
     */
    public void generateBySchema(String schemaName) {
        List<Table> tables = generatorMapper.getTables(schemaName);
        for (Table table : tables) {
            try {
                generate(schemaName,table.getName(),table.getRemark());
            }catch (Exception e){
                log.error("代码生成异常...");
                e.printStackTrace();
            }
        }

    }

    private void generate(String schemaName,String tableName,String remark) throws Exception {
        GeneratorConfig generatorConfig = sysProperties.getGenerator();
        generatorConfig.setTableName(tableName);
        generatorConfig.setClassName(StringUtil.underscoreToCamel(tableName));
        generatorConfig.setTableComment(remark);
        // 生成代码到临时目录
        //fixme 获取每个表的所有列属性
        List<Column> columns = generatorMapper.getColumns(GeneratorConstant.DATABASE_TYPE, schemaName, tableName);
        generatorHelper.generateEntityFile(columns, generatorConfig);
        generatorHelper.generateMapperFile(columns, generatorConfig);
        generatorHelper.generateMapperXmlFile(columns, generatorConfig);
        generatorHelper.generateServiceFile(columns, generatorConfig);
        generatorHelper.generateServiceImplFile(columns, generatorConfig);
        generatorHelper.generateControllerFile(columns, generatorConfig);
    }
}
