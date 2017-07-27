package com.huike.app.dao;

import com.huike.app.bean.Book;
import com.huike.app.bean.Caterory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zero on 2017/7/24.
 */
public interface IBookDao {
    List<Book> listbookByCategroy(@Param("caterory") Caterory caterory,@Param("start")
    int start,@Param("sizes")int sizes);

    int countCategory(@Param("caterory") Caterory caterory);

    Book getdescBook(@Param("bid") String bid);
}
