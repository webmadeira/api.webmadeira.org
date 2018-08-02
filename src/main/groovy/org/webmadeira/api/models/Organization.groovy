package org.webmadeira.api.models

class Organization {

    int id
    String name
    List<Social> social
    Map<Integer, Event> eventsByYear

    Organization () {}

    void addEvent(int year, Event event) {

        if(!eventsByYear)
            eventsByYear = [:]

        eventsByYear.put(year, event)
    }
}
