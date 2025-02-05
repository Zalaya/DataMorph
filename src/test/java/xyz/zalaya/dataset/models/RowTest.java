package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
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

    private List<Header> headers;

    @BeforeEach
    void setUp() {
        headers = List.of(
            new Header("header1", mockHeaderType(String.class)),
            new Header("header2", mockHeaderType(Integer.class)),
            new Header("header3", mockHeaderType(Boolean.class))
        );
    }

    @Test
    void shouldCreateRowWithValidAttributes() {
        List<Object> cells = List.of("cell", 1, true);
        Row row = new Row(headers, cells);

        assertEquals(cells, row.getCells());
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowExceptionWhenCellsAreNull(List<Object> cells) {
        assertThrows(RowValidationException.class, () -> {
            new Row(headers, cells);
        });
    }

    @Test
    void shouldThrowExceptionWhenCellCountDoesNotMatchHeaderCount() {
        List<Object> cells = List.of("cell", 1);

        assertThrows(RowValidationException.class, () -> {
            new Row(headers, cells);
        });
    }

    @Test
    void shouldThrowExceptionWhenCellTypeDoesNotMatchHeaderType() {
        List<Object> cells = List.of(1, true, "cell");

        assertThrows(HeaderTypeMismatchException.class, () -> {
            new Row(headers, cells);
        });
    }

}
