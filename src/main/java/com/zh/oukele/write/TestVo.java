package com.zh.oukele.write;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestVo extends BaseRowModel {

    @ExcelProperty(value = {"NO"}, index = 0)
    private Long id;

    @ExcelProperty(value = {"NAME"}, index = 1)
    private String name;

    @ExcelProperty(value = {"ADDR"}, index = 1)
    private String addr;

    public static List<TestVo> trans() {
        List<TestVo> targetList = new ArrayList<>();
        TestVo target = TestVo.builder()
                    .addr("成都")
                    .id(123L)
                    .build();
        targetList.add(target);
        TestVo target1= TestVo.builder()
                .addr("成都")
                .id(123L)
                .build();
        targetList.add(target1);
        return targetList;
    }

}