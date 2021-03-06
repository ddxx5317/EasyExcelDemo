package com.zh.oukele.write;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/5/3
 */
public class TestExcel {
    public static void main(String[] args) {
        List<TestVo> testVos = TestVo.trans();
        System.out.println(setExcelHeads(testVos));
    }

    private static List<List<String>> setExcelHeads(final List<? extends BaseRowModel> rowModels) {
        if(rowModels == null || rowModels.size() < 1){
            return null;
        }
        final List<List<String>> headList = new ArrayList<List<String>>();
        final List<Field> fieldList = new ArrayList<Field>();
        final Field[] fields = rowModels.get(0).getClass().getDeclaredFields();
        for(Field field : fields){
            if(!field.isAnnotationPresent(ExcelProperty.class)){
                continue;
            }
            if(field.getAnnotation(ExcelProperty.class) == null){
                continue;
            }
            fieldList.add(field);
        }
        if(fieldList == null || fieldList.isEmpty()){
            return null;
        }
        fieldList.sort(Comparator.comparingInt(field -> field.getAnnotation(ExcelProperty.class).index()));
        for (Field field : fieldList) {
            final String[] values = field.getAnnotation(ExcelProperty.class).value();
            if (values != null && values.length > 0){
                final ExcelHeadEnum excelHeadEnum = ExcelHeadEnum.getEnumByName(values[0]);
                if (excelHeadEnum != null) {
                    System.out.println(values[0]);
                    headList.add(Arrays.asList(excelHeadEnum.getClass().getSimpleName() + "_" + excelHeadEnum.getCode()));
                }else{
                    headList.add(Arrays.asList(values[0]));
                }
            }
        }
        return headList;
    }
}
