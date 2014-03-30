<html>
<head>
    <title>Easyway - простой способ помочь людям.</title>
</head>
<body>
<g:render template="/templates/site/steps" model="[step: 4]"/>

    <div class="b-index-items">
        <div>
            <div class="b-itembig">
                <div class="b-image">
                    <ha:image imageId="${acceptor.image}" width="537" height="359"/>
                    <h2>Расскажите друзьям о добром деле:</h2>
                    <div class="b-likes"></div>
                </div>
                <div class="b-info">
                    <h1>Спасибо огромное! <span>Деньги переведены на счет акции “${acceptor.name}”.</span></h1>
                    <div class="b-text center">
                        <span><span>Вы </span>${totalViews} <span>человек, который помог.</span><br/><span>Собранные средства -</span> ${acceptor.collectedFunds} руб.</span>
                    </div>
                    <h1 class="second"><span>Вы можете помочь еще</span> ${availableAdsAmount} раз(а)</h1>
                    <div class="b-price"><span class="b-icon"></span>Количество просмотров ограничено по количеству <br/> компаний-спонсоров и рекламных видеороликов.</div>

                    <!-- FANCYBOX POPUP -->
                    <a href="#inline" class="b-button more fancybox">Помочь ещё</a>
                </div>
            </div>
        </div>
        <div>
            <h1>Другие акции</h1>
            <g:each in="${otherAcceptors}" var="item">
                <div class="b-item">
                    <ha:image imageId="${item.image}" width="260" height="203"/>
                    <h3>${item.name}</h3>
                    <div class="b-text"><span>Причина:</span><br/>${item.annotation}</div>
                    <a href="${createLink(action: 'show', params: [url: item.url])}" class="b-about"><i></i>Узнать больше</a>
                    <div class="b-line"></div>
                    <a href="${createLink(controller: 'advertisement', action: 'show', params: [url: item.url])}" class="b-button">Помочь</a>
                </div>
            </g:each>
        </div>
    </div>

<div id="inline" style="display: none;">
    <div class="b-popup-bg">
        <h1>К сожалению, Вы уже просмотрели все возможные видеоролики.</h1>
        <div class="b-text">Количество просмотров ограничено по количеству  компаний-спонсоров и рекламных видеороликов. <br/><br/>Вы можете вернуться позже, когда появятся новые акции или рассказать друзям.</div>
        <div class="b-likes"></div>
    </div>
</div>
</body></html>
