<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<h1>Stickers : </h1>
<ul>
    <#list stickers as sticker>
        <li style="color:${sticker.color};">Id: ${sticker.id} | Color: ${sticker.color} | Description: ${sticker.description}</li>
        <#if logged??>
          <a href="/stickers/${sticker.id}">[Edit]</a>
          <a href="/stickers/${sticker.id}/delete">[Delete]</a>
        </#if>
    </#list>
</ul>

<#if logged??>

  <h1>Create new sticker :</h1>
  <form action="/stickers" method="post">
    <input type="color" name="color" required>
    <input type="text" id="description" name="description" placeholder="Type a description..." required>
    <input type="submit" value="Submit">
  </form>

</#if>

<a href="/">< Home</a>

</body>

</html>
