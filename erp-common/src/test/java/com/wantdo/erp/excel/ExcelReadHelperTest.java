package com.wantdo.erp.excel;

import com.wantdo.erp.excel.helper.ExcelReadHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */
public class ExcelReadHelperTest {

    @Test
    public void readRows() throws Exception{
        ArrayList<ArrayList<Object>> title = ExcelReadHelper.readRows("/usr/local/test.xlsx", 1, 5000);
        for(List<Object> row: title){
            for(Object cell: row){
                System.out.println(cell);
            }
        }
    }
}
