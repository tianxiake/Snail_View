package com.nebulaera.apptest;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {

    public static void main(String[] args) throws MyException {
        try {
            doException();
        } catch (MyException e) {
            e.printStackTrace();
            throw new MyException(e.getException());
        }
    }

    public static void doException() throws MyException {
        List<Throwable> list = new ArrayList<Throwable>();
        int num1 = 1;
        int num2 = 0;
        int result = 0;

        try {
            result = num1 / num2;
        } catch (Exception e) {
            list.add(e);
            System.out.println("第一个异常");
        }

        try {
            result = num1 / num2;
        } catch (Exception e) {
            list.add(e);
            System.out.println("第二个异常");
        }

        if (list.size() > 0) {
            throw new MyException(list);
        }
    }
}