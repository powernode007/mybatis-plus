package com.bjpn.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bjpn.bean.Emp;
import com.bjpn.mapper.EmpMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDemo2 {
    @Test
    public void SelectByList(){
        ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext("spring.xml");
        EmpMapper empMapper = (EmpMapper) beans.getBean("empMapper");
        QueryWrapper<Emp> wrapper = new QueryWrapper<>();
        UpdateWrapper<Emp> wrapper2 = Wrappers.update();
//        wrapper.gt("emp_sal", 1000);
        wrapper2.like("emp_name", "远").set("emp_sal", 50000);

//        wrapper2.set("emp_job", "美食家");
//        wrapper2.eq("emp_no",408);

        Emp emp1 = new Emp();
        emp1.setDeptNo(4);
//        emp1.setEmpJob("主播");
//        emp1.setEmpName("大哥远");

//        int insert = empMapper.insert(emp1);//增
//        int delete = empMapper.delete(wrapper2);//删
//        List<Emp> emps = empMapper.selectList(wrapper);//查
        int update = empMapper.update(emp1, wrapper2);//改

//        int i = empMapper.updateById(emp1);//id改

//        for (Emp emp : emps) {
//            System.out.println("emp = " + emp);
//        }
    }
}
