package com.huike.app.servieces.impl;

import com.huike.app.bean.Book;
import com.huike.app.bean.Caterory;
import com.huike.app.dao.IBookDao;
import com.huike.app.servieces.IBookServices;
import com.huike.tools.commons.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zero on 2017/7/24.
 */
@Service
public class BookServicesimpl implements IBookServices {

    @Autowired
    private IBookDao bookDao;
    @Override
    public List<Book> listbookbycategory(Caterory caterory, PageBean<Book> pd) {
        try {
            int size=pd.getPageSize();
            int start=(pd.getPageNumber()-1)*size;
            return bookDao.listbookByCategroy(caterory,start,size);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public int countbookByCategory(Caterory caterory) {
        try {
            return bookDao.countCategory(caterory);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    @Override
    public Book getdescBook(String bid) {
        try {
            return bookDao.getdescBook(bid);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
