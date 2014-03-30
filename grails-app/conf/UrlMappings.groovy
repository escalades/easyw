class UrlMappings {

	static mappings = {
        "/about"(controller: "page", action:  "about")
        "/politics"(controller:"page", action:  "politics")
        "/cooperation"(controller:"page", action:  "cooperation")
        "/auth"(controller:"auth", action:  "index")
        "/acceptors/$url"(controller:"acceptor", action: "show")
        "/acceptors/finished/$p?"(controller:"acceptor", action: "finished")
        "/acceptors/$url/video"(controller:"advertisement", action: "show")
        "/acceptors/$url/success"(controller:"advertisement", action: "success")
        "/auth/check/$acceptorId"(controller: 'auth', action: 'check')
        "/"(controller: "acceptor", action: "index")
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }
        "404"(view:'/404')
        "500"(view:'/error')
    }
}
