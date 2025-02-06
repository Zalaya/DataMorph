package xyz.zalaya.dataset.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import xyz.zalaya.dataset.exceptions.HeaderTypeMismatchException;
import xyz.zalaya.dataset.exceptions.RowValidationException;
import xyz.zalaya.dataset.mocks.MockHeaderType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    private List<Header> headers;

    @BeforeEach
    void setUp() {
        headers = List.of(
            new Header("header1", MockHeaderType.STRING),
            new Header("header2", MockHeaderType.INTEGER),
            new Header("header3", MockHeaderType.BOOLEAN)
        );
    }

    @Test
    void shouldCreateRowWithValidAttributes() {
        List<Object> cells = List.of("cell", 1, true);
        Row row = new Row(headers, cells);

        assertAll(
            () -> assertEquals(cells, row.getCells()),
            () -> assertEquals(cells.size(), row.getCells().size())
        );
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

    @Test
    void shouldReturnTrueWhenComparingTwoRowsWithSameCells() {
        List<Object> cells = List.of("cell", 1, true);
        Row row1 = new Row(headers, cells);
        Row row2 = new Row(headers, cells);

        assertEquals(row1, row2);
    }

    @Test
    void shouldReturnFalseWhenComparingTwoRowsWithDifferentCells() {
        List<Object> cells1 = List.of("cell", 1, true);
        List<Object> cells2 = List.of("cell", 1, false);
        Row row1 = new Row(headers, cells1);
        Row row2 = new Row(headers, cells2);

        assertNotEquals(row1, row2);
    }

}
