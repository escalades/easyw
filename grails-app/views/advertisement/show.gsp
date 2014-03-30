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
                        <span>${amountViewers} <span>раз(а) на сумму</span> ${acceptor.collectedFunds} руб.</span>
                    </div>
                    <div class="b-price"><span class="b-icon"></span>1 просмотр - 10 руб.</div>
                </div>
                <div class="b-video">
                    <div id="player" data-url="${advertisement.videoUrl}" data-redirect="${createLink(controller: 'advertisement', action: 'success', params: [url: acceptor.url])}"></div>
                </div>
            </div>
        </div>
    </div>
<script>
    var tag = document.createElement('script');

    tag.src = "https://www.youtube.com/iframe_api";
    var firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    var player;
    var videoUrl = $("#player").data("url");
    var redirectUrl = $("#player").data("redirect");
    function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
            height: '580',
            width: '1020',
            videoId: videoUrl,
            playerVars: {
                controls: 0,
                disablekb: 1
            },
            events: {
                'onStateChange': onPlayerStateChange
            }
        });
    }
    function onPlayerStateChange(event) {
        if (event.data == YT.PlayerState.ENDED) {
            location.href = redirectUrl;
        }
    }
</script>
</body>
</html>