package com.bjpn.test;

import com.bjpn.bean.Emp;
import com.bjpn.mapper.EmpMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestDemo1 {
    @Test
public void testSelectOne(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("spring.xml");
        EmpMapper empMapper = (EmpMapper) beans.getBean("empMapper");
        Emp emp = empMapper.selectById(403);
        System.out.println("emp = " + emp);

    }
    @Test
    public void testInsertOne(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("spring.xml");
        EmpMapper empMapper = (EmpMapper) beans.getBean("empMapper");
        Emp emp = new Emp();
        emp.setEmpJob("主播");
        emp.setEmpName("猕猴桃");
        int i = empMapper.insert(emp);
        if(i>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");

        }

    }
    @Test
    public void selectByList(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("spring.xml");
        EmpMapper empMapper = (EmpMapper) beans.getBean("empMapper");
        int[] arr={403,404,405,406};
        List<Integer> ints = Arrays.asList(403,404,405,406);
        List<Emp> emps = empMapper.selectBatchIds(ints);
        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }
    @Test
    public void testSelectByMap(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("spring.xml");
        EmpMapper empMapper = (EmpMapper) beans.getBean("empMapper");
        HashMap<String, Object> map = new HashMap<>();
        map.put("emp_name", "秦志远");
        map.put("emp_no", 403);
        List<Emp> emps = empMapper.selectByMap(map);
        for (Emp emp : emps) {
            System.out.println("emp = " + emp);
        }
    }
}
