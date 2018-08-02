package org.webmadeira.api

class Playground {

    static void main(String[] args) {

        String regexPath = "/.*"

        println ("/2018/eventsByYear".matches(regexPath)) ? "true" : "false"
    }
}
