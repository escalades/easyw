package ru.housevl.easyway

import grails.transaction.Transactional
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import org.codehaus.groovy.grails.web.util.WebUtils

@Transactional
class AuthService {

    def grailsApplication

    Viewer authorize(String token) {
        def http = new HTTPBuilder('http://ulogin.ru')
        def json = http.get(contentType: ContentType.JSON, path: '/token.php',
                query: [token: token, host: grailsApplication.config.grails.serverURL])

        if (!json.network || !json.uid)
            throw new IllegalArgumentException('Wrong token')

        def viewer = Viewer.findByNetworkAndUid(json.network, json.uid) ?:
                new Viewer(network: json.network, uid: json.uid).save()

        session['viewerId'] = viewer.id
        if (json.first_name || json.last_name)
            session['viewerName'] = json.first_name ?: '' + ' ' + json.last_name ?: ''

        return viewer
    }

    Boolean isAuthorized() {
        session['viewerId'] != null
    }

    Viewer getCurrentUser() {
        View.get(session['viewerId'])
    }

    String getCurrentUserName() {
        session['viewerName']
    }

    private def getSession() {
        WebUtils.retrieveGrailsWebRequest().getSession()
    }
}