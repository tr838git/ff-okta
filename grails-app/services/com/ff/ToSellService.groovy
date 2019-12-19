package com.ff

import grails.gorm.services.Service

@Service(ToSell)
interface ToSellService {

    ToSell get(Serializable id)

    List<ToSell> list(Map args)

    Long count()

    void delete(Serializable id)

    ToSell save(ToSell toSell)

}