<g:hasErrors bean="${bean}" field="${field}">
    <div class="col-md-11">
        <div class="b-new-error">
            <p><g:fieldError field="${field}" bean="${bean}" /></p>
        </div>
    </div>
</g:hasErrors>
<div class="col-md-${fieldSize}">
    ${raw(content)}
</div>