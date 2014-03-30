import grails.util.Environment
import grails.util.GrailsUtil
import ru.housevl.easyway.Acceptor
import ru.housevl.easyway.Advertisement
import ru.housevl.easyway.View
import ru.housevl.easyway.Viewer

class BootStrap {

    def init = { servletContext ->
        if (Environment.isDevelopmentMode()) {
            def a = new Acceptor(
                    name: "test",
                    annotation: "test",
                    content: "test",
                    notes: "test",
                    image: "ych2g0x6dui9atv7nhcb",
                    url: "test",
                    wherewithalText: "test",
                    wherewithal: 1000,
                    collectedFunds: 100,
                    thanks: "test",
                    isPublished: true
            ).save(flush: true)
            3.times {
                def b = new Acceptor(
                        name: "test$it",
                        annotation: "test$it",
                        content: "test$it",
                        notes: "test$it",
                        image: "ych2g0x6dui9atv7nhcb",
                        url: "test$it",
                        wherewithalText: "test$it",
                        wherewithal: 1000,
                        collectedFunds: 100,
                        thanks: "test$it",
                        isPublished: true
                ).save(flush: true)
            }
            6.times {
                def b = new Acceptor(
                        name: "finished_test$it",
                        annotation: "finished_test$it",
                        content: "finished_test$it",
                        notes: "finished_test$it",
                        image: "ych2g0x6dui9atv7nhcb",
                        url: "finished_test$it",
                        wherewithalText: "finished_test$it",
                        wherewithal: 1000,
                        collectedFunds: 100,
                        thanks: "tefinished_testst$it",
                        isPublished: true,
                        isFinished: true
                ).save(flush: true)
            }
            def adv = new Advertisement(
                    title: "adv-test-1",
                    videoUrl: "asdasdas",
                    spentFunds: 0,
                    budget: 1000,
                    rate: 10,
                    isPublished: true
            ).save(flush: true)

            def asd = new Advertisement(
                    title: "adv-test-2",
                    videoUrl: "xx",
                    spentFunds: 0,
                    budget: 10000,
                    rate: 10,
                    isPublished: true
            ).save(flush: true)
            10.times {

                def v = new Viewer(
                        network: "test",
                        uid: "u$it"
                ).save(flush: true)
                new View(
                        acceptor: a,
                        advertisement: adv,
                        viewer: v,
                        rate: 10
                ).save(flush: true)
            }
        }
    }
    def destroy = {
    }
}
