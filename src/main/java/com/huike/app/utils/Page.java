package com.huike.app.utils;

import com.huike.tools.commons.StrKit;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zero on 2017/7/31.
 */
public  class Page {

    /**
     * 从请求流中动态获取前台传递过来的url
     * 每个动作的url有可能不同
     * /appmvc/bookAction/listBooksByCategory?cid=xxxxx
     * /appmvc/bookAction/listBooksBybname?cname=yyyyy
     * @param request
     * @return
     */
    public static String getUrl(HttpServletRequest request,String pageNumber){
        try {
            //  /appmvc/bookAction/listBooksByCategory
            // uri=/appmvc/bookAction/listBooksByCategory
            // queryString=cid=xxx
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            System.out.println("=========="+queryString);
            if (queryString == null){
                return uri+"?1=1";
            }else{
                // /appmvc/bookAction/listBooksByCategory?pageNumber=2
                if (queryString.indexOf(pageNumber+"=") == 0){
                    return uri;
                }
                // /appmvc/bookAction/listBooksByBname?bname=java&pageNumber=2
                if (queryString.contains("&"+pageNumber+"=")){
                    return uri + "?" + queryString.substring(0,queryString.lastIndexOf("&"+pageNumber+"="));
                }
                // /appmvc/bookAction/listBooksByBname?bname=java
                return uri + "?" + queryString;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * 从请求流中获取前台传递的当前页的页码
     * @param request
     * @return
     */
    public static int getPageNumber(HttpServletRequest request,String pageNumber){
        try {
            //获取请求流中的pageNumber
            String pageNumberStr =  request.getParameter(pageNumber);
            if (StrKit.notBlank(pageNumberStr)){
                //如果请求流中pageNumber不为空，则使用前台传递过来的pageNumber
                return Integer.parseInt(pageNumberStr);
            }else{
                //如果前台没有传递pageNumber或者为空时，自动取第一页
                return 1;
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
