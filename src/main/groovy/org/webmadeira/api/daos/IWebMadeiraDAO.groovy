package org.webmadeira.api.daos

import org.webmadeira.api.models.Event
import org.webmadeira.api.models.Organization
import org.webmadeira.api.models.Speaker
import org.webmadeira.api.models.Talk

interface IWebMadeiraDAO {

    Organization getOrganizationInfo()
    List<Event> getAllEvents()
    List<Talk> getEventTalks(int eventYear)
    List<Speaker> getEventSpeakers(int eventYear)
    Speaker getSpeakerByTalkId(int eventYear, int talkId)
}