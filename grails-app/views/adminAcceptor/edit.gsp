<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${item.id ? item.name : "Добавить акцию"}</title>
</head>

<body>
    <div class="header"><h1>${item.id ? item.name : "Добавить акцию"}</h1></div>
    <div class="line-menu">
        <a href="${createLink(action: 'list')}" class="icon-list">Список</a>
        <g:if test="${item.id}">
            <a href="${createLink(action: 'add')}" class="icon-add">Добавить</a>
            <a class="icon-edit active">Редактировать</a>
            <a class="icon-view" href="${createLink(controller: 'acceptor', action: 'show', id: item.id)}">Просмотр</a>
        </g:if>
        <g:else>
            <a class="icon-add active">Добавить</a>
            <a class="icon-edit disable">Редактировать</a>
            <a class="icon-view disable">Просмотр</a>
        </g:else>
    </div>
    <g:if test="${flash.message}">
        <div class="text-success">${flash.message}</div>
    </g:if>

    <g:uploadForm action="save" id="${item.id ?: ''}" name="edit">
        <ha:label label="Название" />
        <ha:textField field="name" bean="${item}"
                      placeholder="Введите название" />

        <ha:label label="Url страницы" />
        <ha:textField field="url" bean="${item}"
                      placeholder="Введите URL сраницы"
                      prefix="${ha.serverUrl()}"/>

        <ha:label label="Краткое описание" />
        <ha:textArea field="annotation" bean="${item}" />

        <ha:label label="Описание" />
        <ha:ckeditor field="content" bean="${item}" />

        <ha:label label="Дополнительная информация" />
        <ha:ckeditor field="notes" bean="${item}" />

        <ha:label label="Изображение" />
        <ha:imageUpload field="image" bean="${item}" />

        <ha:label label="Необходимая сумма - текст" />
        <ha:textField field="wherewithalText" bean="${item}"
                      placeholder="Текстовая информация о необходимой сумме" />

        <ha:label label="Необходимая сумма - число" />
        <ha:textField field="wherewithal" bean="${item}"
                      placeholder="Введите необходимую сумму числом" />

        <ha:label label="Благодарность" />
        <ha:textArea field="thanks" bean="${item}" />

        <ha:label label="Дата перевода средств" />
        <ha:datePicker field="transferDate" bean="${item}" />

        <ha:label label="Дополнительные параметры" />
        <ha:checkbox field="isPublished" bean="${item}"
                     label="Опубликовать на сайте" />
        <ha:checkbox field="isFinished" bean="${item}"
                     label="Акция закончена" />

        <div class="col-md-11" style="margin-top: 30px;">
            <a class="btn btn-danger submit-form">
                <span class="glyphicon glyphicon-ok"></span>Сохранить изменения
            </a>
        </div>
    </g:uploadForm>
</body>
</html>