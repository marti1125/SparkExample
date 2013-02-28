<html>
    <head>
        <title>Fruit Picker</title>
    </head>
    <body>
        <h1>Fruit Picker</h1>
        <form action="/favority_fruit" method="post">
            <p>What is your favority fruit?</p>
            <#list fruits as fruit>
                <p>
                    <input type="radio" name="fruit" value="${fruit}">${fruit}</input>
                </p>
            </#list>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>