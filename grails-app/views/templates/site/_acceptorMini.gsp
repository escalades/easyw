<div class="b-item">
    <ha:image imageId="${acceptor.image}" width="260" height="203"/>
    <h3>${acceptor.name}</h3>
    <div class="b-text"><span>Причина:</span><br/>${acceptor.annotation}</div>
    <a href="${createLink(action: 'show', params: [url: acceptor.url])}" class="b-about"><i></i>Узнать больше</a>
    <div class="b-line"></div>
    <a href="${createLink(controller: 'advertisement', action: 'show', params: [url: acceptor.url])}" class="b-button">Помочь</a>
</div>