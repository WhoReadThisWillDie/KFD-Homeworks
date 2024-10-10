package response

import exception.BodyResponseMatchersException
import exception.StatusResponseMatchersException

class ResponseActions(val response: Response) {
    fun andExpect(callback: ResponseMatcher.() -> Unit): ResponseActions {
        ResponseMatcher().callback()
        return this
    }

    fun andDo(callback: (Response) -> Unit): ResponseActions {
        callback(response)
        return this
    }

    inner class ResponseMatcher {
        fun status(statusCallback: StatusResponseMatcher.() -> Unit) {
            StatusResponseMatcher().statusCallback()
        }

        fun body(bodyCallback: BodyResponseMatcher.() -> Unit) {
            BodyResponseMatcher().bodyCallback()
        }
    }

    inner class StatusResponseMatcher {
        fun isOk() {
            if (response.code != 200) {
                throw StatusResponseMatchersException(response.code)
            }
        }

        fun isBadRequest() {
            if (response.code != 400) {
                throw StatusResponseMatchersException(response.code)
            }
        }

        fun isInternalServerError() {
            if (response.code != 500) {
                throw StatusResponseMatchersException(response.code)
            }
        }
    }

    inner class BodyResponseMatcher {
        fun isNull() {
            if (response.body != null) {
                throw BodyResponseMatchersException("response.Response body is not null")
            }
        }

        fun isNotNull() {
            if (response.body == null) {
                throw BodyResponseMatchersException("response.Response body is null")
            }
        }
    }


}