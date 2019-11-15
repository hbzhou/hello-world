package com.itsz.spi.bad.printer;

import com.itsz.spi.service.PrintService;

public class BadPrinterServiceImpl implements PrintService {


    @Override
    public void print() {
        System.out.println("I'm a bad printer, print things badly...");
    }
}
