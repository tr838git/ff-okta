package com.ff

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

@Secured('ROLE_SELLER')
class ToSellController {

    ToSellService toSellService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond toSellService.list(params), model:[toSellCount: toSellService.count()]
    }

    def show(Long id) {
        respond toSellService.get(id)
    }

    def create() {
        respond new ToSell(params)
    }

    def save(ToSell toSell) {
        if (toSell == null) {
            notFound()
            return
        }

        try {
            toSellService.save(toSell)
        } catch (ValidationException e) {
            respond toSell.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'toSell.label', default: 'ToSell'), toSell.id])
                redirect toSell
            }
            '*' { respond toSell, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond toSellService.get(id)
    }

    def update(ToSell toSell) {
        if (toSell == null) {
            notFound()
            return
        }

        try {
            toSellService.save(toSell)
        } catch (ValidationException e) {
            respond toSell.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'toSell.label', default: 'ToSell'), toSell.id])
                redirect toSell
            }
            '*'{ respond toSell, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        toSellService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'toSell.label', default: 'ToSell'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'toSell.label', default: 'ToSell'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
