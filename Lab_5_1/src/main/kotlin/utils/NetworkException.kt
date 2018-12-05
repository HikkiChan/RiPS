package utils

sealed class NetworkException(message: String, e: Throwable) : Exception(message, e)
class AcceptException(message: String, e: Throwable) : NetworkException(message, e)
class ClientCreationException(message: String, e: Throwable) : NetworkException(message, e)
class ReadException(message: String, e: Throwable) : NetworkException(message, e)
class ServerCreationException(message: String, e: Throwable) : NetworkException(message, e)