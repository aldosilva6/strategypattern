package org.starbuzz.converter;

import java.io.*;

/**
 * Created by ainacio on Nov, 2023
 */
public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException{
        int c = in.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));
    }

    @Override
    public int read(byte[] b,int offset, int len) throws IOException{
        int result = in.read(b,offset,len);
        for(int i = offset; i < offset+result;i++){
            b[i] = (byte)Character.toLowerCase((char) b[i]);
        }
        return result;
    }
}