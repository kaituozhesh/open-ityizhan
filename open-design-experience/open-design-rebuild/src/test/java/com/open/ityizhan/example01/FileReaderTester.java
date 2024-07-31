package com.open.ityizhan.example01;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTester extends TestCase {
    public FileReaderTester(String name) {
        super(name);
    }

    private FileReader input;

    @Override
    protected void setUp() {
        try {
            input = new FileReader("/Users/lin/ityizhan/code/open/open-ityizhan/open-design-experience/open-design-rebuild/src/test/resources/a.data");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void tearDown() throws Exception {
        input.close();
    }

    public void testRead() throws IOException {
        char ch = '&';
//        input.close();
        for (int i = 0; i < 4; i++) {
            ch = (char) input.read();
        }
        assertEquals('2', ch);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }


}