    <html>
<head>
    <title>Easyway - простой способ помочь людям.</title>
</head>
<body>
    <div class="b-index-slide">
        <asset:image src="site/index-people.gif" alt=""/>
        <div class="b-right">
            <h1><span class="red">Easyway</span> - это простой способ<br/><span class="bold">помочь людям</span></h1>
            <div class="b-text">Это <strong>абсолютно бесплатный сервис</strong> для пользователей, только Ваше участие и неравнодушие поможет сделать мир чуточку светлее.<br/><br/>Просто посмотри видеоролик и средства рекламодателя перечислятся на  счет акции. </div>
        </div>
    </div>

    <g:render template="/templates/site/steps" model="[step: 1]"/>

    <div class="b-index-items">
        <div>
            <g:each in="${acceptors}">
                <g:render template="/templates/site/acceptorMini" model="[acceptor:it]"/>
            </g:each>
        </div>
    </div>

    <div class="b-index-info">
        <div class="b-lines"></div>
        <div class="b-block one">
            <i></i>
            <h1>Что нужно сделать</h1>
            <div class="b-text"><p>Посмотри до конца рекламный видеоролик.</p></div>
        </div>
        <div class="b-block two">
            <i></i>
            <h1>Как ты помогаешь</h1>
            <div class="b-text"><p>За просмотр рекламы отчисляются <br/>деньги в счет акции, которую ты выбрал. <br/>1 просмотр - 10 руб.</p></div>
        </div>
        <div class="b-block three">
            <i></i>
            <h1>Спасибо за доброе дело</h1>
            <div class="b-text"><p>Один незначительный шаг ведет к великим <br/>свершениям. Спасибо, что остались <br/>неравнодушными к проблеме.</p></div>
        </div>
        <div class="b-block four">
            <i></i>
            <h1>Раскажи друзьям</h1>
            <div class="b-text"><p>Хочешь помочь еще больше  - расскажи <br/>друзьям и мы наберем необходимые <br/>средства для помощи нуждающимся.</p></div>
        </div>
    </div>

    <g:render template="/templates/site/socials" />
</body>
</html>