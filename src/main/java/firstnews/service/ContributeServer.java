package firstnews.service;


import firstnews.controller.ResponseModel;
import firstnews.dao.ContributeDAO;
import firstnews.domain.Contribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributeServer {


    @Autowired
    private ContributeDAO contributeDAO;

    public final ResponseModel<List<Contribute>> getByPass(Integer n) {
        List<Contribute> list = contributeDAO.getByPass(n);
        return ResponseModel.SUCCESS(list);
    }
}
