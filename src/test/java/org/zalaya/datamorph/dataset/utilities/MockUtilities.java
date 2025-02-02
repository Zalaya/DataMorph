package org.zalaya.datamorph.dataset.utilities;

import org.zalaya.datamorph.dataset.enumerators.HeaderType;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class MockUtilities {

    public static HeaderType mockHeaderType(Class<?> type) {
        HeaderType mockHeaderType = mock(HeaderType.class);
        doReturn(type).when(mockHeaderType).getType();

        return mockHeaderType;
    }

}
