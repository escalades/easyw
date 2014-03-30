package ru.housevl.easyway

class AcceptorController {

    static layout = "main"

    def index() {
        def acceptors = Acceptor.available.list(max: 4)
        [acceptors: acceptors]
    }

    def show() {
        def acceptor = Acceptor.available.findWhere(url: params.url)
        if (!acceptor)
            return render(status: 404)

        def totalViews = View.countByAcceptor(acceptor)
        def otherAcceptors = Acceptor.available { not { eq 'id', acceptor.id } }

        [acceptor:acceptor, totalViews: totalViews, otherAcceptors: otherAcceptors]
    }

    def finished() {
        def perPage = 4
        Integer currentPage = params.getInt('p', 1)

        def total = Acceptor.finished.count()
        if (currentPage < 1 || currentPage > Math.ceil(total / perPage))
            return render(status: 404)

        def acceptors = Acceptor.finished.list(
                offset: (currentPage - 1) * perPage,
                max: perPage,
                sort: 'transferDate',
                order: "desc"
        )

        [acceptors: acceptors, total: total, currentPage: currentPage, perPage: perPage]
    }
}
