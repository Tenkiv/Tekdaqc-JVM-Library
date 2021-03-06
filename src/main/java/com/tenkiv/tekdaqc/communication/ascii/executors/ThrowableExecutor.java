package com.tenkiv.tekdaqc.communication.ascii.executors;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Class which handles Exceptions that occur when executing threads in an Executor.
 */
public class ThrowableExecutor extends ThreadPoolExecutor {
    public ThrowableExecutor(final int numThreads, final ThreadFactory factory) {
        super(3, numThreads, 0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(), factory);
    }

    public ThrowableExecutor(final int numThreads){
        super(3,numThreads,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) throws RuntimeException {
        super.afterExecute(r, t);

        if(t != null){
            throw new RuntimeException(t);
        }
    }
}
