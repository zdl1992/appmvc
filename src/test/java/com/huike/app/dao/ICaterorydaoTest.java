package com.huike.app.dao;

import com.huike.app.bean.Caterory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author dhc
 * @version V1.0
 * @date 17/7/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ICaterorydaoTest {
    @Autowired
  private ICaterorydao inodedao;

    @Test
    public void testListAll() throws Exception {
        List<Caterory> list =  inodedao.getlistNode();
        System.out.println(list.toString());
    }
}