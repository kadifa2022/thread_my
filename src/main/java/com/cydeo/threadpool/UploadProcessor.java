package com.cydeo.threadpool;

public class UploadProcessor implements Runnable{
    private String fileName;

    public UploadProcessor(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has started upload " + fileName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " has completed to upload " + fileName);

    }
}
