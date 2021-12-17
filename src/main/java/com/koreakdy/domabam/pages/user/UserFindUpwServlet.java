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

@WebServlet("/user/findUpw")
public class UserFindUpwServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Utils.displayView("비밀번호 찾기", "user/findUpw", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
