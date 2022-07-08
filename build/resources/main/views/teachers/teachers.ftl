<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<h1>Teachers : </h1>
<ul>
    <#list teachers as teacher>
        <li>Id: ${teacher.id} | Name: ${teacher.firstName} ${teacher.lastName} | Username: ${teacher.username} </li>
    </#list>
</ul>

<#if logged??>
    <h1>Register new teacher :</h1>
    <form action="/teachers" method="post">
    <input placeholder="first name" type="text" name="firstName" required>
    <input placeholder="Last name" type="text" name="lastName" required>
    <input placeholder="Username" type="text" name="username" required>
    <input placeholder="Password" type="password" name="password" required>
    <input type="submit" value="Save">
    </form>
</#if>

<a href="/">< Home</a>

</body>

</html>
