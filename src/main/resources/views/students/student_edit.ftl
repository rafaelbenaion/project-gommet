<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">


<h1>Edit student information :</h1>
<form action="/students/${student.id}/edit" method="post">
  <input value="${student.id}" type="text" name="id" hidden required>
  <input value="${student.firstName}" type="text" name="firstName" required>
  <input value="${student.lastName}" type="text" name="lastName" required>
  <input value="${student.birthDate}" type="text" name="birthdate" required>
  <input value="${student.classroom}" type="text" name="classroom" required>
  <input type="submit" value="Update">
</form>

<a href="/students">< Cancel</a>

</body>
 
</html>
