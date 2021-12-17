<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/findId.css?=ver4">
<div class="id">
    <div class="center">
        <div>
            <div>ID : ${requestScope.id} 입니다.</div>
            <div>
                <span class="forgot_pw"><input type="submit" value="비밀번호 찾기"></span>
            </div>
        </div>
    </div>
</div>

<div id="whereIds" class="modal">
    <div id="noneAndblock">
        <div> <input type="text" name="nm" placeholder="이름" required></div>
        <div> <input type="text" name="phone" placeholder="번호" required></div>
        <div>
            <span><input type="submit" value="확인"></span>
            <span><input type="button" value="닫기"></span>
        </div>
    </div>
</div>

<script src="/res/js/login.js?ver=1"></script>