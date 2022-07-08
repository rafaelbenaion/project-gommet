<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<h1>Students : </h1>
<ul>
    <#list students as student>
        <li>Id: ${student.id}, Name: <a href="students/${student.id}"> ${student.firstName} ${student.lastName} </a>, Birthday: ${student.birthDate}, Classroom: ${student.classroom} 
            <#if logged??>
            <a href="/students/${student.id}/edit">[Edit]</a>
            <a href="/students/${student.id}/delete">[Delete student]</a>
            </#if></li>
        
        <ul>
        <#list student.stickerList as sticker>
            <li style="color:${sticker.sticker.color}">Sticker: ${sticker.sticker.color}</li>
        </#list>
        </ul>
    </#list>
</ul>

<#if logged??>
    <h1>Register new student :</h1>
    <form action="/students" method="post">
    <input placeholder="first name" type="text" name="firstName" required>
    <input placeholder="Last name" type="text" name="lastName" required>
    <input placeholder="Birthdate" type="text" name="birthdate" required>
    <input placeholder="Classroom" type="text" name="classroom" required>
    <input type="submit" value="Save">
    </form>
</#if>


<a href="/">< Home</a>

</body>

</html>
