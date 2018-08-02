package org.webmadeira.api.models

class Talk {

    enum Type {
        EXPRESS("express"),
        THEME("theme")

        String type

        Type(String type) {
            this.type = type
        }
    }

    int id

    String title
    String description
    int time
    Type type
    Speaker speaker

    Talk() {}
}
