package com.huike.app.action;

import com.huike.app.bean.CartItem;
import com.huike.app.servieces.ICartItemServices;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Zero on 2017/7/27.
 */
@Controller
@Scope("prototype")
@RequestMapping("/cartItemAction")
public class CartItemAction {
    @Autowired
    private ICartItemServices services;

    @RequestMapping("/getlistCaritem")
    public String getlistCaritem(HttpServletRequest request){
        List<CartItem> cartItems= services.queryCartItemsByUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        request.setAttribute("cartItems",cartItems);
        return "forward:/jsps/cart/list.jsp";
    }

    @RequestMapping("/addCartItem")
    public String addCartItem(@ModelAttribute CartItem cartItem,HttpServletRequest request){
        cartItem.setUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        services.AddICartItem(cartItem);
        List<CartItem> cartItems= services.queryCartItemsByUid(cartItem.getUid());
        request.setAttribute("cartItems",cartItems);
        return "forward:/jsps/cart/list.jsp";
    }
    @RequestMapping("/delectCartItem")
    public String delectCartItem(@RequestParam("cartItemId") String cartItemId, HttpServletRequest request){
        System.out.println("=======cartItemId======" +cartItemId);
        services.delectCartItem(cartItemId);
        List<CartItem> cartItems= services.queryCartItemsByUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        request.setAttribute("cartItems",cartItems);
        return "forward:/jsps/cart/list.jsp";
    }
    @RequestMapping("/deletelistCarItem")
    public  String deletelistCarItem(@RequestParam("cartItemIds") String cartItemIds,HttpServletRequest request){
        String [] i=cartItemIds.split(",");
        services.delectlistCarItem(i);
        List<CartItem> cartItems= services.queryCartItemsByUid("11EDBA1AA83E4F8D95EE0B42196770C0");
        request.setAttribute("cartItems",cartItems);
        return "forward:/jsps/cart/list.jsp";
    }


    @RequestMapping("/accountsCartByIds")
    public String accountsCartByIds(@RequestParam("cartItemIds") String cartItemIds,HttpServletRequest request){
        String [] i=cartItemIds.split(",");
        List<CartItem> cartItems=services.querylistCarItem(i);
        request.setAttribute("cartItems",cartItems);
        return "forward:/jsps/cart/showitem.jsp";
    }
}
