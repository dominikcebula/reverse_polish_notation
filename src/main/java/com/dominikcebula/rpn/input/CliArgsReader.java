package com.dominikcebula.rpn.input;

public class CliArgsReader implements InputReader {

    private final String[] args;

    public CliArgsReader(String[] args) {
        this.args = args;
    }

    @Override
    public String[] readTokens() {
        return args;
    }
}
