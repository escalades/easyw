package ru.housevl.easyway

class EasyWayTagLib {
    static defaultEncodeAs = 'none'
    static namespace = "ew"
    def authService

    /**
     * @attr p REQUIRED
     * @attr per REQUIRED
     * @attr total REQUIRED
     */
    def paginator = { attrs, body ->
        Integer total = attrs.remove('total')
        Integer per = attrs.remove('per')
        Integer p = attrs.remove('p')
        String cls = attrs.get('class') ? " " + attrs.remove('class') : ""

        def pageCount = (total / per) + (total % per ? 1 : 0) ?: 1

        if (pageCount > 1) {
        out << "<div class=\"b-pager$cls\" ${paramsToHtmlAttr(attrs)}>"

        (1..pageCount).each {
            if (it == 1 || it == pageCount || (it > p - 3 && it < p + 3))
                if (it == p)
                    out << "<a class=\"active\">${it}</a>"
                else
                    out << "<a href=\"${body(it).trim()}\">${it}</a>"
            else if (it == p + 3 || it == p - 3)
                out << "<a href=\"${body(it).trim()}\">..</a>"
        }

        out << "</div>"
        }
    }

    def isAuthorized = { attrs, body ->
        if (authService.isAuthorized())
            out << body(authService.currentUserName)
    }

    def notAuthorized = { attrs, body ->
        if (!authService.isAuthorized())
            out << body()
    }

    private paramsToHtmlAttr(attrs) {
        attrs.collect { key, value -> "${key}=\"${value.toString().replace('\'', '\\\'')}\"" }?.join(" ")
    }
}
