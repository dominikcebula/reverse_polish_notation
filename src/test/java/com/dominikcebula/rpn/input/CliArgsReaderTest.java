package com.dominikcebula.rpn.input;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class CliArgsReaderTest {

    @Test
    public void shouldProvideArgumentsAsResult() {
        String[] args = {"3", "4", "5", "-", "+"};

        CliArgsReader cliArgsReader = new CliArgsReader(args);

        assertSame(args, cliArgsReader.readTokens());
    }
}