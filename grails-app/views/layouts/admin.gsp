<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin: <g:layoutTitle default="Dent"/></title>
    <link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <asset:stylesheet href="admin.css"/>
    <asset:javascript src="admin-head.js"/>
    <asset:javascript src="ckeditor/ckeditor.js" />
    <g:layoutHead/>
</head>
<body>
    <div class="admin-left-back"></div>
    <div class="admin-right-back"></div>

    <div class="admin-wrapper">
    <div class="admin-header">
        <div class="admin-header-content">
            <a href="#"><asset:image src="admin/house-logo.png" alt="" class="admin-house-logo" /></a>
            <ul class="admin-menu">
                <li><a href="#"><div class="menu-icon-exit"></div><span>Выход</span></a></li>
                <li><a href="#"><div class="menu-icon-2"></div><span>Настройки</span></a></li>
            </ul>
        </div>
    </div>

    <div class="admin-container">
    <div class="admin-middle-back"></div>
    <div class="admin-sidebar">
        <div class="admin-sidebar-back"></div>
        <div class="admin-sidebar-content">
            <h1>Карта сайта</h1>
            <ul id="admin-map" class="treeview">
                <ha:adminMenuLink name="Акции"
                                  link-edit="${createLink(controller: 'adminAcceptor')}"
                                  link-add="${createLink(controller: 'adminAcceptor', action: 'add')}"
                                  link-view="${createLink(controller: 'acceptor')}" />
                <ha:adminMenuLink name="Реклама"
                                  link-edit="${createLink(controller: 'adminAdvertisement')}"
                                  link-add="${createLink(controller: 'adminAdvertisement', action: 'add')}" />
        </div>
    </div>
    <div class="admin-content-bg">
        <div class="admin-content">
            <g:layoutBody/>
        </div>
    </div>
    </div>

    <div class="admin-push"></div>
    </div>
    <div class="admin-footer">
        <p>&#169; <a href="#" target="_blank" alt="Сайт студии House">Студия House</a>, 2011 - 2014</p>
    </div>
    <asset:javascript src="admin-defer.js" />
</body>
</html>