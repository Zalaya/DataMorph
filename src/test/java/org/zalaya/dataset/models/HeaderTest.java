package org.zalaya.dataset.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.zalaya.dataset.enumerators.HeaderType;
import org.zalaya.dataset.exceptions.InvalidHeaderException;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void shouldThrowExceptionWhenNameIsInvalid(String name) {
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void shouldThrowExceptionWhenNameIsInvalidForBuilder(String name) {
        HeaderType type = HeaderType.STRING;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNull() {
        String name = "name";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            new Header(name, type);
        });
    }

    @Test
    public void shouldThrowExceptionWhenTypeIsNullForBuilder() {
        String name = "name";
        HeaderType type = null;

        assertThrows(InvalidHeaderException.class, () -> {
            Header.builder()
                .name(name)
                .type(type)
                .build();
        });
    }

    @Test
    public void shouldInstantiateHeaderWhenNameAndTypeAreValid() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = new Header(name, type);

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @Test
    public void shouldBuildHeaderWhenNameAndTypeAreValid() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header = Header.builder()
            .name(name)
            .type(type)
            .build();

        assertEquals(name, header.getName());
        assertEquals(type, header.getType());
    }

    @Test
    public void shouldReturnTrueWhenComparingHeadersWithSameNameAndType() {
        String name = "name";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name, type);
        Header header2 = new Header(name, type);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnTrueWhenComparingHeadersWithSameNameAndDifferentType() {
        String name = "name";
        HeaderType type1 = HeaderType.STRING;
        HeaderType type2 = HeaderType.NUMBER;

        Header header1 = new Header(name, type1);
        Header header2 = new Header(name, type2);

        assertEquals(header1, header2);
    }

    @Test
    public void shouldReturnFalseWhenComparingHeadersWithDifferentName() {
        String name1 = "name1";
        String name2 = "name2";
        HeaderType type = HeaderType.STRING;

        Header header1 = new Header(name1, type);
        Header header2 = new Header(name2, type);

        assertNotEquals(header1, header2);
    }

}