<html>
<head>
    <title>Easyway - простой способ помочь людям.</title>

    <script type="text/javascript" src="//vk.com/js/api/openapi.js?110"></script>
    <script type="text/javascript">
    VK.init({apiId: 4276111, onlyWidgets: true});
    </script>

</head>
<body>
    <g:render template="/templates/site/steps" model="[step: 1]"/>

    <div class="b-index-items">
        <div>
            <div class="b-itembig">
                <div class="b-image">
                    <ha:image imageId="${acceptor.image}" width="537" height="359"/>
                    <h2>Расскажите друзьям о добром деле:</h2>
                    <div class="b-likes">
                        <div id="vk_like"></div>
                        <script type="text/javascript">
                        VK.Widgets.Like("vk_like", {type: "mini", verb: 1, height: 20});
                        </script>
                    </div>
                </div>
                <div class="b-info">
                    <h1>${acceptor.name}</h1>
                    <div class="b-text">
                        <h3>Причина:</h3>${acceptor.annotation}
                    </div>
                    <div class="b-text">
                        <h3>Необходимые средства:</h3>${acceptor.wherewithalText}. Необходимо собрать ${acceptor.wherewithal} рублей.
                    </div>
                    <div class="b-text">
                        <h3>Помогли уже:</h3>
                        <span>${totalViews} <span>раз(а) на сумму</span> ${acceptor.collectedFunds} руб.</span>
                    </div>
                    <a href="${createLink(controller: 'advertisement', action: 'show', params: [url: acceptor.url])}" class="b-button">Помочь</a>
                </div>
            </div>
            <div class="b-history">
                <h1 class="b-headline">История</h1>
                <div class="b-text">
                    ${raw(acceptor.content)}
                </div>
            </div>
            <div class="b-more">
                <h1 class="b-headline">Тем кто хочет сделать немного больше.</h1>
                <div class="b-text">
                    ${raw(acceptor.notes)}
                </div>
                <h2 class="b-headline">Рассказать историю:</h2>
                <div class="b-likes"></div>
            </div>
            <div class="b-trigger">
                <h1>Совершите доброе дело с Easyway</h1>
                <a href="${createLink(controller: 'advertisement', action: 'show', params: [url: acceptor.url])}" class="b-button">Помочь</a>
            </div>
        </div>

        <div>
            <h1>Другие акции</h1>
            <g:each in="${otherAcceptors}">
                <g:render template="/templates/site/acceptorMini" model="[acceptor: it]" />
            </g:each>
        </div>
    </div>
</body>
</html>