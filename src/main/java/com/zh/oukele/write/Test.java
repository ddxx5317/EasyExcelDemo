package com.zh.oukele.write;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: DDxx
 * @Date: 2020/5/3
 */
public class Test {
    public static void main(String[] args) {
        List<TestVo> testVos = TestVo.trans();
        System.out.println(setExcelHeads(testVos));
    }

    private static List<List<String>> setExcelHeads(List<? extends BaseRowModel> rowModels) {
        final List<List<String>> headList = new ArrayList<List<String>>();
        for (BaseRowModel rowModel : rowModels) {
            final Field[] fields = rowModel.getClass().getDeclaredFields();
            for(Field field : fields){
                final boolean isFieldAnnotation = field.isAnnotationPresent(ExcelProperty.class);
                if(isFieldAnnotation){
                    ExcelProperty fieldAnnotation = field.getAnnotation(ExcelProperty.class);
                    //输出注解属性
                    String[] values = fieldAnnotation.value();
                    if (values != null && values.length > 0){
                        System.out.println(values[0]);
                        headList.add(Arrays.asList(values[0]));
                    }
                }
            }
        }
        return headList;
    }

}
