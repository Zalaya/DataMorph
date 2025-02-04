package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.exceptions.HeaderTypeMismatchException;
import xyz.zalaya.dataset.exceptions.validation.RowValidationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static xyz.zalaya.dataset.utilities.MockUtilities.mockHeaderType;

class RowTest {

    @Test
    void shouldCreateRowWithValidAttributes() {
        List<Header> headers = List.of(new Header("header1", mockHeaderType(String.class)));
        List<Object> cells = List.of("cell");
        Row row = new Row(headers, cells);

        assertEquals(cells, row.getCells());
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenCellsAreNull(List<Object> cells) {
        List<Header> headers = List.of(new Header("header", mockHeaderType(String.class)));

        assertThrows(RowValidationException.class, () -> {
            new Row(headers, cells);
        });
    }

    @Test
    void shouldThrowExceptionWhenCellCountDoesNotMatchHeaderCount() {
        List<Header> headers = List.of(new Header("header1", mockHeaderType(String.class)));
        List<Object> cells = List.of("cell1", "cell2");

        assertThrows(RowValidationException.class, () -> {
            new Row(headers, cells);
        });
    }

    @Test
    void shouldThrowExceptionWhenCellTypeDoesNotMatchHeaderType() {
        List<Header> headers = List.of(new Header("name", mockHeaderType(String.class)));
        List<Object> cells = List.of(1);

        assertThrows(HeaderTypeMismatchException.class, () -> {
            new Row(headers, cells);
        });
    }

}
