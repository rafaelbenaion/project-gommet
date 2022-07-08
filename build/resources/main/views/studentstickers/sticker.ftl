<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">

<h1>Edit sticker :</h1>
<form action="/stickers/${sticker.id}/edit" method="post">
  <input value="${sticker.id}" type="text" name="id" hidden required>
  <input value="${sticker.color}" type="color" name="color" required>
  <input value="${sticker.description}" type="text" id="description" name="description" placeholder="Type a description..." required>
  <input type="submit" value="Update">
</form>

<a href="/stickers">< Cancel</a>

</body>

</html>
