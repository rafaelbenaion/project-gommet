<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<h1>Info : </h1>
<ul>
        <p>Id: ${student.id} | Name: ${student.firstName} ${student.lastName} | Birthday: ${student.birthDate} | Classroom: ${student.classroom}</p>

        <#list student.stickerList as sticker>
            <li style="color:${sticker.sticker.color}">Sticker: ${sticker.sticker.color} | Description: ${sticker.sticker.description} | Reason: ${sticker.reason} | Date: ${sticker.date}  | Responsable: ${sticker.teacher.firstName} ${sticker.teacher.lastName} </li>
            <#if logged??>
                <a href="/studentstickers/${sticker.id}/delete/${student.id}">Remove</a>
            </#if>
        </#list>

        <#if logged??>

            <h1>Give new sticker : </h1>
                <form action="/students/${student.id}" method="post">
                    <select name='color'>
                        <option value='' selected hidden disabled>-- Select Sticker --</option>
                        <#list stickers as sticker>
                            <option value='${sticker.id}' style='color:${sticker.color};background-color:${sticker.color}'>Sticker ${sticker.id}</option>
                        </#list>
                    </select>
                    <input type="text" name="reason" placeholder="The reason why..." required>
                    <input type="text" name="idTeacher" value="${logged}" hidden>
                    <input type="submit" value="Save">
                </form>

        </#if>
</ul>

<a href="/students">< All students</a>

</body>
 
</html>
