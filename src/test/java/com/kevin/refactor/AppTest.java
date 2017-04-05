package com.kevin.refactor;

import com.kevin.refactor.method.LoopReplaceIf;
import junit.framework.TestCase;

public class AppTest extends TestCase {

    public static void main(String[] args) {
        LoopReplaceIf loopReplaceIf = new LoopReplaceIf();
        loopReplaceIf.reBuildGitURLBad("123", "123", "234");
    }
}
