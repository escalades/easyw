package ru.housevl.easyway

class AdminAdvertisementController {

    static layout = "admin"
    static defaultAction = "list"

    def advertisementService

    def list() {
        Integer p = params.getInt('p', 1)
        if (p < 1) p = 1

        Integer per = params.getInt('per', 10)
        if (per < 10) per = 10

        def paginateParams = [offset: (p-1) * per, max: per, sort: 'dateCreated']

        List<Advertisement> items
        Integer total
        String q = params.get('q', '')
        if (q) {
            items = Advertisement.findAllByTitleLike("%$q%", paginateParams)
            total = Advertisement.findAllByTitleLike("%$q%").size()
        } else {
            items = Advertisement.list(paginateParams)
            total = Advertisement.list().size()
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
            render(view: "edit", model: [item: new Advertisement()])
    }

    def edit() {
        Advertisement item = flash.item ?: Advertisement.get(params.getLong('id'))
        if (!item)
            return render(status: 404)

        [item: item]
    }

    def save(AdvertisementSaveCommand command) {
        Advertisement item = command.id ? Advertisement.get(command.id) : new Advertisement()
        if (!item)
            return render(status: 404)

        bindData(item, command)

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
        def adv = Advertisement.get(params.getInt('id'))
        def count = advertisementService.deleteViewsForAdvertisement(adv)
        adv.delete()
        flash.message = "Реклама и $count просмотра удалны"
        redirect(uri: request.getHeader('referer'))
    }

    def publish() {
        def item = Advertisement.get(params.getInt('id'))
        if (item) {
            item.isPublished = params.getBoolean('value')
            if (item.save())
                return render(status: 200)
        }
        render(status: 404)
    }
}
