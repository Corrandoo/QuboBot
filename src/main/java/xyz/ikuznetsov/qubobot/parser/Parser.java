package xyz.ikuznetsov.qubobot.parser;

import java.io.IOException;

public interface Parser {
    String getInfo(String searchString) throws IOException;
}
