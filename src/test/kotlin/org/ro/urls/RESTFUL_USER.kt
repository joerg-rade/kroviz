package org.ro.to

object RESTFUL_USER {
    val str = """{
        "userName": "sven",
        "roles": ["iniRealm:admin_role"],
        "links": [{
            "rel": "self",
            "href": "http://localhost:8080/restful/user",
            "method": "GET",
            "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/user\""
        }, {
            "rel": "up",
            "href": "http://localhost:8080/restful/",
            "method": "GET",
            "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/homepage\""
        }, {
            "rel": "urn:org.apache.isis.restfulobjects:rels/logout",
            "href": "http://localhost:8080/restful/user/logout",
            "method": "GET",
            "type": "application/jsonprofile=\"urn:org.restfulobjects:repr-types/homepage\""
        }],
        "extensions": {}
    }"""
}
