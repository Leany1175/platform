package com.platform.data.builder.table;

import com.platform.data.entity.TableConstruction;

public interface ITableBuilder {

    String build(TableConstruction construction, boolean format);

}
