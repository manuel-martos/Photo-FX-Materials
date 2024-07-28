package com.mmartosdev.photofx.modifiers

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import org.jetbrains.skia.ImageFilter
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder
import org.jetbrains.skia.Shader

actual fun Modifier.shader(
    shader: String,
    uniformsBlock: ShaderUniformProvider.() -> Unit,
): Modifier = this then composed {
    val runtimeShaderBuilder = remember {
        RuntimeShaderBuilder(
            effect = RuntimeEffect.makeForShader(shader),
        )
    }
    val shaderUniformProvider = remember {
        ShaderUniformProviderImpl(runtimeShaderBuilder)
    }
    graphicsLayer {
        clip = true
        renderEffect = ImageFilter.makeShader(
            shader = runtimeShaderBuilder
                .apply { shaderUniformProvider.uniformsBlock() }
                .makeShader(),
            crop = null,
        ).asComposeRenderEffect()
//        renderEffect = ImageFilter.makeRuntimeShader(
//            runtimeShaderBuilder = runtimeShaderBuilder.apply {
//                shaderUniformProvider.uniformsBlock()
//            },
//            shaderName = "content",
//            input = null,
//        ).asComposeRenderEffect()
    }.onSizeChanged {
        shaderUniformProvider.updateResolution(it)
    }
}

private class ShaderUniformProviderImpl(
    private val runtimeShaderBuilder: RuntimeShaderBuilder,
) : ShaderUniformProvider {

    fun updateResolution(size: IntSize) {
        uniform("resolution", size.width.toFloat(), size.height.toFloat())
    }

    override fun uniform(name: String, value: Int) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(name: String, value: Float) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(name: String, value1: Float, value2: Float) {
        runtimeShaderBuilder.uniform(name, value1, value2)
    }

    override fun uniform(name: String, value: Color) {
        runtimeShaderBuilder.uniform(name, value.red, value.green, value.blue, value.alpha)
    }

    override fun uniform(name: String, shader: Shader) {
        runtimeShaderBuilder.child(name, shader)
    }

}
