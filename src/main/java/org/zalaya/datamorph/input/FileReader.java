package org.zalaya.datamorph.input;

import java.io.File;
import java.util.List;

public interface FileReader {

    List<String> read(File file);

}
