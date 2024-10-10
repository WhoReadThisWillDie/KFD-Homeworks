package client

import response.Response
import response.ResponseActions

class Client {
    fun perform(code: Int, body: String?) = ResponseActions(Response(code, body))
}