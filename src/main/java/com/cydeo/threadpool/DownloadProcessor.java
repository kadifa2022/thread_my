package com.cydeo.threadpool;

public class DownloadProcessor implements Runnable{

    private String fileName;

    public DownloadProcessor(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started download " + fileName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " has completed to download " + fileName);
    }

}
