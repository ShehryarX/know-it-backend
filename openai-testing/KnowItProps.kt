package com.codehouse.plugin

object KnowItProps {
    object OpenAI {
        val secretKey: String by lazy {
            val reader = KnowItProps::class.java.classLoader.getResourceAsStream("openai.key")
                ?.bufferedReader(Charsets.UTF_8) ?: error("Failed to open openai.key file!")
            val key = reader.readLine() ?: error("No key present in openai.key!")
            reader.close()
            key
        }

        // Davinci model, can be substituted with Curie for additional speed
        const val summarizeEngine = "davinci"
        // No alternates available
        const val qaEngine = "davinci-instruct"
    }
}