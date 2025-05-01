package com.example.finalpreparation;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class AppendableObjectStream extends ObjectOutputStream {
    public AppendableObjectStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // do nothing — skip writing a new header
    }
}
