package com.huike.app.action;

import com.huike.app.bean.Caterory;
import com.huike.app.servieces.ICateroryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zero on 2017/7/22.
 */
@Controller
@Scope("prototype")
@RequestMapping("/cateroryAction")
public class CateroryAction {
    @Autowired
    private ICateroryServices services;
    @RequestMapping("/cateroryjson")
    @ResponseBody
    public List<Caterory> cateroryjson(){
        List<Caterory> newlist=new ArrayList<Caterory>();
         List<Caterory> caterory =services.getlistNode();
        for (Caterory caterory1 : caterory){
            if (caterory1.getPid()!=null){
                caterory1.setUrl("/BookAction/listbooksByCaterory.do?cid="+ caterory1.getCid());
                caterory1.setTarget("body");
            }
            newlist.add(caterory1);
        }

        return newlist;
    }
}
