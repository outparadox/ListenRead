package com.luhuanju.listenread.utils;/*
 * Copyright (C) 2016，上海宅米贸易有限公司
 *
 * Author: huanjulu on 16/8/17 
 */

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 线程池的实现
 *
 * @param <T>
 */

public class ThreadPoolExcutorUtils<T extends Runnable> implements KThreadPool<T> {


    private static final int MAX_WORKER_NUMBERS = 10;


    private static final int DEFAULT_WORKER_NUMBERS = 5;


    private static final int MIN_WORKER_NUMBERS = 1;


    private int workNum = DEFAULT_WORKER_NUMBERS;


    private final LinkedList<T> workQueue = new LinkedList<T>();


    private final List<WorkerTask> workTasks = Collections.synchronizedList(new ArrayList<WorkerTask>());


    private AtomicLong threadNum = new AtomicLong();

    private volatile boolean running = true;


    public ThreadPoolExcutorUtils() {
        onInitWorkers(DEFAULT_WORKER_NUMBERS);
    }


    public ThreadPoolExcutorUtils(int num) {
        workNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;

    }


    @Override
    public void excute(@NotNull T t) {
        if (t != null) {
            synchronized (workQueue) {
                workQueue.addLast(t);
                workQueue.notify();
            }
        }
    }


    @Override
    public void addWorkers(int num) {

        synchronized (workQueue) {
            if (num + this.workNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workNum;
            }
            this.workNum += num;
        }

    }

    @Override
    public void removeWorker(int num) {
        synchronized (workQueue) {
            if (num >= this.workNum) {
                throw new IllegalArgumentException("beyoun workNum");
            }

            int count = 0;
            while (count < num) {
                WorkerTask workerTask = workTasks.get(count);
                if (workTasks.remove(workerTask)) {
                    workerTask.shurdown();
                    count++;
                }
                this.workNum -= count;
            }
        }
    }

    @Override
    public int getWorkerSize() {
        return workTasks.size();
    }


    /**
     * Just init run
     *
     * @param sum
     */
    private void onInitWorkers(int sum) {
        for (int i = 0; i < sum; i++) {
            WorkerTask workerTask = new WorkerTask();
            workTasks.add(workerTask);
            Thread thread = new Thread(workerTask, "Thread Pool Name" + threadNum);
            thread.start();
        }
    }

    class WorkerTask implements Runnable {

        @Override
        public void run() {
            while (running) {
                T t = null;
                synchronized (workQueue) {

                    while (workQueue.isEmpty()) {
                        try {
                            workQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    t = workQueue.removeFirst();
                }
                if (t != null) {

                    t.run();
                }
            }
        }

        private void shurdown() {
            running = false;
        }
    }


    @Override
    public void shutdown() {
        for (WorkerTask workerTask : workTasks) {
            workerTask.shurdown();
        }
    }

}
