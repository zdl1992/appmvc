package com.huike.app.action;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.huike.app.bean.Book;
import com.huike.app.bean.Caterory;
import com.huike.app.servieces.IBookServices;
import com.huike.tools.commons.PageBean;
import com.huike.tools.commons.PropKit;
import com.huike.tools.commons.StrKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/7/22.
 */
@Controller
@Scope("prototype")
@RequestMapping("/BookAction")
public class BookAction {

    @Autowired
    private IBookServices services;

    @RequestMapping("/listbooksByCaterory")
    public String listbooksByCaterory(@ModelAttribute Caterory caterory,HttpServletRequest request){
        PageBean<Book> pd=new PageBean<Book>();
        pd.setPageNumber(this.getPageNumber(request));
        pd.setUrl(this.getUrl(request));
        pd.setPageSize(PropKit.use("pageSize.properties").getInt("book_page_size"));
        pd.setList(services.listbookbycategory(caterory,pd));
        pd.setTotalRecords(services.countbookByCategory(caterory));
        request.setAttribute("pd",pd);
        return "forward:/jsps/book/list.jsp";
    }
    /**
     * ���������ж�̬��ȡǰ̨���ݹ�����url
     * ÿ��������url�п��ܲ�ͬ
     * /appmvc/bookAction/listBooksByCategory?cid=xxxxx
     * /appmvc/bookAction/listBooksBybname?cname=yyyyy
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request){
        try {
            //  /appmvc/bookAction/listBooksByCategory
            // uri=/appmvc/bookAction/listBooksByCategory
            // queryString=cid=xxx
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            System.out.println("=========="+queryString);
            if (queryString == null){
                return uri;
            }else{
                // /appmvc/bookAction/listBooksByCategory?pageNumber=2
                if (queryString.indexOf("pageNumber=") == 0){
                    return uri;
                }
                // /appmvc/bookAction/listBooksByBname?bname=java&pageNumber=2
                if (queryString.contains("&pageNumber=")){
                    return uri + "?" + queryString.substring(0,queryString.lastIndexOf("&pageNumber="));
                }
                // /appmvc/bookAction/listBooksByBname?bname=java
                return uri + "?" + queryString;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * ���������л�ȡǰ̨���ݵĵ�ǰҳ��ҳ��
     * @param request
     * @return
     */
    private int getPageNumber(HttpServletRequest request){
        try {
            //��ȡ�������е�pageNumber
            String pageNumberStr =  request.getParameter("pageNumber");
            if (StrKit.notBlank(pageNumberStr)){
                //�����������pageNumber��Ϊ�գ���ʹ��ǰ̨���ݹ�����pageNumber
                return Integer.parseInt(pageNumberStr);
            }else{
                //���ǰ̨û�д���pageNumber����Ϊ��ʱ���Զ�ȡ��һҳ
                return 1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }




    @RequestMapping("/descBook")
    public String descBook(@RequestParam("bid")String bid ,HttpServletRequest request){
        Book book=services.getdescBook(bid);
        request.setAttribute("book",book);
        return "forward:/jsps/book/desc.jsp";
    }
}
