package com.ctbu.school.model;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("test")
public class Test {
    long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}
