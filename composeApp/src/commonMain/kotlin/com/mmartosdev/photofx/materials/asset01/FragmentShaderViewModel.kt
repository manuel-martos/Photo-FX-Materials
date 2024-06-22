package com.mmartosdev.photofx.materials.asset01

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Immutable
data class Pixel(
    val x: Int,
    val y: Int,
    val color: Color,
)

@Immutable
data class PixelSet(
    val pixels: List<Pixel> = emptyList(),
    val duration: Int = 0,
)

class FragmentShaderViewModel : ViewModel() {
    private val _highlightedPixelSet = MutableStateFlow(PixelSet())
    val highlightedPixelSet = _highlightedPixelSet.asStateFlow()

    private val _pixels = MutableStateFlow(emptyList<Pixel>())
    val pixels = _pixels.asStateFlow()

    private val _fadeOutPixels = MutableStateFlow<Int?>(null)
    val fadeOutPixels = _fadeOutPixels.asStateFlow()

    fun highlightPixel(x: Int, y: Int, color: Color, duration: Int) {
        _highlightedPixelSet.update { curPixelSet ->
            _pixels.update { curPixels ->
                curPixels + curPixelSet.pixels
            }
            PixelSet(listOf(Pixel(x, y, color)), duration)
        }
    }

    fun highlightPixels(vararg pixels: Pixel, duration: Int) {
        _highlightedPixelSet.update { curPixelSet ->
            _pixels.update { curPixels ->
                curPixels + curPixelSet.pixels
            }
            PixelSet(pixels.asList(), duration)
        }
    }

    fun fadeOutPixels(duration: Int) {
        _fadeOutPixels.update {
            duration
        }
        _highlightedPixelSet.update { curPixelSet ->
            _pixels.update { curPixels ->
                curPixels + curPixelSet.pixels
            }
            PixelSet()
        }
    }

    fun clear() {
        _pixels.update {
            emptyList()
        }
        _fadeOutPixels.update {
            null
        }
    }
}
