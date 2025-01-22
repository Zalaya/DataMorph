package org.zalaya.dataset.enumerators;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeaderTypeTest {

    @Test
    public void shouldReturnCorrectClassForNumber() {
        HeaderType headerType = HeaderType.NUMBER;
        Class<?> type = headerType.getClazz();

        assertEquals(Number.class, type);
    }

    @Test
    public void shouldReturnCorrectClassForString() {
        HeaderType headerType = HeaderType.STRING;
        Class<?> type = headerType.getClazz();

        assertEquals(String.class, type);
    }

    @Test
    public void shouldReturnCorrectClassForDate() {
        HeaderType headerType = HeaderType.DATE;
        Class<?> type = headerType.getClazz();

        assertEquals(Date.class, type);
    }

}
