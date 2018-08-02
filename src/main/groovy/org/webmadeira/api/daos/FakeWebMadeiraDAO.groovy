package org.webmadeira.api.daos

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import org.webmadeira.api.models.Event
import org.webmadeira.api.models.Organization
import org.webmadeira.api.models.Social
import org.webmadeira.api.models.Speaker
import org.webmadeira.api.models.Talk

@Repository
@Qualifier("fakeDAO")
class FakeWebMadeiraDAO implements IWebMadeiraDAO {

    Organization organization

    FakeWebMadeiraDAO() {
        genFakeData()
    }

    @Override
    Organization getOrganizationInfo() {

        Organization org = new Organization()

        org.setName(organization.getName())
        org.setSocial(organization.getSocial())

        org
    }

    @Override
    List<Event> getAllEvents() {

        List<Event> events = []
        organization.getEventsByYear().values().each { e ->

            Event ev = new Event()
            ev.setTitle(e.getTitle())
            ev.setDescription(e.getDescription())
            ev.setDate(e.getDate())

            events.add(ev)
        }

        events
    }

    @Override
    List<Talk> getEventTalks(int eventYear) {

        List<Talk> talks = []
        organization.getEventsByYear().get(eventYear).getTalksbyId().values().each { talk ->

            Talk t = new Talk()

            t.setId(talk.getId())
            t.setTitle(talk.getTitle())
            t.setDescription(talk.getDescription())
            t.setTime(talk.getTime())
            t.setType(talk.getType())

            talks.add(t)
        }

        talks
    }

    @Override
    List<Speaker> getEventSpeakers(int eventYear) {

        List<Speaker> speakers = []
        organization.getEventsByYear().get(eventYear).getTalksbyId().values().each { talk ->
            speakers.add(talk.getSpeaker())
        }

        speakers
    }

    @Override
    Speaker getSpeakerByTalkId(int eventYear, int talkId) {
        organization.getEventsByYear().get(eventYear).getTalksbyId().get(talkId).getSpeaker()
    }



    def genFakeData() {

        organization = new Organization()
        organization.setName("Web Madeira")
        organization.setSocial([
                new Social("youtube", "https://youtube.com/webmadeira"),
                new Social("twitter", "https://twitter.com/webmadeira")
        ])

        Event ev = new Event()
        ev.setTitle("Web Madeira 2018")
        ev.setDate("2018-12-29")
        ev.setDescription("Tortor at risus viverra adipiscing at in tellus integer feugiat")

        organization.addEvent(2018, ev)

        Talk talk = new Talk()
        talk.setId(1)
        talk.setType(Talk.Type.THEME)
        talk.setTime(20)
        talk.setTitle("Suscipit tellus mauris a diam maecenas sed")
        talk.setDescription("Pretium aenean pharetra magna ac placerat vestibulum. Tellus in metus vulputate eu scelerisque felis imperdiet proin. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed")

        ev.addTalk(talk.getId(), talk)

        Speaker speaker = new Speaker()
        speaker.setName("John Doe")
        speaker.setPersonalWebsite("https://john.doe")
        speaker.setCompany("Nan")
        speaker.setJobWebsite("https://nan.com")
        speaker.setJobTitle("Software Developer")

        talk.setSpeaker(speaker)

        talk = new Talk()
        talk.setId(2)
        talk.setTime(20)
        talk.setType(Talk.Type.THEME)
        talk.setTitle("Suscipit tellus mauris a diam maecenas sed")
        talk.setDescription("Pretium aenean pharetra magna ac placerat vestibulum. Tellus in metus vulputate eu scelerisque felis imperdiet proin. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed")

        talk.setSpeaker(speaker)
        ev.addTalk(talk.getId(), talk)

        talk = new Talk()
        talk.setId(3)
        talk.setTime(20)
        talk.setType(Talk.Type.THEME)
        talk.setTitle("Suscipit tellus mauris a diam maecenas sed")
        talk.setDescription("Pretium aenean pharetra magna ac placerat vestibulum. Tellus in metus vulputate eu scelerisque felis imperdiet proin. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed")

        talk.setSpeaker(speaker)
        ev.addTalk(talk.getId(), talk)

        talk = new Talk()
        talk.setId(4)
        talk.setTime(5)
        talk.setType(Talk.Type.EXPRESS)
        talk.setTitle("Suscipit tellus mauris a diam maecenas sed")
        talk.setDescription("Pretium aenean pharetra magna ac placerat vestibulum. Tellus in metus vulputate eu scelerisque felis imperdiet proin. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed")

        talk.setSpeaker(speaker)
        ev.addTalk(talk.getId(), talk)
    }
}
