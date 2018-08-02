package org.webmadeira.api.models

class Event {

    int id
    String title
    String description
    String date
    Map<Integer, Talk> talksbyId

    Event() {}

    void addTalk(int talkId, Talk talk) {

        if(!talksbyId)
            talksbyId = [:]

        talksbyId.put(talkId, talk)
    }
}
