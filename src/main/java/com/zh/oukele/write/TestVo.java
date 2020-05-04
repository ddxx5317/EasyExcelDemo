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

    @ExcelProperty(value = {"序号"}, index = 0)
    private Long id;

    @ExcelProperty(value = {"名称"}, index = 1)
    private String name;

    @ExcelProperty(value = {"地址"}, index = 1)
    private String addr;

    public static List<TestVo> trans() {
        List<TestVo> targetList = new ArrayList<>();
                TestVo target = TestVo.builder()
                        .addr("成都")
                        .id(123L)
                        .build();
                targetList.add(target);
        return targetList;
    }

}