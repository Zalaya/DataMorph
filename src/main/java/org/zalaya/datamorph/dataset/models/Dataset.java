package org.zalaya.datamorph.dataset.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode(exclude = {"headers", "rows"})
public class Dataset {

    private final String name;
    private final List<Header> headers;
    private final List<Row> rows;

    // TODO: A Dataset can't have two duplicate headers.
    // TODO: A Dataset row must have the same number of cells as the number of headers.
    // TODO: A Dataset row cell must be of the same type as the header type.

    public Dataset(String name, List<Header> headers, List<Row> rows) {
        this.name = name;
        this.headers = headers;
        this.rows = rows;
    }

}
