package com.nebulaera.apptest;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义异常类
 *
 * @author gm
 */
public class MyException extends Exception {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * 用于报错多个异常
     */
    private List<Throwable> causes = new ArrayList<Throwable>();

    /**
     * 构造函数添加所有异常
     *
     * @param _causes
     */
    public MyException(List<? extends Throwable> _causes) {
        causes.addAll(_causes);
    }

    /**
     * 获取所有Exceptions
     *
     * @return List<Throwable>
     */
    public List<Throwable> getException() {
        return causes;
    }
}
