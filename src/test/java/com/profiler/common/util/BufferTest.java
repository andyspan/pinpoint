package com.profiler.common.util;

import junit.framework.Assert;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DirectBinaryEncoder;
import org.apache.avro.io.EncoderFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 *
 */
public class BufferTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testPutPrefixedBytes() throws Exception {
        String test = "test";
        int expected = 3333;

        Buffer buffer = new Buffer(1024);
        buffer.putPrefixedBytes(test.getBytes("UTF-8"));

        buffer.put(expected);
        byte[] buffer1 = buffer.getBuffer();

        Buffer actual = new Buffer(buffer1);
        String s = actual.readPrefixedString();
        Assert.assertEquals(test, s);

        int i = actual.readInt();
        Assert.assertEquals(expected, i);


    }

    @Test
    public void testReadByte() throws Exception {

    }

    @Test
    public void testReadBoolean() throws Exception {

    }

    @Test
    public void testReadInt() throws Exception {

    }

    @Test
    public void testReadLong() throws Exception {

    }

    @Test
    public void testReadPrefixedBytes() throws Exception {
        Buffer buffer = new Buffer(1024);
        buffer.put1PrefixedBytes("string".getBytes("UTF-8"));
        byte[] buffer1 = buffer.getBuffer();

        Buffer read = new Buffer(buffer1);
        byte[] bytes = read.read1PrefixedBytes();
        String s = new String(bytes, "UTF-8");
        logger.info(s);
    }

    @Test
    public void testReadPrefixedString() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

    }


    @Test
    public void testGetBuffer() throws Exception {

    }

    @Test
    public void testGetOffset() throws Exception {

    }
}
