package ru.housevl.easyway

class AdvertisementController {

    static layout = "main"

    def authService
    def advertisementService

    def show() {
        def acceptor = Acceptor.available.findWhere(url: params.url)

        if (!acceptor)
            return render(status: 404)

        if(!authService.isAuthorized())
            return redirect(controller: 'auth', action: 'index', params: [acceptorId: acceptor.id])

        def viewer = authService.currentUser
        def totalViews = View.countByAcceptor(acceptor)
        def availableAds = advertisementService.getAdsForViewer(viewer)
        def amount = availableAds.size()
        def advertisement
        if(amount > 0) {
            def random = new Random().nextInt(availableAds.size())
            advertisement = availableAds[random]
        }
        session['advId'] = advertisement.id
        [acceptor: acceptor, totalViews: totalViews, advertisement: advertisement]
    }

    def success() {

        def acceptor = Acceptor.available.findWhere(url: params.url)
        if (!acceptor)
            return render(status: 404)

        if (!authService.isAuthorized())
            redirect(controller: 'acceptor', action: 'show', params: [url : acceptor.url])

        def viewer = authService.currentUser
        try {
            advertisementService.addView(Advertisement.get(session['advId']),acceptor, viewer)
        } catch (Exception e) {
        }
        session.removeAttribute('advId')
        def totalViews = View.countByAcceptor(acceptor)
        def availableAdsAmount = advertisementService.getAdsForViewer(viewer).size()
        def otherAcceptors = Acceptor.available { not { eq 'id', acceptor.id } }

        [
                acceptor: acceptor,
                totalViews: totalViews,
                otherAcceptors: otherAcceptors,
                availableAdsAmount: availableAdsAmount
        ]
    }
}
