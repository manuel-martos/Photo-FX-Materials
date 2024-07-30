import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.CanvasBasedWindow
import com.mmartosdev.photofx.materials.AssetContainer
import com.mmartosdev.photofx.materials.AssetGallery
import com.mmartosdev.photofx.materials.AssetType
import com.mmartosdev.photofx.materials.asset01.FragmentShaderContent
import com.mmartosdev.photofx.materials.asset02.LinearGradientContent
import com.mmartosdev.photofx.materials.asset03.StripeContent
import com.mmartosdev.photofx.materials.asset04.ShaderAsUniformContent
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("MediumCompose") {
            MaterialTheme {
                    var assetType by remember { mutableStateOf(URLSearchParams(window.location.search).get("asset")?.toAssetType()) }
                when (assetType) {
                    AssetType.ASSET01 ->
                        AssetContainer { FragmentShaderContent() }

                    AssetType.ASSET02 ->
                        AssetContainer { LinearGradientContent() }

                    AssetType.ASSET03 ->
                        AssetContainer { StripeContent() }

                    AssetType.ASSET04 ->
                        AssetContainer { ShaderAsUniformContent() }

                    null ->
                        AssetGallery(
                            onAssetSelected = { assetType = it },
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        )
                }
            }
        }
    }
}

private fun String.toAssetType(): AssetType? = when (this) {
    "asset01" -> AssetType.ASSET01
    "asset02" -> AssetType.ASSET02
    "asset03" -> AssetType.ASSET03
    "asset04" -> AssetType.ASSET04
    else -> null
}
