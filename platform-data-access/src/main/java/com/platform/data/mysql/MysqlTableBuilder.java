package com.platform.data.mysql;

import com.platform.data.builder.column.IColumnBuilder;
import com.platform.data.builder.table.BaseTableBuilder;
import com.platform.data.builder.column.ColumnBuilders;
import com.platform.data.builder.table.TableBuilder;
import com.platform.data.entity.ColumnConstruction;
import com.platform.data.model.ColumnMeta;

public class MysqlTableBuilder extends BaseTableBuilder {

    public MysqlTableBuilder() {
        this.columnBuilder = new MysqlColumnBuilder();
    }

    //    @Override
//    protected String buildColumn(ColumnMeta columnMeta) {
//        return null;
//    }



}
