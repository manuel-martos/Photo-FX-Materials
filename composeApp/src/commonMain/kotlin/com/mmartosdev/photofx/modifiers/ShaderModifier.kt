package com.mmartosdev.photofx.modifiers

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader

expect fun Modifier.shader(
    shader: String,
    uniformsBlock: ShaderUniformProvider.() -> Unit,
): Modifier

interface ShaderUniformProvider {
    fun uniform(name: String, value: Int)
    fun uniform(name: String, value: Float)
    fun uniform(name: String, value1: Float, value2: Float)
    fun uniform(name: String, value: Color)
    fun uniform(name: String, shader: Shader)
}

