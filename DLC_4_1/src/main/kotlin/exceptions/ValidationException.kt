package exceptions

class ValidationException(msg: String, e: Throwable) : Exception(msg, e)