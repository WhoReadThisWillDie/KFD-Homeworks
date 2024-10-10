import client.Client

fun main() {
    val mockClient = Client()
    val response1 = mockClient.perform(200, "OK")
        .andExpect {
            status {
                isOk()
            }
            body {
                isNotNull()
            }
        }.andDo { response ->
            println(response)
        }.response

    val response2 = mockClient.perform(400, null)
        .andExpect {
            status {
                isBadRequest()
            }
            body {
                isNull()
            }
        }.andDo { response -> println(response) }.response

    val response3 = mockClient.perform(500, null)
        .andExpect {
            status {
                isInternalServerError()
            }
            body {
                isNotNull() // will throw an exception because body is null
            }
        }.andDo { response -> println(response) }.response
}