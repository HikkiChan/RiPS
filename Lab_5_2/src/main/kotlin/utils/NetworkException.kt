package utils

sealed class NetworkException(message: String, e: Throwable) : Exception(message, e)
class ClientCreationException(message: String, e: Throwable) : NetworkException(message, e)
class ClientRegistrationException(message: String, e: Throwable) : NetworkException(message, e)
class ReadException(message: String, e: Throwable) : NetworkException(message, e)
class SelectorException(message: String, e: Throwable) : NetworkException(message, e)
class ServerCreationException(message: String, e: Throwable) : NetworkException(message, e)
class WriteException(message: String, e: Throwable) : NetworkException(message, e)