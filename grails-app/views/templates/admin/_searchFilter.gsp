<g:form action='search'>
    <div class="col-md-8" style="margin: 20px 0 0 0;">
        <g:textField name="q" class="form-control" placeholder="Поисковый запрос" value="${filter.q}"/>
        <g:each in="${filter + [p: 1]}">
            <g:if test="${it.key != 'q'}">
                <g:hiddenField name="${it.key}" value="${it.value}" />
            </g:if>
        </g:each>
    </div>
    <div class="col-md-3" style="margin: 20px 0 0 0;">
        <a class="btn btn-default submit-form" style="padding-right: 30px;">
            <span class="glyphicon glyphicon-search"></span>Поиск
        </a>
    </div>
</g:form>