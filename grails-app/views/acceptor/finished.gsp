<html>
<head>
    <title>Easyway - простой способ помочь людям.</title>
</head>
<body>
<div class="b-headline-big">
        <div class="b-block">
            <span class="b-treangle"></span>
            <h2>Прошедшие акции</h2>
        </div>
    </div>
    <div class="b-index-items reports">
        <div>
            <g:each in="${acceptors}" var="item">
                <div class="b-report">
                    <div class="b-image">
                        <ha:image imageId="${item.image}" width="537" height="359"/>
                    </div>
                    <div class="b-info">
                        <h1>${item.name}</h1>
                        <div class="b-text">
                            <h3>Причина:</h3>${item.annotation}
                        </div>
                        <div class="b-text">
                            <h3>Собранные средства:</h3>
                            <h4>${item.collectedFunds} руб.</h4>
                            Собранные средства были переданы  <g:formatDate format="dd-MM-yyyy" date="${item.transferDate}"/>
                        </div>
                        <div class="b-line"></div>
                        <div class="b-text">
                           ${raw(item.thanks)}
                        </div>
                    </div>
                </div>
            </g:each>
            <div class="b-pager-bg">
                    <ew:paginator total="${total}" per="${perPage}" p="${currentPage}">
                        <g:createLink action="finished" params="${[p: it]}"/>
                    </ew:paginator>
            </div>

        </div>
    </div>

    <div class="b-push"></div>
</body>
</html>