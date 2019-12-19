package com.ff

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ToSellServiceSpec extends Specification {

    ToSellService toSellService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ToSell(...).save(flush: true, failOnError: true)
        //new ToSell(...).save(flush: true, failOnError: true)
        //ToSell toSell = new ToSell(...).save(flush: true, failOnError: true)
        //new ToSell(...).save(flush: true, failOnError: true)
        //new ToSell(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //toSell.id
    }

    void "test get"() {
        setupData()

        expect:
        toSellService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ToSell> toSellList = toSellService.list(max: 2, offset: 2)

        then:
        toSellList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        toSellService.count() == 5
    }

    void "test delete"() {
        Long toSellId = setupData()

        expect:
        toSellService.count() == 5

        when:
        toSellService.delete(toSellId)
        sessionFactory.currentSession.flush()

        then:
        toSellService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ToSell toSell = new ToSell()
        toSellService.save(toSell)

        then:
        toSell.id != null
    }
}
