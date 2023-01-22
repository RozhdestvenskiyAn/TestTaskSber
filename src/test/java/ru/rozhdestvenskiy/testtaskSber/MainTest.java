package ru.rozhdestvenskiy.testtaskSber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static ru.rozhdestvemskiy.testTaskSber.Main.*;


public class MainTest {

    public static final String PATH_FILE = "src/test/resources/test.xslx";

    @Test
    public void test(){
        Set<String> result = readXSLXFile(PATH_FILE);

        Assertions.assertEquals(43, result.size());
        Assertions.assertTrue(result.contains("Т704НМ799"));
    }
}
