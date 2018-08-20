package firstnews.controller;



import firstnews.domain.ContributeDO;
import firstnews.domain.query.ContributeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/contribute")
*/
public class ContributeController1 {
/*
    @Autowired
    private ContributeDAO contributeDAO;7

    @GetMapping("")
    public ResponseModel<List<ContributeDO>> list(ContributeQuery query) {
        List<ContributeDO> list = contributeDAO.findByQuery(query);
        return ResponseModel.SUCCESS(list);
    }


    @PostMapping("")
    public ResponseModel<Integer> add(@RequestBody ContributeDO contributeDO) {
        contributeDAO.insert(contributeDO);
        return ResponseModel.SUCCESS(contributeDO.getId());
    }

    @DeleteMapping("{id}")
    public ResponseModel<Boolean> remove(@PathVariable("id") Integer id) {
        return ResponseModel.SUCCESS(contributeDAO.remove(id) > 0);
    }

    @PutMapping("{id}")
    public ResponseModel<Boolean> put(ContributeDO contributeDO) {
        return ResponseModel.SUCCESS(contributeDAO.update(contributeDO) > 0);
    }

    @GetMapping("firstcontributegetbypass")
    public ResponseModel<List<ContributeDO>> getbypass(int n) {
       List<ContributeDO> list = contributeDAO.getByPass(n);
        return ResponseModel.SUCCESS(list);

    }
    */
}
