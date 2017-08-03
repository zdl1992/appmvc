package com.huike.app.utils;

import com.huike.tools.commons.StrKit;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zero on 2017/7/31.
 */
public  class Page {

    /**
     * ���������ж�̬��ȡǰ̨���ݹ�����url
     * ÿ��������url�п��ܲ�ͬ
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
     * ���������л�ȡǰ̨���ݵĵ�ǰҳ��ҳ��
     * @param request
     * @return
     */
    public static int getPageNumber(HttpServletRequest request,String pageNumber){
        try {
            //��ȡ�������е�pageNumber
            String pageNumberStr =  request.getParameter(pageNumber);
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
}
