<div class="admin-text-view">Показывать по
    <g:each in="${variants}">
        <a href="${createLink(action: 'list', params: filter + [per: it])}"${filter.per == it ? ' class=active' : ''}>${it}</a>
    </g:each>
</div>