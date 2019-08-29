package cn.dave.controller;

import cn.dave.domain.Account;
import cn.dave.service.imp.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: ssm
 * @description:
 * @author: dave
 * @create: 2019-07-23 14:38
 **/

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("web层执行了findAll......");
        List<Account> accountList = accountService.findAll();
        System.out.println(accountList);
        model.addAttribute("accountList",accountList);
        return "list";
    }

    @RequestMapping("/add")
    public void add(Account account, HttpServletRequest request , HttpServletResponse response) throws IOException {
        System.out.println("web层执行了add......");
        accountService.addAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
    }
}
