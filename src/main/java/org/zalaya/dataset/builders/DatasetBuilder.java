package org.zalaya.dataset.builders;

import org.zalaya.dataset.models.Dataset;
import org.zalaya.dataset.models.Header;
import org.zalaya.dataset.models.Row;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatasetBuilder {

    private Set<Header> headers = new HashSet<>();
    private List<Row> rows = new ArrayList<>();

    public DatasetBuilder header(Header header) {
        this.headers.add(header);
        return this;
    }

    public DatasetBuilder headers(Set<Header> headers) {
        this.headers = headers;
        return this;
    }

    public DatasetBuilder row(Row row) {
        this.rows.add(row);
        return this;
    }

    public DatasetBuilder rows(List<Row> rows) {
        this.rows = rows;
        return this;
    }

    public Dataset build() {
        return new Dataset(headers, rows);
    }

}
