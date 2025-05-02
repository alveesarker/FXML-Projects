package com.cse.oop.final_section1_1234567;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableOutputStream extends ObjectOutputStream {
    public AppendableOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException{
//    l
    }
}
