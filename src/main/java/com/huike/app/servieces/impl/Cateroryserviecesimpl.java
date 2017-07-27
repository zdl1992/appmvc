package com.huike.app.servieces.impl;

import com.huike.app.bean.Caterory;
import com.huike.app.dao.ICaterorydao;
import com.huike.app.servieces.ICateroryServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zero on 2017/7/22.
 */
@Service
public class Cateroryserviecesimpl implements ICateroryServices {
private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ICaterorydao iCaterorydao;
    @Override
    public List<Caterory> getlistNode() {
        try {
            return iCaterorydao.getlistNode();
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
