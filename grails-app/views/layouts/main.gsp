<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <META http-equiv="Content-Type" content="text/html" charset="windows-1251">
    <title><g:layoutTitle default="Easyway - простой способ помочь людям."/></title>
    <meta name="format-detection" content="telephone=no"/>
    <meta name="MobileOptimized" content="1200"/>
    <link href='http://fonts.googleapis.com/css?family=Exo+2:400,300,300italic,400italic,600,600italic,700,700italic&subset=latin,cyrillic' rel='stylesheet' type='text/css'>

    <link rel="shortcut icon" href="${assetPath(src: 'site/favicon.ico')}" />
    <link rel="icon" href="${assetPath(src: 'site/favicon.ico')}" />

    <!--[if lt IE 9]>
		<style type="text/css">.gradient {filter: none;}</style>
    	<asset:javascript  src="site/css3-mediaqueries.js"/>
    	<asset:stylesheet href="site/ie.css" />
    <![endif]-->
    <asset:stylesheet href="style.css"/>
    <asset:javascript src="main.js"/>
    <g:layoutHead/>
</head>
<body>
<div class="b-wrapper">
    <div class="b-header">
        <a href="${createLink(controller: 'acceptor')}"><asset:image src="site/logo.png" alt="" class="b-logo"/></a>
        <a class="b-city"><i></i>Владивосток</a>
        <ul>
            <li><a ${actionName == 'finished' ? "class=active" : ''} href="${createLink(controller: 'acceptor',action: 'finished')}"><i class="first"></i>Отчёты</a></li>
            <li><a ${actionName == 'cooperation' ? "class=active" : ''} href="${createLink(controller: 'page',action: 'cooperation')}"><i class="second"></i>Сотрудничество</a></li>
            <li><a ${actionName == 'about' ? "class=active" : ''} href="${createLink(controller: 'page',action: 'about')}"><i class="third"></i>О проекте</a></li>
        </ul>
    </div>
    <g:layoutBody/>

    <div class="b-push"></div>
</div>
<div class="b-footer">
    <div>
        <a href="http://mouseindahouse.ru" target="_blank" class="b-madeby">Сделано студией House</a>
        <a href="${createLink(controller: 'page',action: 'politics')}" class="b-copyright">Политика конфиденциальности</a>
        <span class="b-mail"><i></i>info@easyw.ru</span>
    </div>
</div>
</body>
</html>