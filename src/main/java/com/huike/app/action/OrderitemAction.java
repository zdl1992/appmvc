package com.huike.app.action;

import com.huike.app.bean.OrderBean;
import com.huike.app.bean.OrderItemBean;
import com.huike.app.servieces.IOrderServices;
import com.huike.app.utils.Page;
import com.huike.tools.commons.PageBean;
import com.huike.tools.commons.PropKit;
import com.huike.tools.commons.StrKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by Zero on 2017/7/29.
 */
@Controller
@Scope("prototype")
@RequestMapping("/orderitemAction")
public class OrderitemAction {

    @Autowired
    private IOrderServices services;

    @RequestMapping("/getListOrderItem")
    public String getListOrderItem(HttpServletRequest request){
        PageBean<OrderBean> pd=new PageBean<OrderBean>();
        pd.setPageNumber(Page.getPageNumber(request,"pageNumber"));
        pd.setUrl(Page.getUrl(request,"pageNumber"));
        pd.setPageSize(PropKit.use("pageSize.properties").getInt("Orderitem_page_size"));
        pd.setTotalRecords(services.countOrderItem("11EDBA1AA83E4F8D95EE0B42196770C0"));
        pd.setList(services.getListOrder("11EDBA1AA83E4F8D95EE0B42196770C0",pd));
        request.setAttribute("pd",pd);
        return "forward:/jsps/order/list.jsp";
    }

    @RequestMapping("/addOrderBook")
    public String addOrderBook(@ModelAttribute("orderBean") OrderBean orderBean,HttpServletRequest request){
        orderBean.setUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        services.addOrderBooks(orderBean);
        return "forward:/jsps/order/ordersucc.jsp";
    }

}
