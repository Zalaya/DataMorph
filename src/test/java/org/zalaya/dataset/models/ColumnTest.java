package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.zalaya.dataset.enumerators.ColumnType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ColumnTest {

    @Test
    public void shouldThrowExceptionWhenNameIsNull() {
        String name = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Column(name, ColumnType.STRING);
        });
    }

    @Test
    public void shouldThrowExceptionWhenNameIsBlank() {
        String name = "";

        assertThrows(IllegalArgumentException.class, () -> {
            new Column(name, ColumnType.STRING);
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        ColumnType type = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Column("name", type);
        });
    }

    @Test
    public void shouldReturnColumnName() {
        String name = "name";
        Column column = new Column(name, ColumnType.STRING);

        assertEquals(name, column.name());
    }

    @Test
    public void shouldReturnColumnType() {
        ColumnType type = ColumnType.STRING;
        Column column = new Column("name", type);

        assertEquals(type, column.type());
    }

}
