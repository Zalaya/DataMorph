package org.zalaya.dataset.inferers;

import org.zalaya.dataset.enumerators.HeaderType;

import java.util.List;

public interface TypeInferer<T extends HeaderType> {

    T infer(List<String> values);

}
