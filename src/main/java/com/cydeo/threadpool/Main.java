package com.cydeo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService downloadExecutorService = Executors.newFixedThreadPool(5);

        DownloadProcessor downloadProcessor = new DownloadProcessor("File 1");
        DownloadProcessor downloadProcessor2 = new DownloadProcessor("File 2");
        DownloadProcessor downloadProcessor3 = new DownloadProcessor("File 3");

        downloadExecutorService.submit(downloadProcessor);
        downloadExecutorService.submit(downloadProcessor2);
        downloadExecutorService.submit(downloadProcessor3);

        downloadExecutorService.shutdown();

        ExecutorService uploadExecutorService = Executors.newCachedThreadPool();

        UploadProcessor uploadProcessor = new UploadProcessor("File 4");
        UploadProcessor uploadProcessor2 = new UploadProcessor("File 5");
        UploadProcessor uploadProcessor3 = new UploadProcessor("File 6");
        UploadProcessor uploadProcessor4 = new UploadProcessor("File 7");
        UploadProcessor uploadProcessor5 = new UploadProcessor("File 8");
        UploadProcessor uploadProcessor6 = new UploadProcessor("File 9");

        uploadExecutorService.submit(uploadProcessor);
        uploadExecutorService.submit(uploadProcessor2);
        uploadExecutorService.submit(uploadProcessor3);
        uploadExecutorService.submit(uploadProcessor4);
        uploadExecutorService.submit(uploadProcessor5);
        uploadExecutorService.submit(uploadProcessor6);

        uploadExecutorService.shutdown();

    }
}
