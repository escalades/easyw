<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${item.id ? item.title : "Добавить рекламу"}</title>
</head>

<body>
    <div class="header"><h1>${item.id ? item.title : "Добавить рекламу"}</h1></div>
    <div class="line-menu">
        <a href="${createLink(action: 'list')}" class="icon-list">Список</a>
        <g:if test="${item.id}">
            <a href="${createLink(action: 'add')}" class="icon-add">Добавить</a>
            <a class="icon-edit active">Редактировать</a>
        </g:if>
        <g:else>
            <a class="icon-add active">Добавить</a>
            <a class="icon-edit disable">Редактировать</a>
        </g:else>
    </div>
    <g:if test="${flash.message}">
        <div class="text-success">${flash.message}</div>
    </g:if>

    <g:uploadForm action="save" id="${item.id ?: ''}" name="edit">
        <ha:label label="Название" />
        <ha:textField field="title" bean="${item}"
                      placeholder="Введите название" />

        <ha:label label="Адрес видео" />
        <ha:textField field="videoUrl" bean="${item}"
                      placeholder="Введите URL видео" />

        <ha:label label="Бюджет" />
        <ha:textField field="budget" bean="${item}"
                      placeholder="Введите кол-во доступных для расхода средств" />

        <ha:label label="Плата за просмотр" />
        <ha:textField field="rate" bean="${item}"
                      placeholder="Введите URL видео" />

        <ha:label label="Дополнительные параметры" />
        <ha:checkbox field="isPublished" bean="${item}"
                     label="Опубликовать на сайте" />

        <div class="col-md-11" style="margin-top: 30px;">
            <a class="btn btn-danger submit-form">
                <span class="glyphicon glyphicon-ok"></span>Сохранить изменения
            </a>
        </div>
    </g:uploadForm>
</body>
</html>