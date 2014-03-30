package ru.housevl.easyway

class AdminAcceptorController {

    static layout = "admin"
    static defaultAction = "list"

    def imageService
    def advertisementService

    def list() {
        Integer p = params.getInt('p', 1)
        if (p < 1) p = 1

        Integer per = params.getInt('per', 10)
        if (per < 10) per = 10

        def paginateParams = [offset: (p-1) * per, max: per, sort: 'dateCreated']

        List<Acceptor> items
        Integer total
        String q = params.get('q', '')
        if (q) {
            items = Acceptor.findAllByNameLike("%$q%", paginateParams)
            total = Acceptor.findAllByNameLike("%$q%").size()
        } else {
            items = Acceptor.list(paginateParams)
            total = Acceptor.list().size()
        }

        [items: items, total: total, filter: [q: q, p: p, per: per]]
    }

    def search() {
        def prm = [:]
        if (params.get('q'))
            prm.put('q', params.remove('q'))
        prm.put('per', params.remove('per'))

        redirect(action: 'list', params: prm)
    }

    def add() {
        if (flash.item) {
            render(view: "edit", model: [item: flash.item])
        } else
            render(view: "edit", model: [item: new Acceptor()])
    }

    def edit() {
        Acceptor item = flash.item ?: Acceptor.get(params.getLong('id'))
        if (!item)
            return render(status: 404)

        [item: item]
    }

    def save(AcceptorSaveCommand command) {
        Acceptor item = command.id ? Acceptor.get(command.id) : new Acceptor()
        if (!item)
            return render(status: 404)

        bindData(item, command, [exlude: ['imageId', 'imageFile']])
        if (command.imageFile && !command.imageFile.empty)
            item.image = imageService.uploadImage(command.imageFile)
        else if (command.imageId)
            item.image = command.imageId

        if (!item.save())
            flash.item = item
        else
            flash.message = "Изменения успешно сохранены"

        if (item.id) {
            redirect(action: 'edit', params: [id: item.id])
        } else {
            redirect(action: 'add')
        }
    }

    def delete() {
        def acceptor = Acceptor.get(params.getInt('id'))
        def count = advertisementService.deleteViewsForAcceptor(acceptor)
        acceptor.delete()
        flash.message = "Акция и $count просмотра удалены"
        redirect(uri: request.getHeader('referer'))
    }

    def publish() {
        def item = Acceptor.get(params.getInt('id'))
        if (item) {
            item.isPublished = params.getBoolean('value')
            if (item.save())
                return render(status: 200)
        }
        render(status: 404)
    }
}
