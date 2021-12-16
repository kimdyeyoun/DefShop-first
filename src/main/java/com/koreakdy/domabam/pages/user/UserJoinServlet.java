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

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Utils.displayView("회원가입", "user/join", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String nm = req.getParameter("nm");
        String phone = req.getParameter("phone");
        String uid = req.getParameter("uid");
        String upw = req.getParameter("upw");
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        int gender = Utils.getParameterInt(req, "gender");
//      비밀번호 암호화
        String hashPw = BCrypt.hashpw(upw, BCrypt.gensalt());

        UserEntity entity = new UserEntity();
        entity.setNm(Utils.replaceStr(nm));
        entity.setPhone(phone);
        entity.setUid(uid);
        entity.setUpw(hashPw);
        entity.setEmail(email);
        entity.setNickname(nickname);
        entity.setGender(gender);
        req.setAttribute("data", entity);
        UserDAO.join(entity);

        res.sendRedirect("/user/login");
    }
}
