<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/findId.css?=ver4">
<div class="id">
    <div class="center">
        <div>
            <div>ID : ${requestScope.id} 입니다.</div>
            <div>
                <span class="save"><input type="submit" value="비밀번호 찾기"></span>
            </div>
        </div>
    </div>
</div>