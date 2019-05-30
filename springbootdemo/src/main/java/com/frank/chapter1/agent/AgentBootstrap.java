package com.frank.chapter1.agent;

import java.lang.instrument.Instrumentation;

/**
 * 代理启动类
 */
public class AgentBootstrap {

    /**
     * -javaagent方式启动
     *
     * @param args
     * @param inst
     */
    public static void premain(String args, Instrumentation inst) {
        main(args, inst);
    }

    /**
     * attach方式启动
     *
     * @param args
     * @param inst
     */
    public static void agentmain(String args, Instrumentation inst) {
        main(args, inst);
    }

    private static void main(String args, Instrumentation inst) {
        inst.addTransformer(new LogTransformer(), true);
    }
}
