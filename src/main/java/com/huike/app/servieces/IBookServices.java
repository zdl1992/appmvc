package com.huike.app.servieces;

import com.huike.app.bean.Book;
import com.huike.app.bean.Caterory;
import com.huike.tools.commons.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zero on 2017/7/24.
 */
public interface IBookServices {
    List<Book> listbookbycategory(Caterory caterory,PageBean<Book> pd);

    int countbookByCategory(Caterory caterory);

    Book getdescBook(String bid);
}
