package com.huike.app.dao;

import com.huike.app.bean.Book;
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
public class IBookdaoTest {
    @Autowired
  private IBookDao iBookDao;

    @Test
    public void testListAll() throws Exception {
        Caterory caterory=new Caterory();
        caterory.setCid("5F79D0D246AD4216AC04E9C5FAB3199E");
        List<Book> list =  iBookDao.listbookByCategroy(caterory,0,2);
        System.out.println(list.toString());
    }

    @Test
    public void testListCount() throws Exception {
        Caterory caterory=new Caterory();
        caterory.setCid("5F79D0D246AD4216AC04E9C5FAB3199E");
       int list =  iBookDao.countCategory(caterory);
        System.out.println(list);
    }
    @Test
    public void testdescBook() throws Exception {
        Book book=iBookDao.getdescBook("000A18FDB38F470DBE9CD0972BADB23F");
        System.out.println(book);
    }

}