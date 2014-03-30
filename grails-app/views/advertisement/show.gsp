<html>
<head>
    <title>Easyway - простой способ помочь людям.</title>
</head>

<body>
    <g:render template="/templates/site/steps" model="[step: 3]"/>

    <div class="b-index-items">
        <div>
            <div class="b-videoblock">
                <ha:image imageId="${acceptor.image}" width="260" height="203"/>
                <div class="b-info">
                    <h1><span class="bold">Досмотрите</span> рекламный видеоролик <span class="bold">до конца</span> и <br/><span>${acceptor.name}</span> получит Вашу помощь.</h1>
                    <div class="b-text"><strong>Помогли уже:</strong><br/>
                        <span>${totalViews} <span>раз(а) на сумму</span> ${acceptor.collectedFunds} руб.</span>
                    </div>
                    <div class="b-price"><span class="b-icon"></span>1 просмотр - 10 руб.</div>
                </div>
                <div class="b-video">
                    <iframe id="ytplayer" type="text/html" width="1020" height="580"
                    src="https://www.youtube.com/embed/7mWrp_0cxCU?enablejsapi=1"
                    frameborder="0" allowfullscreen />
                </div>
            </div>
        </div>
    </div>
</body>
</html>