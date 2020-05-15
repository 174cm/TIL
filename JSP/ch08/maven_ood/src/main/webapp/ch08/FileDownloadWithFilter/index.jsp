<%-- 
    Document   : index
    Created on : 2020. 5. 15, 오후 1:34:53
    Author     : MASTER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set value="C:/jsp/download" var="targetDirectory"/>

<jsp:useBean id="fileList" scope="page" class="beans.FileListBean"/>
<jsp:setProperty name="fileList" property="dirName" value="${targerDirectory}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>필터링 박성호</title>
    </head>
    <body>
        <h1>파일 내려받기 (필터링) - 박성호</h1>
        <hr/>
        원하는 파일을 선택하세요. <br/> <br/>

        <form action="download.do" method="POST">
            <c:forEach var="fileName" items="${fileList.relativeFileList}">
                <input type="radio" name="file_name" value="${fileName}"/> ${fileName} <br/>
            </c:forEach>
            <br/>
            <input type="hidden" name="AbsolutePath" value="${targerDirectory}" />
            <input type="submit" value="내려받기"/>
        </form>
    </body>
</html>
