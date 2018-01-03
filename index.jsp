<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<shiro:guest>
    欢迎游客访问，<a href="${pageContext.request.contextPath}/login.jsp">点击登录</a><br/>
</shiro:guest>
<shiro:user>
    欢迎[<shiro:principal/>]登录，<a href="${pageContext.request.contextPath}/logout">点击退出</a><br/>
</shiro:user>

<shiro:authenticated>
    用户[<shiro:principal/>]已身份验证通过<br/>
</shiro:authenticated>

<shiro:notAuthenticated>
    未身份验证（包括记住我）<br/>
</shiro:notAuthenticated>

<shiro:hasRole name="admin">
    用户[<shiro:principal/>]拥有角色admin<br/>
</shiro:hasRole>

<shiro:hasAnyRoles name="admin,user">
    用户[<shiro:principal/>]拥有角色admin或user<br/>
</shiro:hasAnyRoles>

<shiro:lacksRole name="abc">
    用户[<shiro:principal/>]没有角色abc<br/>
</shiro:lacksRole>

<shiro:hasPermission name="user:create">
    用户[<shiro:principal/>]拥有权限user:create<br/>
</shiro:hasPermission>
<shiro:lacksPermission name="org:create">
    用户[<shiro:principal/>]没有权限org:create<br/>
</shiro:lacksPermission>

cookieName <input type="text" id="cookieName" /> <br>
cookieValue <input type="text" id="cookieValue" /> <br>

<button onclick="showAllCookie()">show all cookie</button>
<button onclick="setCookie2()">set cookie</button>
<button onclick="removeCookie()">clear cookie</button>
<button onclick="getCookie2()">getCookie cookie</button>

<script language="JavaScript">
    var username=document.cookie.split(";")[0].split("=")[1];

    //JS操作cookies方法!

    //写cookies

    function setCookie(name,value)
    {
        var Days = 30;
        var exp = new Date();
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toUTCString();
    }

    //读取cookies
    function getCookie(name)
    {
        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");

        if(arr=document.cookie.match(reg))

            return unescape(arr[2]);
        else
            return null;
    }

    //删除cookies
    function delCookie(name)
    {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval=getCookie(name);
        if(cval!=null)
            document.cookie= name + "="+cval+";expires="+exp.toUTCString();
    }
    //使用示例

    //setCookie("name","hayden");
    //alert(getCookie("name"));

    //如果需要设定自定义过期时间
    //那么把上面的setCookie　函数换成下面两个函数就ok;


    //程序代码
    function setCookieWithTime(name,value,time)
    {
        var strsec = getsec(time);
        var exp = new Date();
        exp.setTime(exp.getTime() + strsec*1);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toUTCString();
    }
    function getsec(str)
    {
        alert(str);
        var str1=str.substring(1,str.length)*1;
        var str2=str.substring(0,1);
        if (str2=="s")
        {
            return str1*1000;
        }
        else if (str2=="h")
        {
            return str1*60*60*1000;
        }
        else if (str2=="d")
        {
            return str1*24*60*60*1000;
        }
    }
    //这是有设定过期时间的使用示例：
    //s20是代表20秒
    //h是指小时，如12小时则是：h12
    //d是天数，30天则：d30

    // setCookie("name","hayden","s20");

</script>
<script language="JavaScript">

    function showAllCookie() {
        alert(document.cookie);
    }
    function setCookie2() {
        var cookieName = document.getElementById("cookieName").value;
        var cookieValue = document.getElementById("cookieValue").value;
        setCookie(cookieName, cookieValue);
//        document.cookie = cookieName+"="+cookieValue;//+ ";expires=" + exp.toUTCString(); ;
    }

    //读取cookies
    function removeCookie() {
        var cookieName = document.getElementById("cookieName").value;
        delCookie(cookieName);
        alert(getCookie(cookieName));
    }
    //    function removeCookie(name)
    //    {
    //        var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    //        var va;
    //        var exp = new Date();
    //        alert(exp + "  " + exp.toUTCString());
    //        if(arr=document.cookie.match(reg))
    //            va =  unescape(arr[2]);
    //        alert(va);
    //        document.cookie = name+"=bbbbbbbb" + ";expires=" + exp.toUTCString(); ;
    //    }

    //读取cookies
    function getCookie2() {
        var cookieName = document.getElementById("cookieName").value;
        alert(getCookie(cookieName));
    }

    function getCookie3()
    {
        var cookieName = document.getElementById("cookieName").value;
        var arr,reg=new RegExp("(^| )"+cookieName+"=([^;]*)(;|$)");
        var va;
        if(arr=document.cookie.match(reg))
            va =  unescape(arr[2]);
        alert(va);
    }

</script>

</body>
</html>
