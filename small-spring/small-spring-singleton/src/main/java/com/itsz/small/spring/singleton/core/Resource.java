package com.itsz.small.spring.singleton.core;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {

    InputStream getInputStream() throws IOException;
}
