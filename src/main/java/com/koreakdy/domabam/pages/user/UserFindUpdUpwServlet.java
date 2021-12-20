package com.koreakdy.domabam.pages.user;

import com.koreakdy.domabam.pages.dao.UserDAO;
import com.koreakdy.domabam.pages.user.model.UserEntity;
import com.koreakdy.domabam.pages.util.Utils;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updUpw")
public class UserFindUpdUpwServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Utils.displayView("비밀번호 찾기", "user/findPw", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String upw = req.getParameter("changeUpw");
        int iuser = Utils.getParameterInt(req, "iuser");
        UserEntity entity = new UserEntity();
        upw = BCrypt.hashpw(upw, BCrypt.gensalt());

        entity.setUpw(upw);
        entity.setIuser(iuser);

        int result = UserDAO.findUpwUpd(entity);

        switch (result){
            case 1:
                res.sendRedirect("/user/login");
                break;
            default:
                doGet(req, res);
                break;
        }
    }
}
