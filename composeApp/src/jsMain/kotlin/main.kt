import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.mmartosdev.photofx.materials.AssetContainer
import com.mmartosdev.photofx.materials.asset01.FragmentShaderContent
import kotlinx.browser.window
import org.jetbrains.skiko.wasm.onWasmReady
import org.w3c.dom.url.URLSearchParams

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("MediumCompose") {
            MaterialTheme {
                val queryParams = URLSearchParams(window.location.search)
                when (queryParams.get("sample")) {
                    else ->
                        AssetContainer { modifier ->
                            FragmentShaderContent(modifier)
                        }
                }
            }
        }
    }
}
