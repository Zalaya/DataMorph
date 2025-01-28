package org.zalaya.datamorph.dataset.utilities;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;

import static org.mockito.Mockito.*;

public class MockUtilities {

    public static HeaderType mockHeaderType(Class<?> type) {
        HeaderType headerType = mock(HeaderType.class);
        doReturn(type).when(headerType).getType();

        return headerType;
    }

}
