package com.koreakdy.domabam.pages.user;

import com.koreakdy.domabam.pages.dao.UserDAO;
import com.koreakdy.domabam.pages.user.model.LoginResult;
import com.koreakdy.domabam.pages.user.model.UserEntity;
import com.koreakdy.domabam.pages.util.Utils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int err = Utils.getParameterInt(req, "err");
        if (err > 0) {
            req.setAttribute("err", "가입되지 않은 회원님 입니다.");
        }
        Utils.displayView("로그인", "user/login", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");

        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        entity.setUpw(upw);

        LoginResult lr = UserDAO.login(entity);
        String err = null;

        switch (lr.getResult()) {
            case 1://로그인 성공
                HttpSession hs = req.getSession();
                hs.setAttribute("loginUser", lr.getLoginUser());
                res.sendRedirect("/page/main");
                return;
            case 0://로그인 실패
                err = "로그인 실패";
                break;
        }
        req.setAttribute("loginerrmsg", err);
        doGet(req, res);
    }
}
