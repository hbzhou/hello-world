package com.itsz.spi.good.printer;

import com.itsz.spi.service.PrintService;

public class GoodPrinterServiceImpl implements PrintService {


    @Override
    public void print() {
        System.out.println("I'm a good printer, print things good!!!!");
    }
}
