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

@WebServlet("/user/findId")
public class UserFindIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Utils.displayView("아이디 찾기", "user/findId", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nm = req.getParameter("nm");
        String phone = req.getParameter("phone");

        UserEntity entity = new UserEntity();
        entity.setNm(nm);
        entity.setPhone(phone);

        String uid = Utils.subString(UserDAO.findId(entity).getUid());
        req.setAttribute("id", uid);
        doGet(req, res);
    }
}
