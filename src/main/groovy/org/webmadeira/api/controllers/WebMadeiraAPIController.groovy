package org.webmadeira.api.controllers

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.webmadeira.api.models.Event
import org.webmadeira.api.models.Organization
import org.webmadeira.api.models.Speaker
import org.webmadeira.api.models.Talk
import org.webmadeira.api.services.WebMadeiraService


@RestController
@EnableAutoConfiguration
@RequestMapping(value="/")
@Api( value = "Web Madeira", description = "Allows to gather data about Web Madeira conferences")
class WebMadeiraAPIController {

    @Autowired
    WebMadeiraService webMadeiraService


    @ApiOperation(value = "Retrieves Web Madeira Organization's info", response = Organization.class)
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "Web Madeira Organization's info was successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach does not exists")
    ])

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json")
    Organization getOrganizationInfo() {
        webMadeiraService.getOrganizationInfo()
    }


    @ApiOperation(value = "Retrieves all the eventsByYear of WebMadeira")
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "Web Madeira eventsByYear were successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach does not exists")
    ])

    @RequestMapping(value = "/events", method = RequestMethod.GET, produces = "application/json")
    List<Event> getEvents() {
        webMadeiraService.getAllEvents()
    }


    @ApiOperation(value = "Retrieves all talks of an event on a given year", response = Talk.class, responseContainer = "List")
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "Web Madeira eventsByYear were successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach does not exists")
    ])

    @RequestMapping(value = "/events/{year}/talks", method = RequestMethod.GET, produces = "application/json")
    List<Talk> getEventTalks(@PathVariable int year) {
        webMadeiraService.getEventTalks(year)
    }


    @ApiOperation(value = "Retrieves all speakers for a Web Madeira's event on a given year", response = Speaker.class, responseContainer = "List")
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "Web Madeira event speakers were successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach does not exists")
    ])

    @RequestMapping(value = "/events/{year}/speakers", method = RequestMethod.GET, produces = "application/json")
    List<Speaker> getEventSpeakers(@PathVariable int year) {
        webMadeiraService.getEventSpeakers(year)
    }


    @ApiOperation(value = "Retrieves the Speaker of a given Talk")
    @ApiResponses(value = [
            @ApiResponse(code = 200, message = "Requested Speaker was successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach does not exists")
    ])

    @RequestMapping(value = "/events/{year}/talks/{talkId}/speakers", method = RequestMethod.GET, produces = "application/json")
    Speaker getSpeakerbyTalkId(@PathVariable int year, @PathVariable int talkId) {
        webMadeiraService.getSpeakerByTalkId(year, talkId)
    }
}
