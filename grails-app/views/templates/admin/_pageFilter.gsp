<div class="col-md-11" style="margin: 40px 0 0 0;">
    <ha:paginator total="${total}" per="${filter.per}" p="${filter.p}" style="margin: 0 auto;">
        <g:createLink action="list" params="${filter + [p: it]}"/>
    </ha:paginator>
</div>