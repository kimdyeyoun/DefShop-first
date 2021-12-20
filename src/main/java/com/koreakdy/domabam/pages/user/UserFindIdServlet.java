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
        int err2 = Utils.getParameterInt(req, "err2");
        if (err2 > 0) {
            req.setAttribute("err2", "아이디 또는 번호를 다시 입력하시오.");
        }
        Utils.displayView("아이디 찾기", "user/findId", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nm = req.getParameter("nm");
        String phone = req.getParameter("phone");

        UserEntity entity = new UserEntity();
        entity.setNm(nm);
        entity.setPhone(phone);

        UserEntity chentity = UserDAO.findId(entity);

        if(chentity==null){
            res.sendRedirect("/user/login?err=1");
            return;
        }

        String chuid = Utils.subString(chentity.getUid());

        req.setAttribute("id", chuid);
        doGet(req, res);
    }
}
