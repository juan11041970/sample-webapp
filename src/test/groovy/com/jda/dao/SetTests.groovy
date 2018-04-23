package com.jda.dao

import com.jda.Department
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.junit.Assert.*;

import org.junit.Test
import org.junit.runner.RunWith

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
class SetTests {

    @Autowired
    Department dept = new Department()

    @Test
     void callSetter() {
        dept.setId(20)
        dept.setName("Accounting")
        dept.setDeptId(110)
    }
}
