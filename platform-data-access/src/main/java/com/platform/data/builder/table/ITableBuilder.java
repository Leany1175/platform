package com.platform.data.builder.table;

public interface ITableBuilder {

    /**
     * create table sql
     * @param tableBuilder table
     * @param format is format
     * @return sql
     */
    String build(TableBuilder tableBuilder, boolean format);

    default String build(TableBuilder tableBuilder) {
        return build(tableBuilder, false);
    }

}
