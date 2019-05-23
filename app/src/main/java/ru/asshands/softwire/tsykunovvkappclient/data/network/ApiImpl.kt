package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse

class ApiImpl: Api {
    override fun login(name: String, password: String): Single<ProfileResponse> {
        val response = ProfileResponse(id = 0, firstName = "N/A", lastName = "N/A")
        if (name == "test" && password == "123") {
            response.id = 666
            response.firstName = "Alexey"
            response.lastName = "Tsykunov"
            TODO("возврат запроса")
             return response
        } else {
            TODO("возврат запроса")
            return response
        }
    }
}