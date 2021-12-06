package com.codehouse.plugin

import com.aallam.openai.api.completion.CompletionRequest
import com.aallam.openai.api.logging.LogLevel
import com.aallam.openai.api.logging.Logger
import com.aallam.openai.client.OpenAI
import com.aallam.openai.client.OpenAIConfig
import com.intellij.openapi.components.Service

@Service
class KnowItNLPService {

    private val openAi = OpenAI(OpenAIConfig(KnowItProps.OpenAI.secretKey, logLevel = LogLevel.None, logger = Logger.Empty))

    // Asks to summarize the given contents into sections of blocks.
    // Use with summaryEngine
    private fun summarizeRequest(content: String) = CompletionRequest(
        temperature = 0.3,
        maxTokens = 60,
        topP = 1.0,
        frequencyPenalty = .3,
        presencePenalty = 0.0,
        bestOf = 1,
        prompt = """
                $content
                
                tl;dr:""".trimIndent(),
    )

    // Use with qaEngine
    private fun questionRequest(content: String) = CompletionRequest(
        temperature = 1.0,
        maxTokens = 64,
        topP = 1.0,
        frequencyPenalty = .0,
        presencePenalty = .0,
        bestOf = 1,
        prompt = """
                $content
                
                What are some key points?
                1.""".trimIndent(),
    )
}