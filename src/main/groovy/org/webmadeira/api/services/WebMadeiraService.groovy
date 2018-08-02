package org.webmadeira.api.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.webmadeira.api.daos.IWebMadeiraDAO
import org.webmadeira.api.models.Event
import org.webmadeira.api.models.Organization
import org.webmadeira.api.models.Speaker
import org.webmadeira.api.models.Talk

@Service
class WebMadeiraService {

    @Autowired
    @Qualifier("fakeDAO")
    IWebMadeiraDAO fakeWebMadeiraDAO

    Organization getOrganizationInfo() {
        fakeWebMadeiraDAO.getOrganizationInfo()
    }

    List<Event> getAllEvents() {
        fakeWebMadeiraDAO.getAllEvents()
    }

    List<Talk> getEventTalks(int eventYear) {
        fakeWebMadeiraDAO.getEventTalks(eventYear)
    }

    List<Speaker> getEventSpeakers(int eventYear) {
        fakeWebMadeiraDAO.getEventSpeakers(eventYear)
    }

    Speaker getSpeakerByTalkId(int eventYear, int talkId) {
        fakeWebMadeiraDAO.getSpeakerByTalkId(eventYear, talkId)
    }
}
