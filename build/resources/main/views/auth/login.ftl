<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">


<#if success??>

    <h1>${success}</h1>
    <form action="/login" method="post">
        <input type="hidden" name="logout" value="out" hiddent>
        <input type="submit" value="Logout">
    </form>

<#else>

    <#if error??>

        <h1 style="color:red">${error}</h1>

    </#if>

    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="submit" value="Login">
    </form>

</#if>

<a href="/">< Home</a>

</body>

</html>
