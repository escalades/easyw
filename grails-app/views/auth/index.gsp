<html>
<head>
    <title>Easyway - простой способ помочь людям.</title>
</head>
<body>
    <g:render template="/templates/site/steps" model="[step: 2]"/>

    <div class="b-index-items">
        <div>
            <div class="b-auth">
                <h1>Пожалуйста, авторизуйтесь через:</h1>
                <script src="//ulogin.ru/js/ulogin.js"></script>

                <div class="b-socials" id="uLogin" data-ulogin="display=buttons;
				redirect_uri=${createLink(controller: 'auth', action: 'check', params: [acceptorId: acceptorId], absolute:true)};
				receiver=${createLink(controller: 'auth', action: 'receiver', absolute: true)}">
                    <a class="b-social vk" data-uloginbutton = "vkontakte"></a>
                    <a class="b-social fb" data-uloginbutton = "facebook"></a>
                    <a class="b-social ok" data-uloginbutton="odnoklassniki"></a>
                    <a class="b-social tw" data-uloginbutton="twitter"></a>
                    <a class="b-social gp" data-uloginbutton="googleplus"></a>
                </div>
                <div class="b-text">Авторизация через учётную запись одной из социальных сетей на сайте EasyWay позволит нам идентифицировать Вас как уникального пользователя. <br/> *Мы не храним Ваши личные данные.<span class="b-icon"></span></div>
            </div>
        </div>
    </div>
</body></html>