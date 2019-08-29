package cn.dave.controller;

import cn.dave.domain.Items;
import cn.dave.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: ssm2
 * @description:
 * @author: dave
 * @create: 2019-07-26 22:03
 **/

@Controller
@RequestMapping("/Items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/findDetail")
    public String findDetail(Model model){
        Items items = itemsService.findById(1);
        System.out.println(items);
        model.addAttribute("item",items);
        return "itemDetail";
    }
}
