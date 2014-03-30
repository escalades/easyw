package ru.housevl.easyway

class AuthController {

    static layout = "main"

    def authService

    def index() {
        def acceptor = Acceptor.get(params.getLong("acceptorId"))
        if (!acceptor)
            render(status: 404)

        if (authService.isAuthorized())
            redirect(controller: "advertisement", action: "show", params: [url: acceptor.url])
        else
            [acceptorId: acceptor.id]
    }

    def check() {
        def acceptor = Acceptor.get(params.getLong('acceptorId'))
        if (!params.token || !acceptor)
            render(status: 404)

        authService.authorize(params.token)
        redirect(controller: "advertisement", action: "show", params: [url: acceptor.url])
    }

    def receiver() {
        render(template: '/templates/site/receiver')
    }
}
