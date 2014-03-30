<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Акции</title>
</head>

<body>
    <div class="header"><h1>Акции</h1></div>
    <div class="line-menu">
        <a class="icon-list active" href="${createLink(action: 'list')}">Список</a>
        <a class="icon-add" href="${createLink(action: 'add')}">Добавить</a>
        <a class="icon-edit disable">Редактировать</a>
        <a class="icon-view" href="${createLink(controller: 'acceptor')}">Просмотр</a>
    </div>

    <g:if test="${flash.message}">
        <div class="text-success">${flash.message}</div>
    </g:if>

    <g:render template="/templates/admin/searchFilter" model="[filter: filter]" />
    <g:render template="/templates/admin/perFilter" model="[filter: filter, variants: [10, 20, 50, 100]]" />

    <ul class="news">
        <g:each in="${items}" var="item">
            <li>
                <ha:image imageId="${item.image}" height="100" width="100" />
                <div class="text">
                    <h3>${item.name}</h3>
                </div>
                <div class="block">
                    <div class="links">
                        <a href="${createLink(action: 'edit', params: [id: item.id])}" class="icon-edit"></a>
                        <a href="${createLink(action: 'delete', params: [id: item.id])}" class="icon-delete"></a>
                    </div>
                    <div class="news-checkbox">
                        <label class="checkbox" for="checkbox${item.id}">
                            <g:checkBox name="checkbox${item.id}" value="${item.isPublished}" data-toggle="checkbox" />
                            Опубликовать на сайте</label>
                    </div>
                    <div class="date"><span>дата:</span>
                        <ha:formatDate date="${item.dateCreated}" />
                    </div>
                </div>
            </li>
        </g:each>
    </ul>

    <g:render template="/templates/admin/pageFilter" model="[filter: filter, total: total]" />

    <script>
        $("div.news-checkbox input").change(function() {
            var check = $(this);
            $.ajax({
                url: "${createLink(action: 'publish')}",
                type: 'POST',
                data: {'id': check.attr('name').substr(8), 'value': check.is(':checked')}
            })
        })
    </script>
</body>
</html>