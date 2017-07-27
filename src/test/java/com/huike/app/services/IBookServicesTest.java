package com.huike.app.services;

import com.huike.app.bean.Book;
import com.huike.app.bean.Caterory;
import com.huike.app.servieces.IBookServices;
import com.huike.app.servieces.ICateroryServices;
import com.huike.tools.commons.PageBean;
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
@ContextConfiguration("classpath:spring/spring-*.xml")
public class IBookServicesTest {
    @Autowired
  private IBookServices services;

    @Test
    public void testBookserviceALl() throws Exception {
        PageBean<Book> pd=new PageBean<Book>();
        pd.setPageSize(3);
        pd.setPageNumber(5);
         Caterory caterory=new Caterory();
        caterory.setCid("5F79D0D246AD4216AC04E9C5FAB3199E");
        List<Book> list =  services.listbookbycategory(caterory,pd);
        System.out.println(list.toString());
    }
}