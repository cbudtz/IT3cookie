<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Loginside</title>
</head>
<body>
<p>
<%
    Cookie[] cookies = request.getCookies();
    int visitCount = 0;
    for (Cookie c: cookies){
        if ("visitCount".equals(c.getName())){
            visitCount= Integer.parseInt(c.getValue());
            out.print("Du har besøgt siden " + visitCount + " gange!");
        }
        response.addCookie(new Cookie("visitCount",(visitCount+1) +""));
    }

%>
</p>
<p>
    Velkommen til!
</p>
</body>
</html>
