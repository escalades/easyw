<div class="b-steps">
    <div class="b-step one ${step == 1 ? 'active' : ''}">
        <span class="b-treangle"></span>
        <g:if test="${step > 1}">
            <span class="b-number done"></span>
        </g:if>
        <g:else>
            <span class="b-number">1</span>
        </g:else>
        <h2>Выбери акцию</h2>
    </div>
    <div class="b-step two ${step == 2 ? 'active' : ''}">
        <span class="b-treangle"></span>
        <g:if test="${step > 2}">
            <span class="b-number done"></span>
        </g:if>
        <g:else>
            <span class="b-number">2</span>
        </g:else>
        <h2>
            <ew:isAuthorized>
                ${it ?: raw("Вы успешно <br/>авторизованы")}
            </ew:isAuthorized>
            <ew:notAuthorized>
                Авторизуйся <br/>через соцсети
            </ew:notAuthorized>
        </h2>
    </div>
    <div class="b-step three ${step == 3 ? 'active' : ''}">
        <span class="b-treangle"></span>
        <g:if test="${step > 3}">
            <span class="b-number done"></span>
        </g:if>
        <g:else>
            <span class="b-number">3</span>
        </g:else>
        <h2>Посмотри видео</h2>
    </div>
    <div class="b-step four ${step == 4 ? 'active' : ''}">
        <span class="b-treangle"></span>
        <g:if test="${step > 4}">
            <span class="b-number done"></span>
        </g:if>
        <g:else>
            <span class="b-number">4</span>
        </g:else>
        <h2>Расскажи друзьям</h2>
    </div>
</div>