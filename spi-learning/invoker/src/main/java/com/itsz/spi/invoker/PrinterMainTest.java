package com.itsz.spi.invoker;

import com.itsz.spi.service.PrintService;

import java.util.ServiceLoader;

public class PrinterMainTest {

    public static void main(String[] args) {
        ServiceLoader<PrintService> printServiceServiceLoader = ServiceLoader.load(PrintService.class);
        for (PrintService printService : printServiceServiceLoader) {
            printService.print();
        }
    }
}
