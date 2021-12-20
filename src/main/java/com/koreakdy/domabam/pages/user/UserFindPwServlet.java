package com.koreakdy.domabam.pages.user;

import com.koreakdy.domabam.pages.dao.UserDAO;
import com.koreakdy.domabam.pages.user.model.UserEntity;
import com.koreakdy.domabam.pages.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/findPw")
public class UserFindPwServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String phone = req.getParameter("phone");

        UserEntity entity = new UserEntity();
        entity.setUid(uid);
        entity.setPhone(phone);


        UserEntity chentity = UserDAO.findUpw(entity);

        if (chentity == null){
            res.sendRedirect("/user/findId?err2=1");
            return;
        }

        int chIuser = UserDAO.findUpw(entity).getIuser();
        req.setAttribute("iuser", chIuser);
        Utils.displayView("비밀번호 찾기", "user/findPw", req, res);
    }

}
