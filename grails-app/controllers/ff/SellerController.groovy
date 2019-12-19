package ff

import grails.plugin.springsecurity.annotation.Secured

class SellerController {
    @Secured('ROLE_SELLER')
    def index() {
        render "seller is here"
    }
}
