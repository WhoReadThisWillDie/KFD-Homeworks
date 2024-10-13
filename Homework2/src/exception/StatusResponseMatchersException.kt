package exception

class StatusResponseMatchersException(code: Int) : ResponseMatchersException("Wrong status code - $code")