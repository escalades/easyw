package ru.housevl.easyway

import grails.transaction.Transactional
import grails.validation.ValidationException


@Transactional
class AdvertisementService {

    def getAdsForViewer(Viewer viewer) {
        def watchedAds = View.findAllByViewer(viewer)*.advertisementId
        if (watchedAds)
            Advertisement.available {
               not { inList 'id', watchedAds }
            }
        else
            Advertisement.available.list()
    }

    void addView(Advertisement adv, Acceptor acceptor, Viewer viewer) {
        adv.spentFunds += adv.rate
        acceptor.collectedFunds += adv.rate
        def view = new View(advertisement: adv, acceptor: acceptor, viewer: viewer, rate: adv.rate)

        if (!adv.save(flush: true))
            throw new ValidationException("Not enough minerals", adv.errors)
        if (!view.save(flush: true))
            throw new ValidationException("Viewer already watched this adv", view.errors)
        acceptor.save()
    }

    Integer deleteViewsForAcceptor(Acceptor acceptor) {
        View.withCriteria {
            eq 'acceptor', acceptor
            projections {
                groupProperty 'advertisement', 'advertisement'
                sum 'rate', 'total'
            }
        }.each {
            def adv = it[0] as Advertisement
            adv.spentFunds -= it[1]
            adv.save()
        }
        View.where { eq 'acceptor', acceptor }.deleteAll()
    }

    Integer deleteViewsForAdvertisement(Advertisement advertisement) {
        View.withCriteria {
            eq 'advertisement', advertisement
            projections {
                groupProperty 'acceptor', 'acceptor'
                sum 'rate', 'total'
            }
        }.each {
            def adv = it[0] as Acceptor
            adv.collectedFunds -= it[1]
            adv.save()
        }
        View.where { eq 'advertisement', advertisement }.deleteAll()
    }

}
