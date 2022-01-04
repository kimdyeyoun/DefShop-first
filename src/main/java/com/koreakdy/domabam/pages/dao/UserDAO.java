package com.koreakdy.domabam.pages.dao;

import com.koreakdy.domabam.pages.user.model.LoginResult;
import com.koreakdy.domabam.pages.user.model.UserEntity;
import com.koreakdy.domabam.pages.util.DbUtils;
import com.koreakdy.domabam.pages.util.Utils;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static int join(UserEntity entity){
        Connection con = null;
        PreparedStatement ps = null;
        String sql =  "INSERT INTO def_user(nm, phone, uid, upw, email, nickname, gender) VALUES(?, ?, ?, ?, ?, ?, ?) ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getNm());
            ps.setString(2, entity.getPhone());
            ps.setString(3, entity.getUid());
            ps.setString(4, entity.getUpw());
            ps.setString(5, entity.getEmail());
            ps.setString(6, entity.getNickname());
            ps.setInt(7, entity.getGender());
            return ps.executeUpdate();//회원가입 성공
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con, ps);
        }
        return 0;//회원가입 실패
    }

    public static LoginResult login(UserEntity entity) {
        int result = 0;
        UserEntity loginUser = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT upw, nm, email, nickname, gender FROM def_user WHERE uid = ?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getUid());
            rs = ps.executeQuery();
            if (rs.next()) {
                String dbPw = rs.getString("upw");
                 if(BCrypt.checkpw(entity.getUpw(), dbPw)){
                     System.out.println(dbPw);
                    result = 1;
                    loginUser = new UserEntity();
                    loginUser.setIuser(rs.getInt("iuser"));
                    loginUser.setUpw(dbPw);
                    loginUser.setUid(entity.getUid());
                    loginUser.setNm(rs.getString("nm"));
                    loginUser.setEmail(rs.getString("email"));
                    loginUser.setNickname(rs.getString("nickname"));
                    loginUser.setGender(rs.getInt("gender"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return new LoginResult(result, loginUser);//0 실패 1 성공 3 비밀번호실패 2 아이디 실패
    }

    public static UserEntity findId(UserEntity entity){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT uid FROM def_user WHERE phone = ? AND nm = ? ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getPhone());
            ps.setString(2, entity.getNm());
            rs = ps.executeQuery();

            if (rs.next()){
                UserEntity vo = new UserEntity();
                vo.setUid(rs.getString("uid"));
                return vo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return null;
    }

    public static UserEntity findUpw(UserEntity entity){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT iuser FROM def_user WHERE phone = ? AND uid = ?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getPhone());
            ps.setString(2, entity.getUid());
            rs = ps.executeQuery();

            if (rs.next()){
                UserEntity vo = new UserEntity();
                vo.setIuser(rs.getInt("iuser"));
                return vo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return null;
    }

    public static int findUpwUpd(UserEntity entity){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE def_user SET upw = ? WHERE iuser = ?";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, entity.getUpw());
            ps.setInt(2, entity.getIuser());
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }
}
