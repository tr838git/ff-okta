package ff

import grails.plugin.springsecurity.annotation.Secured

class HomeController {
    @Secured('ROLE_USER')
    def index() {
        render "success, thanks to the God"
    }
}
