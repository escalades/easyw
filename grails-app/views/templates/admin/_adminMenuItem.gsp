<li>
    <div class="map-block">
        <div class="links">
            <g:if test="${linkAdd}">
                <a href="${linkAdd}" class="icon-add"></a>
            </g:if>
            <g:if test="${linkView}">
                <a href="${linkView}" class="icon-view"></a>
            </g:if>
        </div>
        <a href="${linkEdit}">${name}</a>
    </div>
</li>