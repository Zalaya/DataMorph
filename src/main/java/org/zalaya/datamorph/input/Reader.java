package org.zalaya.datamorph.input;

import java.util.List;

public interface Reader<T> {

    List<String> read(T file);

}
